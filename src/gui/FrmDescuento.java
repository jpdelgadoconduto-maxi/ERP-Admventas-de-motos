package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDescuento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtP1;
	private JTextField txtP2;
	private JTextField txtP3;
	private JTextField txtP4;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton;
	private JButton btnCancear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDescuento frame = new FrmDescuento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDescuento() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Configurar porcentajes de descuento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel_1 = new JLabel("1 a 5 unidades");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1.setBounds(10, 52, 112, 17);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel = new JLabel("6 a 10 unidades");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(10, 84, 125, 17);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_2 = new JLabel("11 a 15 unidades");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setBounds(10, 116, 125, 17);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Mas de 15 unidades");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_3.setBounds(10, 145, 153, 17);
			contentPane.add(lblNewLabel_3);
		}
		{
			txtP1 = new JTextField();
			txtP1.setBounds(161, 51, 96, 18);
			contentPane.add(txtP1);
			txtP1.setColumns(10);
		}
		{
			txtP2 = new JTextField();
			txtP2.setColumns(10);
			txtP2.setBounds(161, 83, 96, 18);
			contentPane.add(txtP2);
		}
		{
			txtP3 = new JTextField();
			txtP3.setColumns(10);
			txtP3.setBounds(161, 115, 96, 18);
			contentPane.add(txtP3);
		}
		{
			txtP4 = new JTextField();
			txtP4.setColumns(10);
			txtP4.setBounds(161, 144, 96, 18);
			contentPane.add(txtP4);
		}
		{
			lblNewLabel_4 = new JLabel("%");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_4.setBounds(267, 52, 31, 17);
			contentPane.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("%");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_5.setBounds(267, 84, 31, 17);
			contentPane.add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("%");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_6.setBounds(267, 116, 31, 17);
			contentPane.add(lblNewLabel_6);
		}
		{
			lblNewLabel_7 = new JLabel("%");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_7.setBounds(267, 145, 31, 17);
			contentPane.add(lblNewLabel_7);
			txtP1.setText(FrmPrincipal.porcentaje1+"");
			txtP2.setText(FrmPrincipal.porcentaje2+"");
			txtP3.setText(FrmPrincipal.porcentaje3+"");
			txtP4.setText(FrmPrincipal.porcentaje4+"");
		}
		{
			btnNewButton = new JButton("Aceptar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButtonActionPerformed(e);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton.setBounds(322, 52, 96, 20);
			contentPane.add(btnNewButton);
		}
		{
			btnCancear = new JButton("Cancelar");
			btnCancear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCancelarActionPerformed(e);
				}
			});
			btnCancear.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnCancear.setBounds(322, 84, 96, 20);
			contentPane.add(btnCancear);
		}

	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		
			try {
				// 1. Cambiamos .getSelectedText() por .getText() para leer el número completo
				FrmPrincipal.porcentaje1 = Double.parseDouble(txtP1.getText().trim());
				FrmPrincipal.porcentaje2 = Double.parseDouble(txtP2.getText().trim());
				FrmPrincipal.porcentaje3 = Double.parseDouble(txtP3.getText().trim());
				FrmPrincipal.porcentaje4 = Double.parseDouble(txtP4.getText().trim());
				
				// 2. Mostramos un mensaje de confirmación al usuario
				javax.swing.JOptionPane.showMessageDialog(this, "Porcentajes de descuento actualizados correctamente.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
				
				// 3. Cerramos la ventana de configuración
				dispose();
				
			} catch (NumberFormatException ex) {
				// Mensaje de alerta en caso de que dejen un campo vacío o escriban letras
				javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos en todos los campos.", "Error de formato", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
		

	}
	protected void btnCancelarActionPerformed(ActionEvent e) {
		dispose();
	}
}
