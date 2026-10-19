package gui;

import javax.swing.*;
import java.awt.Font;

public class FrmModificarMoto extends JFrame {

	private static final long serialVersionUID = 1L;

	/* COMPONENTES */
	private JComboBox<String> cboModelo;
	private JTextField txtPrecio;
	private JTextField txtCilindrada;
	private JTextField txtPeso;
	private JTextField txtVelocidad;

	public FrmModificarMoto() {

		setTitle("Modificar Moto");
		setSize(430, 330);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		// =====================================================
		// MODELO (COMBOBOX)
		// =====================================================

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblModelo.setBounds(250, 20, 100, 25);
		getContentPane().add(lblModelo);

		cboModelo = new JComboBox<String>();
		cboModelo.setBounds(30, 20, 200, 25);
		getContentPane().add(cboModelo);

		// =====================================================
		// PRECIO
		// =====================================================

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPrecio.setBounds(250, 60, 100, 25);
		getContentPane().add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(30, 60, 200, 25);
		getContentPane().add(txtPrecio);

		// =====================================================
		// CILINDRADA
		// =====================================================

		JLabel lblCilindrada = new JLabel("Cilindrada");
		lblCilindrada.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCilindrada.setBounds(250, 100, 100, 25);
		getContentPane().add(lblCilindrada);

		txtCilindrada = new JTextField();
		txtCilindrada.setBounds(30, 100, 200, 25);
		getContentPane().add(txtCilindrada);

		// =====================================================
		// PESO
		// =====================================================

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPeso.setBounds(250, 140, 100, 25);
		getContentPane().add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setBounds(30, 140, 200, 25);
		getContentPane().add(txtPeso);

		// =====================================================
		// VELOCIDAD
		// =====================================================

		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblVelocidad.setBounds(250, 180, 100, 25);
		getContentPane().add(lblVelocidad);

		txtVelocidad = new JTextField();
		txtVelocidad.setBounds(30, 180, 200, 25);
		getContentPane().add(txtVelocidad);

		// =====================================================
		// BOTÓN GUARDAR
		// =====================================================

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnGuardar.setBounds(80, 230, 100, 30);
		getContentPane().add(btnGuardar);

		// =====================================================
		// BOTÓN CERRAR
		// =====================================================

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCerrar.setBounds(220, 230, 100, 30);
		getContentPane().add(btnCerrar);

		// =====================================================
		// EVENTOS
		// =====================================================

		cboModelo.addActionListener(e -> mostrarDatos());

		btnGuardar.addActionListener(e -> guardarDatos());

		btnCerrar.addActionListener(e -> dispose());

		// =====================================================
		// CARGA INICIAL
		// =====================================================

		cargarModelos();
		mostrarDatos();
	}

	// =====================================================
	// CARGAR MODELOS
	// =====================================================

	void cargarModelos() {

		cboModelo.addItem(FrmPrincipal.modelo0);
		cboModelo.addItem(FrmPrincipal.modelo1);
		cboModelo.addItem(FrmPrincipal.modelo2);
		cboModelo.addItem(FrmPrincipal.modelo3);
		cboModelo.addItem(FrmPrincipal.modelo4);
	}

	// =====================================================
	// MOSTRAR DATOS
	// =====================================================

	void mostrarDatos() {

		int i = cboModelo.getSelectedIndex();

		switch (i) {

		case 0:
			txtPrecio.setText("" + FrmPrincipal.precio0);
			txtCilindrada.setText("" + FrmPrincipal.cilindrada0);
			txtPeso.setText("" + FrmPrincipal.peso0);
			txtVelocidad.setText("" + FrmPrincipal.velocidad0);
			break;

		case 1:
			txtPrecio.setText("" + FrmPrincipal.precio1);
			txtCilindrada.setText("" + FrmPrincipal.cilindrada1);
			txtPeso.setText("" + FrmPrincipal.peso1);
			txtVelocidad.setText("" + FrmPrincipal.velocidad1);
			break;

		case 2:
			txtPrecio.setText("" + FrmPrincipal.precio2);
			txtCilindrada.setText("" + FrmPrincipal.cilindrada2);
			txtPeso.setText("" + FrmPrincipal.peso2);
			txtVelocidad.setText("" + FrmPrincipal.velocidad2);
			break;

		case 3:
			txtPrecio.setText("" + FrmPrincipal.precio3);
			txtCilindrada.setText("" + FrmPrincipal.cilindrada3);
			txtPeso.setText("" + FrmPrincipal.peso3);
			txtVelocidad.setText("" + FrmPrincipal.velocidad3);
			break;

		case 4:
			txtPrecio.setText("" + FrmPrincipal.precio4);
			txtCilindrada.setText("" + FrmPrincipal.cilindrada4);
			txtPeso.setText("" + FrmPrincipal.peso4);
			txtVelocidad.setText("" + FrmPrincipal.velocidad4);
			break;
		}
	}

	// =====================================================
	// GUARDAR DATOS
	// =====================================================

	void guardarDatos() {

		int i;
		double precio;
		double cilindrada;
		double peso;
		double velocidad;

		i = cboModelo.getSelectedIndex();

		if (txtPrecio.getText().equals("") ||
			txtCilindrada.getText().equals("") ||
			txtPeso.getText().equals("") ||
			txtVelocidad.getText().equals("")) {

			JOptionPane.showMessageDialog(this,
					"Complete todos los campos");
			return;
		}

		try {
			precio = Double.parseDouble(txtPrecio.getText());
			cilindrada = Double.parseDouble(txtCilindrada.getText());
			peso = Double.parseDouble(txtPeso.getText());
			velocidad = Double.parseDouble(txtVelocidad.getText());

		} catch (Exception e) {

			JOptionPane.showMessageDialog(this,
					"Ingrese datos válidos");
			return;
		}

		switch (i) {

		case 0:
			FrmPrincipal.precio0 = precio;
			FrmPrincipal.cilindrada0 = cilindrada;
			FrmPrincipal.peso0 = peso;
			FrmPrincipal.velocidad0 = velocidad;
			break;

		case 1:
			FrmPrincipal.precio1 = precio;
			FrmPrincipal.cilindrada1 = cilindrada;
			FrmPrincipal.peso1 = peso;
			FrmPrincipal.velocidad1 = velocidad;
			break;

		case 2:
			FrmPrincipal.precio2 = precio;
			FrmPrincipal.cilindrada2 = cilindrada;
			FrmPrincipal.peso2 = peso;
			FrmPrincipal.velocidad2 = velocidad;
			break;

		case 3:
			FrmPrincipal.precio3 = precio;
			FrmPrincipal.cilindrada3 = cilindrada;
			FrmPrincipal.peso3 = peso;
			FrmPrincipal.velocidad3 = velocidad;
			break;

		case 4:
			FrmPrincipal.precio4 = precio;
			FrmPrincipal.cilindrada4 = cilindrada;
			FrmPrincipal.peso4 = peso;
			FrmPrincipal.velocidad4 = velocidad;
			break;
		}

		JOptionPane.showMessageDialog(this,
				"Datos modificados correctamente");

		dispose();
	}
}
