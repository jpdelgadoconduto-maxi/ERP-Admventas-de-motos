package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmObsequio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblA;
	private JLabel lblAMas;
	private JTextField txtObsequio1;
	private JTextField txtObsequio2;
	private JTextField txtObsequio3;
	private JButton btnNewButton;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmObsequio frame = new FrmObsequio();
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
	public FrmObsequio() {
		setTitle("Configurar Obsequios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("1 unidad");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(22, 10, 62, 17);
			contentPane.add(lblNewLabel);
			
		}
		{
			lblA = new JLabel("2 a 5 unidades");
			lblA.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblA.setBounds(22, 37, 104, 17);
			contentPane.add(lblA);
		}
		{
			lblAMas = new JLabel("6 a mas unidades");
			lblAMas.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAMas.setBounds(22, 64, 125, 17);
			contentPane.add(lblAMas);
		}
		{
			txtObsequio1 = new JTextField();
			txtObsequio1.setBounds(165, 11, 96, 18);
			contentPane.add(txtObsequio1);
			txtObsequio1.setColumns(10);
		}
		{
			txtObsequio2 = new JTextField();
			txtObsequio2.setColumns(10);
			txtObsequio2.setBounds(165, 38, 96, 18);
			contentPane.add(txtObsequio2);
		}
		{
			txtObsequio3 = new JTextField();
			txtObsequio3.setColumns(10);
			txtObsequio3.setBounds(165, 65, 96, 18);
			contentPane.add(txtObsequio3);
			txtObsequio1.setText(FrmPrincipal.obsequio1);
			txtObsequio2.setText(FrmPrincipal.obsequio2);
			txtObsequio3.setText(FrmPrincipal.obsequio3);
		}
		{
			btnNewButton = new JButton("Aceptar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButtonActionPerformed(e);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnNewButton.setBounds(319, 10, 96, 20);
			contentPane.add(btnNewButton);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCancelarActionPerformed(e);
				}
			});
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnCancelar.setBounds(319, 37, 96, 20);
			contentPane.add(btnCancelar);
		}

	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		
		FrmPrincipal.obsequio1=txtObsequio1.getText();
		FrmPrincipal.obsequio2=txtObsequio2.getText();
		FrmPrincipal.obsequio3=txtObsequio3.getText();
		dispose();
	}
	protected void btnCancelarActionPerformed(ActionEvent e) {
		dispose();
		
	}
}
