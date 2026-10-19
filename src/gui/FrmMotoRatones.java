package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;

public class FrmMotoRatones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblAutores;
	private JLabel lblElizabethQuiroz;
	private JLabel lblJeffersonGarca;
	private JLabel lblJuanMendez;
	private JLabel lblJhonatanSusano;
	private JLabel lblElizabethQuiroz_4;
	private JLabel lblElizabethQuiroz_5;
	private JButton btnNewButton;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMotoRatones frame = new FrmMotoRatones();
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
	public FrmMotoRatones() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 469, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("TIENDA 1.0");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel.setBounds(126, 10, 197, 133);
			contentPane.add(lblNewLabel);
		}
		{
			lblAutores = new JLabel("Autores");
			lblAutores.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblAutores.setBounds(159, 106, 136, 62);
			contentPane.add(lblAutores);
		}
		{
			lblElizabethQuiroz = new JLabel("CRISTINA DE FÁTIMA ROSA ALEJOS SEDANO");
			lblElizabethQuiroz.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblElizabethQuiroz.setBounds(132, 164, 243, 27);
			contentPane.add(lblElizabethQuiroz);
		}
		{
			lblJeffersonGarca = new JLabel("ERINSON DIEGO ARTURO LEÓN LLANOS");
			lblJeffersonGarca.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblJeffersonGarca.setBounds(132, 188, 243, 27);
			contentPane.add(lblJeffersonGarca);
		}
		{
			lblJuanMendez = new JLabel("JUNIOR PACAYA DELGADO");
			lblJuanMendez.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblJuanMendez.setBounds(132, 235, 155, 27);
			contentPane.add(lblJuanMendez);
		}
		{
			lblJhonatanSusano = new JLabel("KLISSMAN ROJAS PEÑA");
			lblJhonatanSusano.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblJhonatanSusano.setBounds(132, 212, 209, 27);
			contentPane.add(lblJhonatanSusano);
		}
		
			
	
		{
			btnNewButton = new JButton("Cerrar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButtonActionPerformed(e);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnNewButton.setBounds(177, 337, 84, 20);
			contentPane.add(btnNewButton);
		}
		{
			separator = new JSeparator();
			separator.setBounds(10, 105, 445, 10);
			contentPane.add(separator);
		}

	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		dispose();
	}
}
