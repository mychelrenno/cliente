package br.univel.trabalho.controller;

import br.univel.trabalho.view.TelaPrincipal;

public class TelaPrincipalController {

	private static TelaPrincipalController principalController;
	private static TelaPrincipal telaPrincipal;

	public static synchronized TelaPrincipalController getInstance() {
		if (principalController == null) {
			principalController = new TelaPrincipalController();
		}
		return principalController;
	}

	public void visible() {
		telaPrincipal = new TelaPrincipal();
		telaPrincipal.setVisible(true);
	}

	public void hide() {
		telaPrincipal.setVisible(false);
	}
}
