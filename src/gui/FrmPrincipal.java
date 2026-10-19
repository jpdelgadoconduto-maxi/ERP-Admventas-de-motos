package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// =====================================================
	// VARIABLES GLOBALES - MOTOS
	// =====================================================

	// MOTO 1
	public static String modelo0 = "Honda CB190R";
	public static double precio0 = 9500;
	public static double cilindrada0 = 184;
	public static double velocidad0 = 140;
	public static double peso0 = 142;

	// MOTO 2
	public static String modelo1 = "Yamaha FZ 2.0";
	public static double precio1 = 9800;
	public static double cilindrada1 = 149;
	public static double velocidad1 = 135;
	public static double peso1 = 137;

	// MOTO 3
	public static String modelo2 = "Suzuki Gixxer";
	public static double precio2 = 10200;
	public static double cilindrada2 = 155;
	public static double velocidad2 = 145;
	public static double peso2 = 141;

	// MOTO 4
	public static String modelo3 = "Bajaj Pulsar NS200";
	public static double precio3 = 11500;
	public static double cilindrada3 = 200;
	public static double velocidad3 = 150;
	public static double peso3 = 156;

	// MOTO 5
	public static String modelo4 = "KTM Duke 200";
	public static double precio4 = 13500;
	public static double cilindrada4 = 200;
	public static double velocidad4 = 155;
	public static double peso4 = 159;

	// =====================================================
	// DESCUENTOS
	// =====================================================

	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;

	// =====================================================
	// OBSEQUIOS
	// =====================================================

	public static String obsequio1 = "Casco";
	public static String obsequio2 = "Guantes";
	public static String obsequio3 = "Chaqueta";

	// =====================================================
	// ACUMULADORES
	// =====================================================

	public static int numeroVenta = 0;
	public static double importeTotalGeneral = 0;

	// =====================================================
	// CUOTA DIARIA
	// =====================================================

	public static double cuotaDiaria = 50000;

	// =====================================================
	// MAIN
	// =====================================================

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// =====================================================
	// CONSTRUCTOR
	// =====================================================

	public FrmPrincipal() {
		setTitle("Sistema de Venta de Motos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		// 1. TÍTULO PRINCIPAL GRANDE
		JLabel lblBienvenidaTitulo = new JLabel("¡BIENVENIDO!");
		lblBienvenidaTitulo.setForeground(Color.WHITE);
		lblBienvenidaTitulo.setFont(new Font("Tahoma", Font.BOLD, 28)); 
		lblBienvenidaTitulo.setBounds(10, 61, 558, 35);
		contentPane.add(lblBienvenidaTitulo);

		// 2. DISCURSO / SPEECH LLAMATIVO
		JLabel lblBienvenidaSpeech = new JLabel(
		    "<html><body style='width: 280px; text-align: left;'>"
		    + "Tu centro de administración integral. Gestiona inventarios, optimiza ventas "
		    + "y acelera el crecimiento de tu negocio con total eficiencia.<br><br>"
		    + "<b>¡El poder de avanzar sobre dos ruedas está aquí!</b>"
		    + "</body></html>"
		);
		lblBienvenidaSpeech.setForeground(new Color(230, 230, 230)); 
		lblBienvenidaSpeech.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		lblBienvenidaSpeech.setBounds(48, 124, 390, 180);
		contentPane.add(lblBienvenidaSpeech);
		
		// 3. BOTÓN SALIR
		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLoguin login = new FrmLoguin();
				login.setVisible(true);
				dispose(); 
			}
		});
		btnNewButton.setBounds(560, 326, 89, 23);
		contentPane.add(btnNewButton);
		
		// 4. IMAGEN DE FONDO
		JLabel MANTENIMIENTO = new JLabel("");
		MANTENIMIENTO.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/moto-yamaha.jpg")));
		MANTENIMIENTO.setBounds(0, 0, 688, 390); 
		contentPane.add(MANTENIMIENTO);
		
		JMenu mnAyuda_1 = new JMenu("Ayuda");
		mnAyuda_1.setBounds(302, 25, 47, 20);
		contentPane.add(mnAyuda_1);
		
		JMenuItem mnAcerca_1 = new JMenuItem("Acerca de Tienda");
		mnAyuda_1.add(mnAcerca_1);

		// =====================================================
		// MENÚ PRINCIPAL SUPERIOR
		// =====================================================

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// =====================================================
		// PESTAÑA: MANTENIMIENTO
		// =====================================================

		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		JMenuItem mntmConsultar = new JMenuItem("Consultar moto");
		mnMantenimiento.add(mntmConsultar);
		mntmConsultar.addActionListener(e -> {
			FrmConsultarMoto frm = new FrmConsultarMoto();
			frm.setVisible(true);
		});

		JMenuItem mntmModificar = new JMenuItem("Modificar moto");
		mnMantenimiento.add(mntmModificar);
		mntmModificar.addActionListener(e -> {
			FrmModificarMoto frm = new FrmModificarMoto();
			frm.setVisible(true);
		});

		JMenuItem mntmListar = new JMenuItem("Listar motos");
		mnMantenimiento.add(mntmListar);
		mntmListar.addActionListener(e -> {
			FrmListadoMotos frm = new FrmListadoMotos();
			frm.setVisible(true);
		});

		// =====================================================
		// PESTAÑA: VENTAS
		// =====================================================

		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);

		JMenuItem mntmVender = new JMenuItem("Vender");
		mnVentas.add(mntmVender);
		mntmVender.addActionListener(e -> {
			FrmVentas frm = new FrmVentas();
			frm.setVisible(true);
		});

		// =====================================================
		// PESTAÑA: CONFIGURACIÓN
		// =====================================================

		JMenu mnConfiguracion = new JMenu("Configuración");
		menuBar.add(mnConfiguracion);

		JMenuItem mnDescuento = new JMenuItem("Configurar descuentos");
		mnDescuento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnDescuentoActionPerformed(e);
			}
		});
		mnConfiguracion.add(mnDescuento);

		JMenuItem mnObsequio = new JMenuItem("Configurar obsequios");
		mnObsequio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnObsequioActionPerformed(e);
			}
		});
		mnConfiguracion.add(mnObsequio);
		
		// =====================================================
		// PESTAÑA: REPORTES (Estética unificada de JMenu con un clic directo)
		// =====================================================

		JMenu mnReportesEstetico = new JMenu("Reportes");
		menuBar.add(mnReportesEstetico);
		
		// El MenuListener intercepta el clic directo sobre el encabezado sin requerir submenús flotantes
		mnReportesEstetico.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				FrmReportes frm = new FrmReportes();
				frm.setModal(true);
				frm.setVisible(true);
			}

			@Override
			public void menuDeselected(MenuEvent e) {}

			@Override
			public void menuCanceled(MenuEvent e) {}
		});

		// =====================================================
		// PESTAÑA: AYUDA
		// =====================================================

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JMenuItem mnAcerca = new JMenuItem("Acerca de Tienda");
		mnAcerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmAcercaActionPerformed(e);
			}
		});
		mnAyuda.add(mnAcerca);
	}
	
	// EVENTO DESCUENTO
	protected void mnDescuentoActionPerformed(ActionEvent e) {
		FrmDescuento frmdescuento = new FrmDescuento();
		frmdescuento.setLocationRelativeTo(this);
		frmdescuento.setVisible(true);
	}
	
	// EVENTO OBSEQUIO
	protected void mnObsequioActionPerformed(ActionEvent e) {
		FrmObsequio frmobsequio = new FrmObsequio();
		frmobsequio.setLocationRelativeTo(this);
		frmobsequio.setVisible(true);
	}
	
	// EVENTO AYUDA
	protected void mntmAcercaActionPerformed(ActionEvent e) {
		FrmMotoRatones frmmotoratones = new FrmMotoRatones();
		frmmotoratones.setLocationRelativeTo(this);
		frmmotoratones.setVisible(true);
	}
}
