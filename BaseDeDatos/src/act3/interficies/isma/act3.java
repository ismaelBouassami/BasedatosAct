package act3.interficies.isma;

import java.sql.*;
import java.util.Scanner;



public class act3 {
	static Scanner leerScanner =new Scanner(System.in);
	public static void main(String[] args) {
		act3 programAct3 = new act3();
		programAct3.inicio();
	}

	public void inicio() {
		MostrarDatosBasedatos();
		String poblacionString=null;
		poblacionString = pedirPoblacion(poblacionString);
		Borradodatos(poblacionString);
	}
	public void Borradodatos(String pueblo) {
		System.out.println("Poblacion indicada :" +pueblo);
		
		// Carregar el controlador per la BD MariaDB
				try {
					Class.forName("org.mariadb.jdbc.Driver");

					// Establir la connexió
					String urlBaseDades = "jdbc:mariadb://localhost:3306/exercici03";
					String usuari = "root";
					String contrasenya = "";
					Connection c = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);

					Statement s = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
					// creem la instrucció sql
					String sentencia= "SELECT poblacio  FROM persona ;";
//					System.out.println(sentencia);
					
					
					ResultSet r = s.executeQuery(sentencia);
					
					Boolean existePuebloBoolean= false;
					String puebloEliminar="";
					if (r.next()) {
					    do {
					        if (r.getString("poblacio").equalsIgnoreCase(pueblo)) {
					        	//Si el pueblo existe cambiamos la poblacion de la tabla a la que teniamos
					        	puebloEliminar=r.getString("poblacio");
					            existePuebloBoolean = true;
					            break;
					        }
					    } while (r.next());
					}
					
					if (!existePuebloBoolean) {
						System.out.println("No hi  ha cap poblacio: "+pueblo);
					}else {
						
						
						try {


							PreparedStatement ps = c.prepareStatement("DELETE FROM persona WHERE poblacio = ?");
							ps.setString(1, puebloEliminar);
							int numRowsDeleted = ps.executeUpdate();

							if (numRowsDeleted > 0) {
							    System.out.println("Se han eliminado " + numRowsDeleted + " personas de la población: " + pueblo);
							} else {
							  
							}

						
							
						} catch (SQLException e) {
							e.printStackTrace();
						}
				
					}

					
					
					// Tancar la connexió
					c.close();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
	}
	public String pedirPoblacion(String pueblo) {
		System.out.println("Escribe una població: ");
		pueblo=leerScanner.nextLine();
		
		while (pueblo.isBlank()) {
			System.out.println("No puede estar vacio :");
			pueblo=leerScanner.nextLine();
		}
		return pueblo;
	}
	public void MostrarDatosBasedatos() {
		System.out.println("Persones per cada poblacio: ");
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			// Establir la connexió
			String urlBaseDades = "jdbc:mariadb://localhost:3306/exercici03";
			String usuari = "root";
			String contrasenya = "";
			Connection c = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);

			// Enviar una sentència SQL per recuperar els clients
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(
					"SELECT poblacio, COUNT(*) AS cantidad_personas FROM persona GROUP BY poblacio;");

			while (r.next()) {
				System.out.println("Poblacio: "+r.getString("poblacio") +", Persones: "+ r.getInt("cantidad_personas"));
			}


			// Tancar la connexió
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
