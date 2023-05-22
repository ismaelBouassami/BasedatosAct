package act2.interficies.isma;

import java.sql.*;
import java.util.Scanner;

public class act2 {
	static Scanner leerScanner = new Scanner(System.in);

	public static void main(String[] args) {
		act2 programa = new act2();
		programa.inicio();
	}

	public void inicio() {
		String nombreString = null;
		String insetarString = null;
		nombreString = validarName(nombreString);

		crearBaseDatos(nombreString);
		amistad(insetarString, nombreString);

	}

	public void amistad(String insetarString, String nameBase) {
		System.out.println("Quieres insertar una amistad? (S/N)");
		insetarString = leerScanner.nextLine();
		while (!insetarString.toLowerCase().equals("s") && !insetarString.toLowerCase().equals("n")) {

			System.out.println("respuesta incorrecta");
			insetarString = leerScanner.nextLine();
		}
		if (insetarString.toLowerCase().equals("s")) {
			String Nombre, Apellidos, email, año;

			// pedir datos
			System.out.println("Escribe el nombre:");
			Nombre = leerScanner.nextLine();
			while (Nombre.isBlank()) {
				System.out.println("No puedes dejarlo vacio");
				Nombre = leerScanner.nextLine();
			}
			System.out.println("Escribe el apellido:");
			Apellidos = leerScanner.nextLine();
			while (Apellidos.isBlank()) {
				System.out.println("No puedes dejarlo vacio");
				Apellidos = leerScanner.nextLine();
			}
			System.out.println("Escribe el correo:");
			email = leerScanner.nextLine();
			while (email.isBlank()) {
				System.out.println("No puedes dejarlo vacio");
				email = leerScanner.nextLine();
			}
			System.out.println("Escribe el año:");
			año = leerScanner.nextLine();
			while (año.isBlank()) {
				System.out.println("No puedes dejarlo vacio");
				año = leerScanner.nextLine();
			}

			System.out.println("Nombre: " + Nombre + ", Apellidos: " + Apellidos + ", Gmail: " + email + ", Año: " + año);
			try {

				Class.forName("org.mariadb.jdbc.Driver");
				// Establir la connexió
				String urlBaseDades = "jdbc:mariadb://localhost:3306/" + nameBase;
				String usuari = "root";
				String contrasenya = "";
				Connection c = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);

				String senteciaString = "INSERT INTO amistat (nom, cognoms, gmail, añonacimiento) VALUES (?, ?, ?, ?)";
				PreparedStatement prepararConsulta = c.prepareStatement(senteciaString);

				prepararConsulta.setString(1, Nombre);
				prepararConsulta.setString(2, Apellidos);
				prepararConsulta.setString(3, email);
				prepararConsulta.setString(4, año);
				prepararConsulta.executeUpdate();
				System.out.println("Insertado correctamente");
				amistad(insetarString, nameBase);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			System.out.println("Adios");
			try {

				Class.forName("org.mariadb.jdbc.Driver");
				// Establir la connexió
				String urlBaseDades = "jdbc:mariadb://localhost:3306/" + nameBase;
				String usuari = "root";
				String contrasenya = "";
				Connection c = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);
				String selectTextoString = "SELECT * FROM amistat";

				PreparedStatement juan = c.prepareStatement(selectTextoString);

				ResultSet resultado = juan.executeQuery();
				while (resultado.next()) {
					System.out.println("Id: " + resultado.getInt("id") + ", Nombre: " + resultado.getString("nom")
							+ ", Apellidos: " + resultado.getString("cognoms") + ", Email: "
							+ resultado.getString("gmail") + ", Año: " + resultado.getString("añonacimiento"));

				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public String validarName(String name) {

		System.out.println("Escribe un nombre");
		name = leerScanner.nextLine();

		while (name == null)
			;
		{
			if (!name.matches("^[a-z]+$")) {
				System.out.println("El nombre no es correcto");

				name = leerScanner.nextLine();
			}
		}
		System.out.println("El nombre es: " + name);
		return name;
	}

	public void crearBaseDatos(String hola) {
		// Carregar el controlador per la BD MariaDB
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			// Establir la connexió
			String urlBaseDades = "jdbc:mariadb://localhost:3306/";
			String usuari = "root";
			String contrasenya = "";
			Connection c = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);

			Statement s = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			// instrucció SQL
			// comprovem si la base de dades existeix
			String sentencia = "SHOW DATABASES LIKE '" + hola + "'";
			ResultSet res = s.executeQuery(sentencia);
			if (res.next()) {
				System.out.println("BD amistad ja existeix");
			} else {
				sentencia = "CREATE DATABASE IF NOT EXISTS " + hola;
//						System.out.println(sentencia);
				// executem la instrucció SQL
				s.executeUpdate(sentencia);
				System.out.println("Base de dades  creada correctament");

				// creacion de tabla

				Connection c2 = DriverManager.getConnection(urlBaseDades + hola, usuari, contrasenya);
				Statement tabla = c2.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				// Creem la instrucció SQL
				String tablas = "SHOW TABLES LIKE 'amsitat'";
				ResultSet resultadotabla = tabla.executeQuery(tablas);
				if (resultadotabla.next()) {
					System.out.println("La taula amistad ja existeix");
				} else {
					tablas = "CREATE TABLE IF NOT EXISTS amistat(" + "id int primary key AUTO_INCREMENT,"
							+ "nom varchar(50) not null," + "cognoms varchar(50) not null,"
							+ "gmail varchar(50) not null," + "añonacimiento varchar(50) not null)";

					System.out.println(tablas);
					tabla.executeUpdate(tablas);
					System.out.println("Taula amistad creada correctament");
				}
			}

			// Tancar la connexió
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
