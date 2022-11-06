package pw.reservas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Types;

public class ReservaAdultosDAO extends ReservaDAO {
	
	
	
	public void insertaReservaAdultos(ReservaAdultosDTO r) {
	
		try{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(getProps().getProperty("inserta-reserva"), PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1,r.getIdReserva());
			ps.setString(2,r.getIdUsuario());
			ps.setInt(3,r.getMinutosReserva());
			ps.setFloat(4, r.getPrecioPista());
			ps.setInt(5, r.getDescuento());
			ps.setString(6, r.getModalidad());
			ps.setInt(7, r.getIdPista());
			ps.setNull(8, Types.NULL);
			ps.setInt(9, r.getNumeroAdultos());
			ps.setDate(10, Date.valueOf(r.getFechaYhora()));
			ps.setString(11, r.getTipo().toString());
			ps.executeUpdate();
				
			
		} catch(SQLException e) {
			close();
			System.out.println(e);
		}
		close();
		
	}
	
	
	
	/*
	 * Busca reserva por id
	 */
	
	public ReservaAdultosDTO buscarReservaA(String idReserva) {
		ReservaAdultosDTO r= null;
		try {
			Connection connection = getConnection();
			PreparedStatement ps = con.prepareStatement(getProps().getProperty("buscar-reserva"));
			ps.setString(1, idReserva);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			 String idUsuario = rs.getString(2);
			 LocalDate fechaYhora =(rs.getDate(10)).toLocalDate();
			 int minutosReserva = rs.getInt(3);
			 int idPista = rs.getInt(7);
			 float precioPista = rs.getFloat(4);
			 int descuento = rs.getInt(5);		
			 int numeroAdultos = rs.getInt(9);
			 TipoReserva tipoReserva = TipoReserva.valueOf(rs.getString(11));
			 String modalidad = rs.getString(6);	 
			
			r = new  ReservaAdultosDTO(idReserva,idUsuario, minutosReserva,precioPista, descuento,
					modalidad, numeroAdultos);
			}	
		}
		catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
		
		
		return r;
	}
	
	

	/*
	 * Edita Reserva 
	 */
	
public void modificaReservaAdultos(ReservaAdultosDTO r) {
		
		try{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(getProps().getProperty("edita-reserva"), PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1,r.getIdUsuario());
			ps.setInt(2,r.getMinutosReserva());
			ps.setFloat(3, r.getPrecioPista());
			ps.setInt(4, r.getDescuento());
			ps.setString(5, r.getModalidad());
			ps.setInt(6, r.getIdPista());
			ps.setInt(7,Types.NULL);
			ps.setInt(8, r.getNumeroAdultos());
			ps.setDate(9, Date.valueOf(r.getFechaYhora()));
			ps.setString(10, r.getTipo().toString());
			ps.setString(10, r.getTipo().toString());
			ps.setString(11, r.getIdReserva());
			ps.executeUpdate();
				
			
		} catch(SQLException e) {
			close();
			System.out.println(e);
		}
		close();
		
	}
	
	/**
	 * Obtiene las reservas de Adultos ordenadas por fecha
	 * @return Los  reservas de Adultos ordenadas por fecha
	 */
	/*
	public  ArrayList<ReservaAdultosDTO> getReservasAdultosFuturas(){
		ArrayList<ReservaAdultosDTO> ads = new ArrayList<ReservaAdultosDTO>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(getProps().getProperty("get-reservasAdultos-futuras"));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String Reserva_id = rs.getString(1);
				PreparedStatement ps2 = con.prepareStatement(getProps().getProperty("get-published-general-ads-by-date-2"));
				ps2.setString(1, Reserva_id);
				ps2.setInt(2, AdStatus.PUBLISHED.ordinal());
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					UserDTO owner = (new UserDAO()).queryByID(rs2.getInt(4));
					String title = rs2.getString(1);
					String content = rs2.getString(2);
					int status = rs2.getInt(3);
					LocalDate publish_date = rs2.getDate(5).toLocalDate();
					GeneralAdDTO a = AdFactory.createGeneralAd(title, owner, content, ad_id, AdStatus.values()[status], publish_date);
					ads.add(a);
				}
			}
		}catch (SQLException e) {
			close();
			System.out.println(e);
		}
		close();
		return ads;
		}
	*/
}

