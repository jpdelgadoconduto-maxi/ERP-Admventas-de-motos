package gui;

import javax.swing.*;
import java.awt.Font;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FrmVentas extends JFrame {

	private static final long serialVersionUID = 1L;

	/* COMPONENTES DE LA INTERFAZ */
	private JComboBox<String> cboModelo;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JTextField txtCliente;
	private JTextField txtDni;
	
	// NUEVOS COMPONENTES COLUMNA DERECHA
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtFecha;
	private JTextField txtAsesor;
	private JTextField txtSede;
	
	private JTextArea txtBoleta;

	public FrmVentas() {
		setTitle("Vender Moto");
		setSize(550, 530); // Se amplió el alto para acomodar perfectamente los campos
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		// Fuente estándar unificada para lograr un diseño homogéneo
		Font fuenteUniforme = new Font("Segoe UI", Font.PLAIN, 14);

		// =====================================================
		// COLUMNA IZQUIERDA
		// =====================================================

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(fuenteUniforme);
		lblModelo.setBounds(30, 19, 70, 25);
		getContentPane().add(lblModelo);

		cboModelo = new JComboBox<String>();
		cboModelo.setFont(fuenteUniforme);
		cboModelo.setBounds(98, 19, 150, 25);
		getContentPane().add(cboModelo);

		JLabel lblPrecio = new JLabel("Precio U.");
		lblPrecio.setFont(fuenteUniforme);
		lblPrecio.setBounds(30, 55, 70, 25);
		getContentPane().add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setFont(fuenteUniforme);
		txtPrecio.setBounds(98, 55, 150, 25);
		txtPrecio.setEditable(false);
		getContentPane().add(txtPrecio);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(fuenteUniforme);
		lblCantidad.setBounds(30, 91, 70, 25);
		getContentPane().add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setFont(fuenteUniforme);
		txtCantidad.setBounds(98, 91, 150, 25);
		getContentPane().add(txtCantidad);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(fuenteUniforme);
		lblCliente.setBounds(30, 126, 70, 25);
		getContentPane().add(lblCliente);

		txtCliente = new JTextField();
		txtCliente.setFont(fuenteUniforme);
		txtCliente.setBounds(98, 127, 150, 25);
		getContentPane().add(txtCliente);

		JLabel lblDni = new JLabel("Dni");
		lblDni.setFont(fuenteUniforme);
		lblDni.setBounds(30, 162, 70, 25);
		getContentPane().add(lblDni);

		txtDni = new JTextField();
		txtDni.setFont(fuenteUniforme);
		txtDni.setBounds(98, 163, 150, 25);
		getContentPane().add(txtDni);

		// =====================================================
		// COLUMNA DERECHA
		// =====================================================

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(fuenteUniforme);
		lblTelefono.setBounds(280, 19, 70, 25);
		getContentPane().add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setFont(fuenteUniforme);
		txtTelefono.setBounds(360, 18, 150, 25);
		getContentPane().add(txtTelefono);

		JLabel lblDireccion = new JLabel("Dirección");
		lblDireccion.setFont(fuenteUniforme);
		lblDireccion.setBounds(280, 55, 70, 25);
		getContentPane().add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setFont(fuenteUniforme);
		txtDireccion.setBounds(360, 54, 150, 25);
		getContentPane().add(txtDireccion);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(fuenteUniforme);
		lblFecha.setBounds(280, 91, 70, 25);
		getContentPane().add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setFont(fuenteUniforme);
		txtFecha.setBounds(360, 90, 150, 25);
		getContentPane().add(txtFecha);

		JLabel lblAsesor = new JLabel("Asesor");
		lblAsesor.setFont(fuenteUniforme);
		lblAsesor.setBounds(280, 126, 70, 25);
		getContentPane().add(lblAsesor);

		txtAsesor = new JTextField();
		txtAsesor.setFont(fuenteUniforme);
		txtAsesor.setBounds(360, 125, 150, 25);
		getContentPane().add(txtAsesor);

		JLabel lblSede = new JLabel("Sede");
		lblSede.setFont(fuenteUniforme);
		lblSede.setBounds(280, 162, 70, 25);
		getContentPane().add(lblSede);

		txtSede = new JTextField();
		txtSede.setFont(fuenteUniforme);
		txtSede.setBounds(360, 161, 150, 25);
		getContentPane().add(txtSede);

		// =====================================================
		// AREA DE BOLETA REPORTE
		// =====================================================

		txtBoleta = new JTextArea();
		txtBoleta.setEditable(false);
		txtBoleta.setFont(new Font("Consolas", Font.PLAIN, 13)); // Consolas es ideal para alinear texto en boletas

		JScrollPane scrollPane = new JScrollPane(txtBoleta);
		scrollPane.setBounds(30, 200, 480, 220);
		getContentPane().add(scrollPane);

		// =====================================================
		// BOTONES ACCIONES
		// =====================================================

		JButton btnVender = new JButton("Vender");
		btnVender.setFont(fuenteUniforme);
		btnVender.setBounds(80, 440, 100, 30);
		getContentPane().add(btnVender);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(fuenteUniforme);
		btnNuevo.setBounds(210, 440, 100, 30);
		getContentPane().add(btnNuevo);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(fuenteUniforme);
		btnCerrar.setBounds(340, 440, 100, 30);
		getContentPane().add(btnCerrar);

		// INTERCONEXIÓN DE ACCIONES Y MÉTODOS
		cboModelo.addActionListener(e -> mostrarPrecio());
		btnVender.addActionListener(e -> vender());
		btnNuevo.addActionListener(e -> limpiar());
		btnCerrar.addActionListener(e -> dispose());

		// CARGA INICIAL POR DEFECTO
		cargarModelos();
		mostrarPrecio();
	}

	void cargarModelos() {
		cboModelo.addItem(FrmPrincipal.modelo0);
		cboModelo.addItem(FrmPrincipal.modelo1);
		cboModelo.addItem(FrmPrincipal.modelo2);
		cboModelo.addItem(FrmPrincipal.modelo3);
		cboModelo.addItem(FrmPrincipal.modelo4);
	}

	void mostrarPrecio() {
		int i = cboModelo.getSelectedIndex();
		switch (i) {
		case 0: txtPrecio.setText("" + FrmPrincipal.precio0); break;
		case 1: txtPrecio.setText("" + FrmPrincipal.precio1); break;
		case 2: txtPrecio.setText("" + FrmPrincipal.precio2); break;
		case 3: txtPrecio.setText("" + FrmPrincipal.precio3); break;
		case 4: txtPrecio.setText("" + FrmPrincipal.precio4); break;
		}
	}

	// =====================================================
	// VENDER CON SALVAGUARDAS DE SEGURIDAD EXTREMAS
	// =====================================================
	void vender() {
		int i, cantidad;
		String modelo, obsequio;
		double precio, importeCompra, porcentajeDescuento, importeDescuento, importePagar, porcentajeCuota;

		// Extracción y limpieza preliminar de campos
		String clienteVal = txtCliente.getText().trim();
		String dniVal = txtDni.getText().trim();
		String telefonoVal = txtTelefono.getText().trim();
		String cantidadVal = txtCantidad.getText().trim();
		String direccionVal = txtDireccion.getText().trim();
		String fechaVal = txtFecha.getText().trim();
		String asesorVal = txtAsesor.getText().trim();
		String sedeVal = txtSede.getText().trim();

		// 1. CONTROL: CLIENTE
		if (clienteVal.equals("")) {
			JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del cliente.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (!clienteVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
			JOptionPane.showMessageDialog(this, "Nombre inválido. Solo se aceptan letras y espacios.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// 2. CONTROL: DNI
		if (dniVal.equals("")) {
			JOptionPane.showMessageDialog(this, "Debe ingresar el DNI.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (!dniVal.matches("^\\d{8}$")) {
			JOptionPane.showMessageDialog(this, "El DNI debe tener exactamente 8 dígitos numéricos, sin letras.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// 3. CONTROL: TELÉFONO
		if (telefonoVal.equals("")) {
			JOptionPane.showMessageDialog(this, "Debe ingresar el número telefónico.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (!telefonoVal.matches("^\\d{7,15}$")) {
			JOptionPane.showMessageDialog(this, "El número telefónico es incorrecto (ingrese solo de 7 a 15 dígitos).", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// 4. CONTROL: DIRECCIÓN
		if (direccionVal.equals("")) {
			JOptionPane.showMessageDialog(this, "Debe completar el campo Dirección.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// 5. CONTROL: FECHA
		if (fechaVal.equals("")) {
			JOptionPane.showMessageDialog(this, "Debe ingresar la Fecha de la operación.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// 6. CONTROL: ASESOR
		if (asesorVal.equals("")) {
			JOptionPane.showMessageDialog(this, "Debe rellenar el nombre del Asesor.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (!asesorVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
			JOptionPane.showMessageDialog(this, "El nombre del Asesor solo puede contener caracteres alfabéticos.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// 7. CONTROL: SEDE
		if (sedeVal.equals("")) {
			JOptionPane.showMessageDialog(this, "Debe ingresar la Sede.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (!sedeVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
			JOptionPane.showMessageDialog(this, "La Sede solo puede contener letras y espacios.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// 8. CONTROL: CANTIDAD
		if (cantidadVal.equals("")) {
			JOptionPane.showMessageDialog(this, "Establezca una cantidad para proceder.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			cantidad = Integer.parseInt(cantidadVal);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
			return;
			}
			if (cantidad <= 0) {
			JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero.", "Error de Rango", JOptionPane.ERROR_MESSAGE);
			return;
			}
			// CALCULO TRADICIONAL COMERCIAL
			i = cboModelo.getSelectedIndex();
			switch (i) {
			case 0: modelo = FrmPrincipal.modelo0; precio = FrmPrincipal.precio0; break;
			case 1: modelo = FrmPrincipal.modelo1; precio = FrmPrincipal.precio1; break;
			case 2: modelo = FrmPrincipal.modelo2; precio = FrmPrincipal.precio2; break;
			case 3: modelo = FrmPrincipal.modelo3; precio = FrmPrincipal.precio3; break;
			default: modelo = FrmPrincipal.modelo4; precio = FrmPrincipal.precio4; break;
			}
			importeCompra = precio * cantidad;
			if (cantidad >= 1 && cantidad <= 5)
			porcentajeDescuento = FrmPrincipal.porcentaje1;
			else if (cantidad <= 10)
			porcentajeDescuento = FrmPrincipal.porcentaje2;
			else if (cantidad <= 15)
			porcentajeDescuento = FrmPrincipal.porcentaje3;
			else
			porcentajeDescuento = FrmPrincipal.porcentaje4;
			importeDescuento = importeCompra * porcentajeDescuento / 100;
			importePagar = importeCompra - importeDescuento;
			if (cantidad == 1)
			obsequio = FrmPrincipal.obsequio1;
			else if (cantidad <= 5)
			obsequio = FrmPrincipal.obsequio2;
			else
			obsequio = FrmPrincipal.obsequio3;
			FrmPrincipal.numeroVenta++;
			FrmPrincipal.importeTotalGeneral += importePagar;
			// CONSTRUCCIÓN DE LA BOLETA IMPRESA
			txtBoleta.setText("");
			txtBoleta.append("             MOTOSALETEC - BOLETA DE VENTA\n");
			txtBoleta.append("==================================================\n");
			txtBoleta.append("Fecha: " + fechaVal + "         Sede: " + sedeVal.toUpperCase() + "\n");
			txtBoleta.append("Asesor: " + asesorVal.toUpperCase() + "\n");
			txtBoleta.append("--------------------------------------------------\n");
			txtBoleta.append("Cliente: " + clienteVal.toUpperCase() + "\n");
			txtBoleta.append("DNI: " + dniVal + "          Teléfono: " + telefonoVal + "\n");
			txtBoleta.append("Dirección: " + direccionVal + "\n");
			txtBoleta.append("==================================================\n");
			txtBoleta.append("Modelo: " + modelo + "\n");
			txtBoleta.append("Precio Unitario: S/. " + precio + "\n");
			txtBoleta.append("Cantidad: " + cantidad + "\n");
			txtBoleta.append("Importe Compra: S/. " + importeCompra + "\n");
			txtBoleta.append("Descuento: S/. " + importeDescuento + "\n");
			txtBoleta.append("Importe a Pagar: S/. " + importePagar + "\n");
			txtBoleta.append("Obsequio: " + obsequio + "\n");
			// GUARDADO TOTAL DE LA OPERACIÓN EN EL HISTÓRICO TXT
			try {
			FileWriter fw = new FileWriter("ventas.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("NRO_VENTA:" + FrmPrincipal.numeroVenta);
			pw.println("FECHA:" + fechaVal);
			pw.println("SEDE:" + sedeVal);
			pw.println("ASESOR:" + asesorVal);
			pw.println("CLIENTE:" + clienteVal);
			pw.println("DNI:" + dniVal);
			pw.println("TELEFONO:" + telefonoVal);
			pw.println("DIRECCION:" + direccionVal);
			pw.println("MODELO:" + modelo);
			pw.println("PRECIO:" + precio);
			pw.println("CANTIDAD:" + cantidad);
			pw.println("IMPORTE_PAGAR:" + importePagar);
			pw.println("OBSEQUIO:" + obsequio);
			pw.println("==========================================");
			pw.close();
			} catch (Exception e) {
			System.out.println("Error de persistencia de datos: " + e.getMessage());
			}
			if (FrmPrincipal.numeroVenta % 5 == 0) {
			porcentajeCuota = (FrmPrincipal.importeTotalGeneral / FrmPrincipal.cuotaDiaria) * 100;
			JOptionPane.showMessageDialog(this,
			"Venta N°: " + FrmPrincipal.numeroVenta +
			"\nImporte Total General: S/. " + FrmPrincipal.importeTotalGeneral +
			"\nPorcentaje de cuota diaria: " + String.format("%.2f", porcentajeCuota) + "%");
			}
			}
			void limpiar() {
			txtCantidad.setText("");
			txtCliente.setText("");
			txtDni.setText("");
			txtTelefono.setText("");
			txtDireccion.setText("");
			txtFecha.setText("");
			txtAsesor.setText("");
			txtSede.setText("");
			txtBoleta.setText("");
			cboModelo.setSelectedIndex(0);
			mostrarPrecio();
			txtCliente.requestFocus();
			}
			}
		
