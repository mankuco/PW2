package pw.dao;

import java.util.ArrayList;

import java.sql.*;

import pw.pistakart.*;
import pw.connection.*;

public class PistaDAO {

	/* 
	 * @Resumen Guarda en la base de datos una nueva pista
	 */
	public void guardarPista(Pista pista) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			PreparedStatement ps=connection.prepareStatement("insert into Pista (nombrePista, tipoEstado, dificultad, maxKarts) values(?,?,?,?)");
			ps.setString(1,pista.getNombrePista());
			if(pista.getTipoEstado()==true) {
				ps.setInt(2, 1);
			}
			else {
				ps.setInt(2, 0);
			}
			if(pista.getDificultad() == Dificultades.FAMILIAR) {
				ps.setString(3,"FAMILIAR");
			}
			else if (pista.getDificultad() == Dificultades.ADULTOS) {
				ps.setString(3,"ADULTOS");
			}
			else {
				ps.setString(3,"INFANTIL");
			}
			ps.setInt(4,pista.getMaxKarts());
			ps.executeUpdate();
			dbConnection.closeConnection();
		}
		catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	/* 
	 * @Resumen Devuelve una pista si existe, si no existe un null
	 * @return pista = Pista
	 * @return null
	 */
	public Pista existepista(String nombrePista) {

		Pista pista = null;
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			String query = "select tipoEstado, dificultad, maxKarts, nkartsasociados from Pista where nombrePista =\"" + nombrePista + "\"";
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			while (rs.next()) {
				int i = rs.getInt("tipoEstado");
				boolean tipoEstado = true;
				if(i == 0) {
					tipoEstado = false;
				}
				String dif = rs.getString("dificultad");
				Dificultades dificultad = Dificultades.FAMILIAR;
				if(dif.equals("ADULTOS")) {
					dificultad = Dificultades.ADULTOS;
				}
				if(dif.equals("INFANTIL")) {
					dificultad = Dificultades.INFANTIL;
				}
				int maxKarts = rs.getInt("maxKarts");
				pista = new Pista(nombrePista, tipoEstado, dificultad, maxKarts);
				int nkartsasociados = rs.getInt("nkartsasociados");
				pista.setnkartsasociados(nkartsasociados);
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
		return pista;
	}

	/* 
	 * @Resumen Cambiar el valor de karts que tiene asociados una pista
	 * @param pista = Pista
	 */
	public void cambiarnkartsasociados(Pista pista) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			PreparedStatement ps=connection.prepareStatement("update Pista set nkartsasociados=? where nombrePista=?");
			ps.setInt(1,pista.getnkartsasociados());
			ps.setString(2,pista.getNombrePista());
			ps.executeUpdate();
			dbConnection.closeConnection();
		}
		catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	/* 
	 * @Resumen Devuelve la lista con todas las pistas que estan en mantenimiento
	 * @return listamantenimiento = ArrayList<Pista>
	 */
	public ArrayList<Pista> listarmantenimiento() {
		ArrayList<Pista> listamantenimiento = new ArrayList<Pista>();
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			String query = "select nombrePista, dificultad, maxKarts from Pista where tipoEstado = 0";
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			while (rs.next()) {
				String nombrePista = rs.getString("nombrePista");
				boolean tipoEstado = false;
				String dif = rs.getString("dificultad");
				Dificultades dificultad = Dificultades.FAMILIAR;
				if(dif.equals("ADULTOS")) {
					dificultad = Dificultades.ADULTOS;
				}
				if(dif.equals("INFANTIL")) {
					dificultad = Dificultades.INFANTIL;
				}
				int maxKarts = rs.getInt("maxKarts");
				listamantenimiento.add(new Pista(nombrePista, tipoEstado, dificultad, maxKarts));
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
		return listamantenimiento;
	}
	
	/* 
	 * @Resumen Busca las pistas que estan disponibles para cierto numero de karts
	 * @param numKart, es el numero de karts para los que buscamos una pista disponible
	 * @param dificultad, el la dificultas (infantil, adultos, familiar) para la que buscamos la pista
	 * @return disponibles, devuelve un vector con todas las pistas que cumplen los requisitos
	 */
	public ArrayList<Pista> listardisponibles(int numKart, Dificultades dificultad){
		ArrayList<Pista> listadisponibles = new ArrayList<Pista>();
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			String query = "select nombrePista, maxKarts, nkartsasociados, dificultad from Pista where tipoEstado = 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			String dif = "FAMILIAR";
			if(dificultad == Dificultades.ADULTOS) {
				dif = "ADULTOS";
			}
			else if(dificultad == Dificultades.INFANTIL) {
				dif = "INFANTIL";
			}
			while (rs.next()) {
				int maxKarts = rs.getInt("maxKarts");
				String dificul = rs.getString("dificultad");
				int nkartsasociados = rs.getInt("nkartsasociados");
				if((nkartsasociados >= numKart) && (dif.equals(dificul))) {
					String nombrePista = rs.getString("nombrePista");
					Pista pista = new Pista(nombrePista, true, dificultad, maxKarts);
					pista.setnkartsasociados(nkartsasociados);
					listadisponibles.add(pista);
				}
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
		return listadisponibles;
	}
}
