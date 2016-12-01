package br.univel.trabalho.controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.univel.trabalho.model.Cliente;
import br.univel.trabalho.socket.ClienteSocket;
import br.univel.trabalho.view.TelaCliente;

public class TelaClienteController {

	private static TelaClienteController telaClienteController;
	private static TelaCliente telaCliente;

	public static synchronized TelaClienteController getInstance() {
		if (telaClienteController == null) {
			telaClienteController = new TelaClienteController();
		}
		return telaClienteController;
	}

	public void visible() {
		this.carregaListaCliente(ClienteSocket.getInstance().send(new String("listaCliente")));
	}

	public void hide() {
		telaCliente.setVisible(false);
	}

	public void carregaListaCliente(Object object) {
		telaCliente = new TelaCliente();
		List<Cliente> listaCliente = (List<Cliente>) object;

		for (int i = 0; i < listaCliente.size(); i++) {
			Cliente cliente = listaCliente.get(i);
			Object[] fila = new Object[4];
			fila[0] = cliente.getNome();
			fila[1] = cliente.getNascimento();
			fila[2] = cliente.getCpf();
			fila[3] = cliente.getRg();

			((DefaultTableModel) telaCliente.getTable().getModel()).addRow(fila);
		}
		telaCliente.setVisible(true);
	}
}
