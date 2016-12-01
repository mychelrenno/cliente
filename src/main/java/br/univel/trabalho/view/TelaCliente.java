package br.univel.trabalho.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public TelaCliente() {
		setTitle("Listar pessoa");
		setSize(400, 400);
		setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();

		JButton adicionar = new JButton("+");
		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JButton deletar = new JButton("-");

		JButton editar = new JButton("Editar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE).addGroup(
										Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(editar)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(deletar)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(adicionar)))
						.addContainerGap()));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(adicionar).addComponent(deletar).addComponent(editar))
										.addGap(13)));

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Nasc.", "CPF", "RG" }));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
