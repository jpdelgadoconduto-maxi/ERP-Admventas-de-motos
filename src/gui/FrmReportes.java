package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedHashSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FrmReportes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JComboBox<String> cboFecha;
	private JComboBox<String> cboSede;
	private JComboBox<String> cboModelo;
	private JComboBox<String> cboAsesor;
	
	private JTextArea txtReporteResultados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmReportes dialog = new FrmReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the JDialog.
	 */
	public FrmReportes() {
		setTitle("Módulo de Reportes Dinámicos con Exportación");
		setBounds(100, 100, 670, 470); // Se amplió ligeramente el ancho para los 3 botones
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Font fuenteFormulario = new Font("Segoe UI", Font.PLAIN, 13);

		// =====================================================
		// FILAS DE CRITERIOS (ETIQUETAS Y DESPLEGABLES)
		// =====================================================

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(fuenteFormulario);
		lblFecha.setBounds(25, 20, 60, 25);
		contentPanel.add(lblFecha);

		cboFecha = new JComboBox<String>();
		cboFecha.setFont(fuenteFormulario);
		cboFecha.setBounds(90, 20, 150, 25);
		contentPanel.add(cboFecha);

		JLabel lblSede = new JLabel("Sede");
		lblSede.setFont(fuenteFormulario);
		lblSede.setBounds(25, 60, 60, 25);
		contentPanel.add(lblSede);

		cboSede = new JComboBox<String>();
		cboSede.setFont(fuenteFormulario);
		cboSede.setBounds(90, 60, 150, 25);
		contentPanel.add(cboSede);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(fuenteFormulario);
		lblModelo.setBounds(25, 100, 60, 25);
		contentPanel.add(lblModelo);

		cboModelo = new JComboBox<String>();
		cboModelo.setFont(fuenteFormulario);
		cboModelo.setBounds(90, 100, 150, 25);
		contentPanel.add(cboModelo);

		JLabel lblAsesor = new JLabel("Asesor");
		lblAsesor.setFont(fuenteFormulario);
		lblAsesor.setBounds(280, 20, 60, 25);
		contentPanel.add(lblAsesor);

		cboAsesor = new JComboBox<String>();
		cboAsesor.setFont(fuenteFormulario);
		cboAsesor.setBounds(340, 20, 250, 25);
		contentPanel.add(cboAsesor);

		// =====================================================
		// CUADRO DE TEXTO (ÁREA DE RESULTADOS)
		// =====================================================

		txtReporteResultados = new JTextArea();
		txtReporteResultados.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtReporteResultados.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(txtReporteResultados);
		scrollPane.setBounds(25, 150, 595, 220);
		contentPanel.add(scrollPane);

		// =====================================================
		// PANEL DE BOTONES INFERIOR
		// =====================================================
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(25, 385, 595, 35);
		buttonPane.setLayout(null);
		contentPanel.add(buttonPane);

		// Botón 1: Generar
		JButton btnGenerar = new JButton("Generar Reporte");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGenerarActionPerformed(e);
			}
		});
		btnGenerar.setFont(fuenteFormulario);
		btnGenerar.setBounds(40, 2, 140, 30);
		buttonPane.add(btnGenerar);

		// Botón 2: NUEVO BOTÓN EXPORTAR / DESCARGAR
		JButton btnExportar = new JButton("Exportar / Descargar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExportarActionPerformed(e);
			}
		});
		btnExportar.setFont(fuenteFormulario);
		btnExportar.setBounds(200, 2, 170, 30);
		buttonPane.add(btnExportar);

		// Botón 3: Cerrar
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(fuenteFormulario);
		btnCerrar.setBounds(390, 2, 110, 30);
		btnCerrar.addActionListener(e -> dispose());
		buttonPane.add(btnCerrar);

		cargarFiltrosDesdeArchivoTxt();
	}

	private void cargarFiltrosDesdeArchivoTxt() {
		cboFecha.addItem("--- TODAS ---");
		cboSede.addItem("--- TODAS ---");
		cboModelo.addItem("--- TODOS ---");
		cboAsesor.addItem("--- TODOS ---");

		LinkedHashSet<String> listaFechas = new LinkedHashSet<>();
		LinkedHashSet<String> listaSedes = new LinkedHashSet<>();
		LinkedHashSet<String> listaModelos = new LinkedHashSet<>();
		LinkedHashSet<String> listaAsesores = new LinkedHashSet<>();

		try (BufferedReader br = new BufferedReader(new FileReader("ventas.txt"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				linea = linea.trim();
				
				if (linea.startsWith("FECHA:")) {
					listaFechas.add(linea.split(":")[1].trim());
				} else if (linea.startsWith("SEDE:")) {
					listaSedes.add(linea.split(":")[1].trim());
				} else if (linea.startsWith("MODELO:")) {
					listaModelos.add(linea.split(":")[1].trim());
				} else if (linea.startsWith("ASESOR:")) {
					listaAsesores.add(linea.split(":")[1].trim());
				}
			}

			for (String f : listaFechas) cboFecha.addItem(f);
			for (String s : listaSedes) cboSede.addItem(s);
			for (String m : listaModelos) cboModelo.addItem(m);
			for (String a : listaAsesores) cboAsesor.addItem(a);

		} catch (java.io.FileNotFoundException e) {
			System.out.println("Archivo ventas.txt ausente.");
		} catch (Exception e) {
			System.out.println("Error procesando los combos: " + e.getMessage());
		}
	}

	protected void btnGenerarActionPerformed(ActionEvent e) {
		String filtroFecha = cboFecha.getSelectedItem().toString();
		String filtroSede = cboSede.getSelectedItem().toString();
		String filtroModelo = cboModelo.getSelectedItem().toString();
		String filtroAsesor = cboAsesor.getSelectedItem().toString();

		txtReporteResultados.setText("");
		txtReporteResultados.append("=========================================================\n");
		txtReporteResultados.append("               REPORTE HISTÓRICO DE VENTAS               \n");
		txtReporteResultados.append("=========================================================\n");
		txtReporteResultados.append(String.format("%-10s %-12s %-15s %-15s %-10s\n", "Nro Venta", "Fecha", "Modelo", "Sede", "Importe"));
		txtReporteResultados.append("---------------------------------------------------------\n");

		int contadorVentasFiltradas = 0;
		double acumuladoDineroFiltrado = 0;

		String nroVenta = "", fecha = "", sede = "", asesor = "", modelo = "", importe = "";

		try (BufferedReader br = new BufferedReader(new FileReader("ventas.txt"))) {
			String linea;
			
			while ((linea = br.readLine()) != null) {
				linea = linea.trim();
				
				if (linea.startsWith("NRO_VENTA:")) nroVenta = linea.split(":")[1].trim();
				else if (linea.startsWith("FECHA:")) fecha = linea.split(":")[1].trim();
				else if (linea.startsWith("SEDE:")) sede = linea.split(":")[1].trim();
				else if (linea.startsWith("ASESOR:")) asesor = linea.split(":")[1].trim();
				else if (linea.startsWith("MODELO:")) modelo = linea.split(":")[1].trim();
				else if (linea.startsWith("IMPORTE_PAGAR:")) importe = linea.split(":")[1].trim();
				
				else if (linea.startsWith("====")) {
					boolean cumpleFecha = filtroFecha.equals("--- TODAS ---") || fecha.equalsIgnoreCase(filtroFecha);
					boolean cumpleSede = filtroSede.equals("--- TODAS ---") || sede.equalsIgnoreCase(filtroSede);
					boolean cumpleModelo = filtroModelo.equals("--- TODOS ---") || modelo.equalsIgnoreCase(filtroModelo);
					boolean cumpleAsesor = filtroAsesor.equals("--- TODOS ---") || asesor.equalsIgnoreCase(filtroAsesor);

					if (cumpleFecha && cumpleSede && cumpleModelo && cumpleAsesor) {
						double monto = Double.parseDouble(importe);
						txtReporteResultados.append(String.format("%-10s %-12s %-15s %-15s S/. %-8.2f\n", 
								nroVenta, fecha, modelo, sede, monto));
						contadorVentasFiltradas++;
						acumuladoDineroFiltrado += monto;
					}
					
					nroVenta = ""; fecha = ""; sede = ""; asesor = ""; modelo = ""; importe = "";
				}
			}

			txtReporteResultados.append("---------------------------------------------------------\n");
			txtReporteResultados.append("Total de Ventas Coincidentes: " + contadorVentasFiltradas + "\n");
			txtReporteResultados.append(String.format("Monto Acumulado Filtrado:    S/. %.2f\n", acumuladoDineroFiltrado));
			txtReporteResultados.append("=========================================================\n");

		} catch (java.io.FileNotFoundException ex) {
			txtReporteResultados.setText("Aviso: El archivo 'ventas.txt' no existe todavía. Realice una venta primero.");
		} catch (Exception ex) {
			txtReporteResultados.setText("Error al procesar los datos del reporte: " + ex.getMessage());
		}
	}

	// =====================================================
	// 📥 ACCIÓN DEL NUEVO BOTÓN: DESCARGAR REPORTE COMO TXT
	// =====================================================
	protected void btnExportarActionPerformed(ActionEvent e) {
		String contenidoReporte = txtReporteResultados.getText().trim();

		// Validación: Comprobar si el JTextArea está vacío o solo tiene el aviso inicial
		if (contenidoReporte.equals("") || contenidoReporte.startsWith("Aviso:")) {
			JOptionPane.showMessageDialog(this, "No hay ningún reporte generado para exportar. Genere uno primero.", "Atención", JOptionPane.WARNING_MESSAGE);
			return;
			}
			// Crear el explorador de archivos nativo de Windows/Mac
			JFileChooser exploradorArchivos = new JFileChooser();
			exploradorArchivos.setDialogTitle("Seleccione dónde guardar el reporte descargado");
			// Sugerir un nombre de archivo por defecto al usuario
			exploradorArchivos.setSelectedFile(new java.io.File("Reporte_Filtrado_Motos.txt"));
			int seleccionUsuario = exploradorArchivos.showSaveDialog(this);
			if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			java.io.File rutaDestino = exploradorArchivos.getSelectedFile();
			// Escribir el contenido del JTextArea directamente en la ruta elegida por el usuario
			try (FileWriter fw = new FileWriter(rutaDestino);
			PrintWriter pw = new PrintWriter(fw)) {
			pw.print(txtReporteResultados.getText());
			JOptionPane.showMessageDialog(this, "¡Reporte descargado y exportado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar guardar el archivo: " + ex.getMessage(), "Error de Disco", JOptionPane.ERROR_MESSAGE);
			}
			}
			}
			}
		
