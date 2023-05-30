package act4.interficies.isma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class act4 {
	String[] nametablas;
	String[] separarFila;
	List<String> lineas = new ArrayList<>();

	public static void main(String[] args) {
		act4 programAct4 = new act4();
		programAct4.inicio();
	}

	public void inicio() {

		MirarTabla();
		LeerArchivo();
//	System.out.println(lineas.size());
		SubirLineas();
	}

	public void SubirLineas() {
		System.out.println("Se han inserit "+(lineas.size()-1));
		for (int i = 0; i < lineas.size() ; i++) {
			if (i == 0) {
				nametablas = lineas.get(i).split(":");
			} else {
				separarFila = lineas.get(i).split(":");
				System.out.println("Id: "+separarFila[0]+", Nom: "+separarFila[1]+", Comarca: "+separarFila[2]+",Habitans: "+separarFila[3]+",altitud: "+separarFila[4]+",codipostal: "+separarFila[5]+",festes: "+separarFila[6]+" ");
				try {

					Class.forName("org.mariadb.jdbc.Driver");
					// Establir la connexió
					String urlBaseDades = "jdbc:mariadb://localhost:3306/exercici04";
					String usuari = "root";
					String contrasenya = "";
					Connection c = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);

					String senteciaString = "INSERT INTO ciutat ("+nametablas[0]+", "+nametablas[1]+", "+nametablas[2]+", "+nametablas[3]+", "+nametablas[4]+", "+nametablas[5]+", "+nametablas[6]+") VALUES (?, ?, ?, ?, ?, ?, ?)";

//					System.out.println(senteciaString);
					PreparedStatement prepararConsulta = c.prepareStatement(senteciaString);

					prepararConsulta.setInt(1, Integer.parseInt(separarFila[0]));
					prepararConsulta.setString(2, separarFila[1]);
					prepararConsulta.setString(3, separarFila[2]);
					prepararConsulta.setInt(4,Integer.parseInt( separarFila[3]));
					prepararConsulta.setInt(5, Integer.parseInt(separarFila[4]));
					prepararConsulta.setInt(6, Integer.parseInt(separarFila[5]));
					prepararConsulta.setString(7, separarFila[6]);
					prepararConsulta.executeUpdate();



					// Tancar la connexió
					c.close();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO: handle exception
				}
			}
		}
	}

	public void LeerArchivo() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("dadesCiutats.txt"));
			String lineString = null;
			while ((lineString = reader.readLine()) != null) {
				lineas.add(lineString);
			}

			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void MirarTabla() {

		try {
			// Carregar el controlador per la BD MariaDB
			Class.forName("org.mariadb.jdbc.Driver");

			// Establir la connexió
			String urlBaseDades = "jdbc:mariadb://localhost:3306/exercici04";
			String usuari = "root";
			String contrasenya = "";
			Connection c = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);

			// Enviar una sentència SQL per recuperar els clients
			// Establim el mode lectura-escriptura per al resultset
			Statement s = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			// seleccionem l'element que volem eliminar
			ResultSet r = s.executeQuery("SELECT * FROM ciutat");

			while (r.next()) {
				String id = r.getString("idciutat"); // Suponiendo que la columna de interés es la primera
				System.out.println("Eliminada ciutat amb id ciutat : " + id);

				r.deleteRow();
			}

			// Comprovem que s'ha eliminat
//		r = s.executeQuery("SELECT * FROM alumne");

			// Tancar la connexió
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
