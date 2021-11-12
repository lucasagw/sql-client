package br.ucsal.pooa.client.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ucsal.pooa.client.backend.Banco;
import br.ucsal.pooa.client.backend.Configuracao;

public class TelaConsulta extends JFrame {

	private JTextField campo = new JTextField(30);

	private JButton botao = new JButton("Executar");

	private JEditorPane resultados = new JEditorPane();
	
	private Banco banco;

	public TelaConsulta(Configuracao configuracao) {
		super("JSQLClient");
		setSize(400, 800);
		JPanel topo = new JPanel();
		topo.add(new JLabel("SQL:"));
		topo.add(campo);
		topo.add(botao);
		this.add(topo, BorderLayout.NORTH);
		this.add(resultados);

		banco = new Banco(configuracao);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String sql = campo.getText();

				resultados.setText(banco.executar(sql));

			}
		});
	}
}
