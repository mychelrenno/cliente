package br.univel.trabalho.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.univel.trabalho.controller.TelaLoginController;
import javax.swing.JPasswordField;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuario;
	private JPasswordField passwordField;

	public TelaLogin() {
		setResizable(false);
		setTitle("Login");
		setSize(220, 180);
		setLocationRelativeTo(null);

		tfUsuario = new JTextField();
		tfUsuario.setToolTipText("Login...");
		tfUsuario.setColumns(10);

		JButton btEntrar = new JButton("Entrar");
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLoginController loginController = new TelaLoginController();
				loginController.login(tfUsuario.getText(), passwordField.getText());
			}
		});
		
		passwordField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(passwordField, Alignment.LEADING)
						.addComponent(btEntrar)
						.addComponent(tfUsuario, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(tfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btEntrar)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
