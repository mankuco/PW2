package pw.dao;

import java.util.ArrayList;

import java.sql.*;

import pw.pistakart.*;
import pw.connection.*;

public class KartDAO {

	/* 
	 * @Resumen Guarda en la base de datos un nuevo kart
	 */
	public void guardarKart(Kart kart) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			PreparedStatement ps=connection.prepareStatement("insert into Kart (idKart, tipoKart, estado) values(?,?,?)");
			ps.setInt(1,kart.getIdKart());
			if(kart.getTipoKart()==true) {
				ps.setInt(2, 1);
			}
			else {
				ps.setInt(2, 0);
			}
			if(kart.getEstado() == Estados.DISPONIBLE) {
				ps.setString(3,"DISPONIBLE");
			}
			else if(kart.getEstado() == Estados.MANTENIMIENTO) {
				ps.setString(3,"MANTENIMIENTO");
			}
			else {
				ps.setString(3,"RESERVADO");
			}
			ps.executeUpdate();
			dbConnection.closeConnection();
		}
		catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	/* 
	 * @Resumen Devuelve el kart si existe, si no existe un null
	 * @return kart = Kart
	 * @return null
	 */
	public Kart existekart(int idKart) {

		Kart kart = null;
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			String query = "select tipoKart, estado from Kart where idKart = " + idKart;
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			while (rs.next()) {
				int i = rs.getInt("tipoKart");
				boolean tipoKart = true;
				if(i == 0) {
					tipoKart = false;
				}
				String est = rs.getString("estado");
				Estados estado = Estados.RESERVADO;
				if(est.equals("ADULTOS")) {
					estado = Estados.MANTENIMIENTO;
				}
				if(est.equals("DISPONIBLE")) {
					estado = Estados.DISPONIBLE;
				}
				int maxKarts = rs.getInt("maxKarts");
				kart = new Kart(idKart, tipoKart, estado);
			}
			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		}
		catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return kart;
	}
	
	
	public void cambiarnombrePista(Kart kart, Pista pista) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			PreparedStatement ps=connection.prepareStatement("update Kart set nombrePista=? where idKart=?");
			ps.setString(1,pista.getNombrePista());
			ps.setInt(2,kart.getIdKart());
			ps.executeUpdate();
			dbConnection.closeConnection();
		}
		catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}