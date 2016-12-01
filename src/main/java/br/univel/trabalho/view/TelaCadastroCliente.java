package br.univel.trabalho.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.univel.trabalho.controller.TelaCadastroClienteController;
import br.univel.trabalho.model.Cliente;

public class TelaCadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfDtNasc;
	private JTextField tfCPF;
	private JTextField tfRG;

	public TelaCadastroCliente() {
		setTitle("Cadastro pessoa");
		setSize(300, 250);
		
		JLabel lbNome = new JLabel("Nome:");
		
		JLabel lbDtNasc = new JLabel("Data Nasc:");
		
		JLabel lbCPF = new JLabel("CPF:");
		
		JLabel lbRG = new JLabel("RG:");
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		
		tfDtNasc = new JTextField();
		tfDtNasc.setColumns(10);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		
		tfRG = new JTextField();
		tfRG.setColumns(10);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = new Cliente();
				cliente.setNome(tfNome.getText());
				cliente.setNascimento(tfDtNasc.getText());
				cliente.setCpf(tfCPF.getText());
				cliente.setRg(tfRG.getText());
				TelaCadastroClienteController.getInstance().cadastrar(cliente);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btCadastrar)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbDtNasc)
								.addComponent(lbCPF)
								.addComponent(lbNome)
								.addComponent(lbRG))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tfRG, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
								.addComponent(tfNome, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
								.addComponent(tfCPF, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
								.addComponent(tfDtNasc))))
					.addGap(25))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbNome)
						.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbDtNasc)
						.addComponent(tfDtNasc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCPF)
						.addComponent(tfCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbRG)
						.addComponent(tfRG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btCadastrar)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
