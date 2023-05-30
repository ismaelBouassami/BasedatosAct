package act5.interficies.isma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class act5 {
	static Scanner leerScanner = new Scanner(System.in);

	public static void main(String[] args) {
		act5 programAct5 = new act5();
		programAct5.inicio();
	}

	public void inicio() {
		String[] nombreStrings = { "Juan", "Pepe", "Cristia", "Hugo", "Quico", "Mario", "Luigi", "Koke", "Messi",
				"Ismael" };
		String[] apellidoStrings = { "García", "Rodríguez", "López", "Martínez", "Hernández", "González", "Pérez",
				"Sánchez", "Ramírez", "Torres" };
		String[] ciudadeStrings = { "Xàtiva", "Alzira", "Ontinyent", "Gandia", "Alcoy", "Almussafes", "Algemesí",
				"Carcaixent", "Cullera", "Sueca" };
		Bd(nombreStrings,apellidoStrings,ciudadeStrings);
	}

	public void Bd(String[] nombreStrings, String[] apellidoStrings, String[] ciudadeStrings) {
		System.out.println("Persones:");
		Random random=new Random();
		String pararString = "";
		String emailString="@gmail.com";
		// int numeroAleatorio = random.nextInt(10);
		// int añoaleatorio = random.nextInt(2021 - 1930) + 1930;

		for (int i = 1; i <= 200; i++) {
			System.out.print("I = " + i+" ");
			try {
				
				Class.forName("org.mariadb.jdbc.Driver");
				// Establir la connexió
				String urlBaseDades = "jdbc:mariadb://localhost:3306/exercici03";
				String usuari = "root";
				String contrasenya = "";
				Connection c = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);

				

				String senteciaString = "INSERT INTO persona (nom, cognoms, email, poblacio, any) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement prepararConsulta = c.prepareStatement(senteciaString);
				String nombre = nombreStrings[ random.nextInt(10)];
				String apellido = apellidoStrings[random.nextInt(10)];
				String ciudad= ciudadeStrings[random.nextInt(10)];
				int any=random.nextInt(2021 - 1930) + 1930;
				prepararConsulta.setString(1,nombre);
				prepararConsulta.setString(2, apellido);
				prepararConsulta.setString(3, nombre+apellido+emailString);
				prepararConsulta.setString(4, ciudad);
				prepararConsulta.setInt(5, any);
				
				  prepararConsulta.executeUpdate();
				
					
					
				
				  String selectTextoString ="SELECT  *FROM persona where nom='"+nombre+"' AND cognoms='"+apellido+"' AND any='"+any+"' AND poblacio='"+ciudad+"'";
				  
				  PreparedStatement juan = c.prepareStatement(selectTextoString);
				  
				  ResultSet resultado=juan.executeQuery();
				  while (resultado.next()) {
					  System.out.println("Id: " + resultado.getInt("id") + ",Nom: "
			                    + resultado.getString("nom") + ",Cognoms: " + resultado.getString("cognoms")
			                    + ",Email: " + resultado.getString("email") + ",Poblacio: "
			                    + resultado.getString("poblacio") + ",Data naixement: "
			                    + resultado.getString("any"));
					
				}
				
				// Tancar la connexió
				c.close();


			} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
			if (i == 25 || i == 50 || i == 75 || i == 100 || i == 125 || i == 150 || i == 175) {
				System.out.println("Continuar S/N");
				pararString = "";
				while (pararString.isEmpty()) {
					pararString = leerScanner.nextLine();
					if (pararString.isBlank()) {
						System.out.println("Vuelve a introducir algo");
						pararString = "";
					}
					if (!pararString.equalsIgnoreCase("S") && !pararString.equalsIgnoreCase("N")) {
						System.out.println("Vuelve a introducir algo");
						pararString = "";
						
					}
				}
				if (pararString.equalsIgnoreCase("S")) {
					System.out.println("Has seleccionado continuar");
				} else {
					System.out.println("Has seleccionado parar, Adios");
					break;
				}
			}
		}
	}
}
