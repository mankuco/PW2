package pw.reservas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;

import pw.connection.DBConnection;
import pw.pistakart.Estados;
import pw.pistakart.Kart;
import pw.usuario.Usuario;

/**
 * Clase que accede a la base de datos de Reservas
 */

public class ReservaDAO extends DAO {
	
	/**
	 * Inserta una reserva en la base de datos
	 */
	
	public String insertaReserva(Reserva r) {
		String id =r.getIdReserva();
		
		try{
			PreparedStatement ps = con.prepareStatement(getProps().getProperty("inserta-reserva"), PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1,r.getIdReserva());
			ps.setString(2,r.getIdUsuario());
			ps.setInt(3,r.getMinutosReserva());
			ps.setFloat(4, r.getPrecioPista());
			ps.setInt(5, r.getDescuento());
			ps.setString(6, r.getModalidad());
			ps.setInt(7, r.getIdPista());
			ps.setNull(8, Types.NULL);
			ps.setNull(9, Types.NULL );
			ps.setDate(10, Date.valueOf(r.getFechaYhora()));
			ps.setString(11, r.getTipo().toString());
			ps.executeUpdate();
			
		} catch(SQLException e) {
			close();
			System.out.println(e);
		}
		close();
		return id;
	}

	
	/*
	 * Busca reserva por id
	 */
	/*
	public Reserva buscarReserva(String idReserva) {
		Reserva r= null;
		try {
			Connection connection = getConnection();
			PreparedStatement ps = con.prepareStatement(getProps().getProperty("buscarReserva"+idReserva));
			ResultSet rs = ps.executeQuery();
			 String idUsuario = rs.getString(2);
			 LocalDate fechaYhora =(rs.getDate(10)).toLocalDate();
			 int minutosReserva = rs.getInt(3);
			 int idPista = rs.getInt(7);
			 float precioPista = rs.getFloat(4);
			 int descuento = rs.getInt(5);		
		//	 int NumeroNinos = rs.getInt(8);
		//	 int NumeroAdultos = rs.getInt(9);
			 TipoReserva tipoReserva = TipoReserva.valueOf(rs.getString(11));
			 String modalidad = rs.getString(6);	 
			
			r = GestorReservas.
				
		}
		catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
		
		
		return Reserva;
	}*/
	
public void borraReserva(String id ) {
		
		try{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(getProps().getProperty("elimina-reserva"), PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1,id);

			ps.executeUpdate();
				
			
		} catch(SQLException e) {
			close();
			System.out.println(e);
		}
		close();
		
	}

public ArrayList<Reserva> verReservas() {
	
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	ReservaFamiliarDTO rf= null;
	ReservaAdultosDTO ra= null;
	ReservaInfantilDTO ri= null;
	
	try {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(getProps().getProperty("ver-reservas"));
		ps.setString(1,LocalDate.now().toString());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			 String idReserva = rs.getString(1);
			 String idUsuario = rs.getString(2);
			 LocalDate fechaYhora =(rs.getDate(10)).toLocalDate();
			 int minutosReserva = rs.getInt(3);
			 int idPista = rs.getInt(7);
			 float precioPista = rs.getFloat(4);
			 int descuento = rs.getInt(5);		
			 int numeroNinos = rs.getInt(8);
			 int numeroAdultos = rs.getInt(9);
			 TipoReserva tipoReserva = TipoReserva.valueOf(rs.getString(11));
			 String modalidad = rs.getString(6);	
			 
		if(tipoReserva == TipoReserva.FAMILIAR) {
			 rf = new  ReservaFamiliarDTO(idReserva,idUsuario, minutosReserva,precioPista, descuento,
					modalidad, numeroNinos, numeroAdultos);
			 reservas.add(rf);	 
		}
			
			
			
			if(tipoReserva == TipoReserva.INFANTIL) {
				 ri = new  ReservaInfantilDTO(idReserva,idUsuario, minutosReserva,precioPista, descuento,
						modalidad, numeroNinos);
					reservas.add(ri);	 
			}
				
			
				
		if(tipoReserva == TipoReserva.ADULTOS) {
			 ra = new  ReservaAdultosDTO(idReserva,idUsuario, minutosReserva,precioPista, descuento,
					modalidad, numeroAdultos);
			 reservas.add(ra);	 
		}
			
			
				
			
			}
		
		
		
	} catch (SQLException e) {
		close();
		System.out.println(e);
	}
	close();
	return reservas;
	
}
}
	



/**
 * Devuelve las reservas futuras
 */
	/*
public ArrayList<Reserva> getPublishedAdsSortedByDate(Usuario logged_user){
	ArrayList<Reserva> ads = new ArrayList<Reserva>();
	ArrayList<ReservaAdultosDTO> reservasAdultos = (new ReservaAdultosDAO().get);
	ArrayList<ReservaFamiliar> flash_ads = (new ReservaDAO()).getPublishedFlashAdsSortedByDate();
	ArrayList<ReservaInfantil> individual_ads = (new IndividualAdDAO()).getPublishedIndividualAdsSortedByDate(logged_user);
	ArrayList<ThematicAdDTO> thematic_ads = (new ThematicAdDAO()).getPublishedThematicAdsSortedByDate(logged_user);
	ads.addAll(general_ads);
	ads.addAll(flash_ads);
	ads.addAll(individual_ads);
	ads.addAll(thematic_ads);
	return ads;
}*/
