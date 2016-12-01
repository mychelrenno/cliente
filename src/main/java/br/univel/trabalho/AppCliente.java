package br.univel.trabalho;

import br.univel.trabalho.controller.TelaLoginController;

public class AppCliente {
	public static void main(String[] args) {
		System.out.println("Aplicação cliente iniciada!");
		TelaLoginController.getInstance().visible();
	}
}
