package br.univel.trabalho.view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import br.univel.trabalho.controller.TelaClienteController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	public TelaPrincipal() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItemCliente = new JMenuItem("Cliente");
		menuItemCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaClienteController.getInstance().visible();
			}
		});
		mnNewMenu.add(menuItemCliente);
		
		JMenuItem menuItemProfissional = new JMenuItem("Profissional");
		mnNewMenu.add(menuItemProfissional);
	}

}
