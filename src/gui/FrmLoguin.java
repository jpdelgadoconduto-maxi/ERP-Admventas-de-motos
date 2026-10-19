package gui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class FrmLoguin extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmLoguin dialog = new FrmLoguin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmLoguin() {
		setTitle("Ingreso al Sistema");
		// Tamaño de la ventana ajustado a 450 de ancho por 300 de alto
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null); // Centra la ventana en tu monitor
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// =========================================================================
		// COMPONENTES DE TEXTO Y ENTRADA
		// =========================================================================
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14)); // Letra más grande y en negrita
		lblNewLabel_1.setForeground(Color.BLACK); // Cambia el color de la letra a BLANCO
		lblNewLabel_1.setBounds(90, 51, 80, 20); // Ajustado ancho y alto para que no se corte
		contentPanel.add(lblNewLabel_1);

		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14)); // Letra más grande y en negrita
		lblNewLabel_2.setForeground(Color.BLACK); // Cambia el color de la letra a BLANCO
		lblNewLabel_2.setBounds(90, 102, 99, 20); // Ajustado alto para que se vea completo
		contentPanel.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(212, 48, 120, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
					
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 99, 120, 20);
		contentPanel.add(passwordField);
		
		// =========================================================================
		// BOTÓN DE ACCIÓN (INGRESAR)
		// =========================================================================
		
		JButton btnNewButton = new JButton("INGRESAR");
		btnNewButton.setBounds(155, 170, 120, 30);
		contentPanel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = textField.getText().trim();
				String contrasena = new String(passwordField.getPassword());
				
				// Validación básica para abrir tu menú principal
				if (usuario.equals("admin") && contrasena.equals("1234")) {
					JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema!");
					FrmPrincipal principal = new FrmPrincipal();
					principal.setVisible(true);
					dispose(); // Cierra el Login
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña inválidos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// =========================================================================
		// IMAGEN DE FONDO (Colocada al final para que no tape nada)
		// =========================================================================
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Modificamos las coordenadas para abarcar todo el fondo útil (450x260) de forma positiva
		lblNewLabel.setBounds(0, 0, 434, 261);
		
		try {
			ImageIcon iconoOriginal = new ImageIcon(FrmLoguin.class.getResource("/img/png-transparent-motorcycle-moto-motorcycle-racing-accessories-tea.png"));
			// Se escala exactamente al tamaño útil del contenedor
			Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(434, 261, Image.SCALE_SMOOTH);
			lblNewLabel.setIcon(new ImageIcon(imagenEscalada));
		} catch (Exception e) {
			System.out.println("No se pudo cargar la imagen de fondo, se mantendrá en gris.");
		}
		
		contentPanel.add(lblNewLabel); // Agregada al final de la pila
	}
}
