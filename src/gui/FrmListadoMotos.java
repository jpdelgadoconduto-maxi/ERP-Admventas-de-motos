package gui;

import javax.swing.*;
import java.awt.Font;

public class FrmListadoMotos extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextArea txtS;

	public FrmListadoMotos() {

		setTitle("Listado de Motos");
		setSize(520, 420);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		// =====================================================
		// ÁREA DE TEXTO
		// =====================================================

		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane(txtS);
		scrollPane.setBounds(10, 10, 485, 300);
		getContentPane().add(scrollPane);

		// =====================================================
		// BOTÓN CERRAR
		// =====================================================

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrar.setBounds(120, 330, 100, 30);
		getContentPane().add(btnCerrar);

		// =====================================================
		// BOTÓN LISTAR
		// =====================================================

		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListar.setBounds(280, 330, 100, 30);
		getContentPane().add(btnListar);

		// =====================================================
		// EVENTOS
		// =====================================================

		btnListar.addActionListener(e -> listar());

		btnCerrar.addActionListener(e -> dispose());

		// =====================================================
		// CARGA INICIAL
		// =====================================================

		listar();
	}

	// =====================================================
	// MÉTODO LISTAR
	// =====================================================

	void listar() {

		txtS.setText("");

		txtS.append("LISTADO DE MOTOS\n\n");

		// =====================================================
		// MOTO 1
		// =====================================================

		txtS.append("Modelo           : " + FrmPrincipal.modelo0 + "\n");
		txtS.append("Precio           : S/. " + FrmPrincipal.precio0 + "\n");
		txtS.append("Cilindrada       : " + FrmPrincipal.cilindrada0 + " cc\n");
		txtS.append("Peso             : " + FrmPrincipal.peso0 + " kg\n");
		txtS.append("Velocidad        : " + FrmPrincipal.velocidad0 + " km/h\n\n");

		// =====================================================
		// MOTO 2
		// =====================================================

		txtS.append("Modelo           : " + FrmPrincipal.modelo1 + "\n");
		txtS.append("Precio           : S/. " + FrmPrincipal.precio1 + "\n");
		txtS.append("Cilindrada       : " + FrmPrincipal.cilindrada1 + " cc\n");
		txtS.append("Peso             : " + FrmPrincipal.peso1 + " kg\n");
		txtS.append("Velocidad        : " + FrmPrincipal.velocidad1 + " km/h\n\n");

		// =====================================================
		// MOTO 3
		// =====================================================

		txtS.append("Modelo           : " + FrmPrincipal.modelo2 + "\n");
		txtS.append("Precio           : S/. " + FrmPrincipal.precio2 + "\n");
		txtS.append("Cilindrada       : " + FrmPrincipal.cilindrada2 + " cc\n");
		txtS.append("Peso             : " + FrmPrincipal.peso2 + " kg\n");
		txtS.append("Velocidad        : " + FrmPrincipal.velocidad2 + " km/h\n\n");

		// =====================================================
		// MOTO 4
		// =====================================================

		txtS.append("Modelo           : " + FrmPrincipal.modelo3 + "\n");
		txtS.append("Precio           : S/. " + FrmPrincipal.precio3 + "\n");
		txtS.append("Cilindrada       : " + FrmPrincipal.cilindrada3 + " cc\n");
		txtS.append("Peso             : " + FrmPrincipal.peso3 + " kg\n");
		txtS.append("Velocidad        : " + FrmPrincipal.velocidad3 + " km/h\n\n");

		// =====================================================
		// MOTO 5
		// =====================================================

		txtS.append("Modelo           : " + FrmPrincipal.modelo4 + "\n");
		txtS.append("Precio           : S/. " + FrmPrincipal.precio4 + "\n");
		txtS.append("Cilindrada       : " + FrmPrincipal.cilindrada4 + " cc\n");
		txtS.append("Peso             : " + FrmPrincipal.peso4 + " kg\n");
		txtS.append("Velocidad        : " + FrmPrincipal.velocidad4 + " km/h\n");
	}
}