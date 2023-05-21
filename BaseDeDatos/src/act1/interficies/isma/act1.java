package act1.interficies.isma;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class act1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Exercici 01:");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel titulo = new JLabel("Formulario datos:");

		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel nombre = new JLabel("Nombre:");
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel apellido = new JLabel("Apellidos:");
		apellido.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel correo = new JLabel("Correo: ");
		correo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel poblacion = new JLabel("Poblacion:  ");
		poblacion.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel fechaNacimiento = new JLabel("Fecha Nacimiento: ");
		fechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel ciclo = new JLabel("Ciclo: ");
		ciclo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel error1 = new JLabel("");
		JLabel error2 = new JLabel("");
		JLabel error3 = new JLabel("");
		JLabel error4 = new JLabel("");
		JLabel error5 = new JLabel("");
		JLabel error6 = new JLabel("");
		JLabel correcion = new JLabel("");

		// texto
		JTextField nombreT = new JTextField();
		nombreT.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField apellidoT = new JTextField();
		apellidoT.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField correoT = new JTextField();
		correoT.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField poblacionT = new JTextField();
		poblacionT.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField fechaT = new JTextField();
		fechaT.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField cicloT = new JTextField();
		cicloT.setHorizontalAlignment(SwingConstants.CENTER);
		//
		JButton Close = new JButton("Cerrar");
		Close.addActionListener(salir -> frame.dispose());

		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nombreT.setText("");
				apellidoT.setText("");
				correoT.setText("");
				poblacionT.setText("");
				fechaT.setText("");
				cicloT.setText("");
				// para resetear los mensajes tambien
				error1.setText("");
				error2.setText("");
				error3.setText("");
				error4.setText("");
				error5.setText("");
				error6.setText("");
				correcion.setText("");
			}
		});

		JButton guarda = new JButton("Guardar");
		guarda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Obtener el texto de cada TextField
				String nombre = nombreT.getText();
				String apellido = apellidoT.getText();
				String correo = correoT.getText();
				String poblacion = poblacionT.getText();
				String fechaNacimiento = fechaT.getText();
				String ciclo = cicloT.getText();

				// Comprobar si algún campo está vacío

				int cont = 0;

				if (nombreT.getText().equals("") || apellidoT.getText().equals("") || correoT.getText().equals("")
						|| poblacionT.getText().equals("") || fechaT.getText().equals("")
						|| cicloT.getText().equals("")) {
					correcion.setText("Error en los datos");
					cont++;
				}

				if (nombre.isBlank()) {
					error1.setText("Campo vacío");
					cont++;
				}
				if (apellido.isBlank()) {
					error2.setText("Campo vacío");
					cont++;
				}
				if (correo.isBlank()) {
					error3.setText("Campo vacío");
					cont++;
				}
				if (poblacion.isBlank()) {
					error4.setText("Campo vacío");
					cont++;
				}
				if (fechaT.getText().isBlank()) {
					error5.setText("Campo vacío");
					cont++;
				}
				if (cicloT.getText().isBlank()) {
					error6.setText("Campo vacío");
					cont++;

				} else {
					// || ciclo.toUpperCase()!=("ASIX")|| ciclo.toUpperCase()!=("SMX")
					if (!cicloT.getText().toUpperCase().equals("DAW") && !cicloT.getText().toUpperCase().equals("DAM")
							&& !cicloT.getText().toUpperCase().equals("ASIX")
							&& !cicloT.getText().toUpperCase().equals("SMX")) {

						error6.setText("El cicle debe de ser DAW, DAM, ASIX O SMX");
						cont++;
					}
				}
				if (cont > 0) {
					return; // en caaso de que no se llene bien algun campo mostrara los mensajes primero y
							// luego se cancelara el guardado
				}

				// Guardar los datos en el archivo
				try {
					FileWriter fileWriter = new FileWriter("datos.txt", true); // "true" para que no sobreescriba el
																				// archivo existente
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					String datos = nombre + "::" + apellido + "::" + correo + "::" + poblacion + "::" + fechaNacimiento
							+ "::" + ciclo.toUpperCase() + "::";
					bufferedWriter.write(datos);
					bufferedWriter.newLine();
					bufferedWriter.close();
					correcion.setText("Guardado correctamente");
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				// Limpiar los campos
				nombreT.setText("");
				apellidoT.setText("");
				correoT.setText("");
				poblacionT.setText("");
				fechaT.setText("");
				cicloT.setText("");

				error1.setText("");
				error2.setText("");
				error3.setText("");
				error4.setText("");
				error5.setText("");
				error6.setText("");

			}
		});

		// BBD

		JButton BBD = new JButton("BBD");
		BBD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				// Obtener el texto de cada TextField
				try {
					String nombre = nombreT.getText();
					String apellido = apellidoT.getText();
					String correo = correoT.getText();
					String poblacion = poblacionT.getText();
					String fechaNacimiento = fechaT.getText();
					String ciclo = cicloT.getText();

					// Comprobar si algún campo está vacío

					int cont = 0;

					if (nombreT.getText().equals("") || apellidoT.getText().equals("") || correoT.getText().equals("")
							|| poblacionT.getText().equals("") || fechaT.getText().equals("")
							|| cicloT.getText().equals("")) {
						correcion.setText("Error en los datos");
						cont++;
					}

					if (nombre.isBlank()) {
						error1.setText("Campo vacío");
						cont++;
					}
					if (apellido.isBlank()) {
						error2.setText("Campo vacío");
						cont++;
					}
					if (correo.isBlank()) {
						error3.setText("Campo vacío");
						cont++;
					}
					if (poblacion.isBlank()) {
						error4.setText("Campo vacío");
						cont++;
					}
					if (fechaT.getText().isBlank()) {
						error5.setText("Campo vacío");
						cont++;
					}
					if (cicloT.getText().isBlank()) {
						error6.setText("Campo vacío");
						cont++;

					} else {
						// || ciclo.toUpperCase()!=("ASIX")|| ciclo.toUpperCase()!=("SMX")
						if (!cicloT.getText().toUpperCase().equals("DAW")
								&& !cicloT.getText().toUpperCase().equals("DAM")
								&& !cicloT.getText().toUpperCase().equals("ASIX")
								&& !cicloT.getText().toUpperCase().equals("SMX")) {

							error6.setText("El cicle debe de ser DAW, DAM, ASIX O SMX");
							cont++;
						}
					}
					if (cont > 0) {
						return; // en caaso de que no se llene bien algun campo mostrara los mensajes primero y
								// luego se cancelara el guardado en bbd
					} else {

						Class.forName("org.mariadb.jdbc.Driver");
						// Establir la connexió
						String urlBaseDades = "jdbc:mariadb://localhost:3306/exercici01";
						String usuari = "root";
						String contrasenya = "";
						Connection c = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);

						

						String senteciaString = "INSERT INTO alumne (nom, cognoms, email, poblacio, datanaixement, cicleformatiu) VALUES (?, ?, ?, ?, ?, ?)";
						PreparedStatement prepararConsulta = c.prepareStatement(senteciaString);

						prepararConsulta.setString(1, nombre);
						prepararConsulta.setString(2, apellido);
						prepararConsulta.setString(3, correo);
						prepararConsulta.setString(4, poblacion);
						prepararConsulta.setString(5, fechaNacimiento);
						prepararConsulta.setString(6, ciclo);
						
						  prepararConsulta.executeUpdate();
						
						  String selectTextoString ="SELECT * FROM alumne WHERE nom='"+nombre+"'";
						  
						  PreparedStatement juan = c.prepareStatement(selectTextoString);
						  
						  ResultSet resultado=juan.executeQuery();
						  while (resultado.next()) {
							  System.out.println("Id: " + resultado.getInt("idalumne") + ",\nNom: "
	                                    + resultado.getString("nom") + ",\nCognoms: " + resultado.getString("cognoms")
	                                    + ",\nEmail: " + resultado.getString("email") + ",\nPoblacio: "
	                                    + resultado.getString("poblacio") + ",\nData naixement: "
	                                    + resultado.getString("datanaixement") + ",\nCicle Formatiu: "
	                                    + resultado.getString("cicleformatiu"));
							
						}
						
						// Tancar la connexió
						c.close();

					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		// agreguem una distribucio

		// GridLayout(files, columnes)
		GridLayout gridLayout = new GridLayout(9, 3);

		frame.setLayout(gridLayout);

		// Añadir los componentes al panel
		frame.add(new JLabel(""));
		frame.add(titulo);
		frame.add(correcion);
		// fila 1
		frame.add(nombre);
		frame.add(nombreT);
		frame.add(error1);
		// fila 2
		frame.add(apellido);
		frame.add(apellidoT);
		frame.add(error2);
		// fila3
		frame.add(correo);
		frame.add(correoT);
		frame.add(error3);
		// fila4
		frame.add(poblacion);
		frame.add(poblacionT);
		frame.add(error4);
		// fila5
		frame.add(fechaNacimiento);
		frame.add(fechaT);
		frame.add(error5);
		// fila 6
		frame.add(ciclo);
		frame.add(cicloT);
		frame.add(error6);
		// botones
		frame.add(Close);
		frame.add(reset);
		frame.add(guarda);
		frame.add(new JLabel(""));
		frame.add(BBD);
		frame.add(new JLabel(""));
//	    gridLayout.setHgap(5); // Espacio horizontal entre componentes
//	    gridLayout.setVgap(5); // Espacio vertical entre componentes

		// tamaño
		frame.setSize(600, 450);
		frame.setVisible(true);
	}
}
