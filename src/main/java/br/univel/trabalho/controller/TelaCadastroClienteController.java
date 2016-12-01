package br.univel.trabalho.controller;

import br.univel.trabalho.model.Cliente;
import br.univel.trabalho.socket.ClienteSocket;
import br.univel.trabalho.view.TelaCliente;

public class TelaCadastroClienteController {

	private static TelaCadastroClienteController telaCadastroClienteController;
	private static TelaCliente TelaCadastroCliente;

	public static synchronized TelaCadastroClienteController getInstance() {
		if (telaCadastroClienteController == null) {
			telaCadastroClienteController = new TelaCadastroClienteController();
		}
		return telaCadastroClienteController;
	}
	
	public void visible(){
		TelaCadastroCliente = new TelaCliente();
		TelaCadastroCliente.setVisible(true);
	}
	
	public void hide(){
		TelaCadastroCliente.setVisible(false);
	}
	
	public void cadastrar(final Cliente cliente){
		ClienteSocket.getInstance().send(cliente);
	}
}
