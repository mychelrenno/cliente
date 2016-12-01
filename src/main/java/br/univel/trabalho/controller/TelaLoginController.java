package br.univel.trabalho.controller;

import java.security.MessageDigest;

import javax.swing.JOptionPane;

import br.univel.trabalho.model.Login;
import br.univel.trabalho.socket.ClienteSocket;
import br.univel.trabalho.view.TelaLogin;

public class TelaLoginController {

	private static TelaLoginController loginController;
	private static TelaLogin telaLogin;

	public static synchronized TelaLoginController getInstance() {
		if (loginController == null) {
			loginController = new TelaLoginController();
		}
		return loginController;
	}

	public void visible() {
		telaLogin = new TelaLogin();
		telaLogin.setVisible(true);
	}

	public void hide() {
		telaLogin.setVisible(false);
	}

	public void login(String usuario, String senha) {
		Login login = new Login();
		login.setUsuario(usuario);
		login.setSenha(getSHA256(senha));

		login = (Login) ClienteSocket.getInstance().send(login);
		if (login.getId() != null) {
			this.hide();
			TelaPrincipalController.getInstance().visible();
		} else {
			JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
		}
	}

	public String getSHA256(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			System.out.println(hexString.toString());
			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
