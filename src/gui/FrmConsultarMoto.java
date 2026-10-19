package gui;

import javax.swing.*;
import java.awt.Font;

public class FrmConsultarMoto extends JFrame {

	private static final long serialVersionUID = 1L;

	private JComboBox<String> cboModelo;
	private JTextField txtPrecio;
	private JTextField txtCilindrada;
	private JTextField txtPeso;
	private JTextField txtVelocidad;

	public FrmConsultarMoto() {

		setTitle("Consultar Moto");
		setSize(420, 320);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		// =====================================================
		// COMBO MODELO
		// =====================================================

		cboModelo = new JComboBox<String>();
		cboModelo.setBounds(30, 20, 220, 30);
		getContentPane().add(cboModelo);

		// =====================================================
		// PRECIO
		// =====================================================

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPrecio.setBounds(220, 60, 100, 25);
		getContentPane().add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(30, 60, 170, 28);
		txtPrecio.setEditable(false);
		getContentPane().add(txtPrecio);

		// =====================================================
		// CILINDRADA
		// =====================================================

		JLabel lblCilindrada = new JLabel("Cilindrada");
		lblCilindrada.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCilindrada.setBounds(220, 100, 100, 25);
		getContentPane().add(lblCilindrada);

		txtCilindrada = new JTextField();
		txtCilindrada.setBounds(30, 100, 170, 28);
		txtCilindrada.setEditable(false);
		getContentPane().add(txtCilindrada);

		// =====================================================
		// PESO
		// =====================================================

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPeso.setBounds(220, 140, 100, 25);
		getContentPane().add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setBounds(30, 140, 170, 28);
		txtPeso.setEditable(false);
		getContentPane().add(txtPeso);

		// =====================================================
		// VELOCIDAD
		// =====================================================

		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblVelocidad.setBounds(220, 180, 100, 25);
		getContentPane().add(lblVelocidad);

		txtVelocidad = new JTextField();
		txtVelocidad.setBounds(30, 180, 170, 28);
		txtVelocidad.setEditable(false);
		getContentPane().add(txtVelocidad);

		// =====================================================
		// BOTÓN CERRAR
		// =====================================================

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(280, 220, 90, 30);
		getContentPane().add(btnCerrar);

		// =====================================================
		// EVENTOS
		// =====================================================

		cboModelo.addActionListener(e -> mostrarDatos());

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
}
