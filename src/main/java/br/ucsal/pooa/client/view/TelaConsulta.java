package br.ucsal.pooa.client.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ucsal.pooa.client.backend.Banco;
import br.ucsal.pooa.client.backend.Configuracao;
import br.ucsal.pooa.client.backend.Invoker;

public class TelaConsulta extends JFrame { //Client

	private JTextField campo = new JTextField(30);

	private JButton botao = new JButton("Executar");

	private JEditorPane resultados = new JEditorPane();

	private Banco banco;

	private Invoker invoker;

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
		invoker = new Invoker(banco);

		JMenuBar barra = new JMenuBar();
		this.setJMenuBar(barra);
		JMenu menu = new JMenu("TESTE");
		barra.add(menu);
		JMenuItem itemCria = new JMenuItem("CRIA TABELA TESTE");
		itemCria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resultados.setText(invoker.executar("TESTE"));
				
			}
		});
		menu.add(itemCria);
		JMenuItem itemCarrega = new JMenuItem("CARREGA TESTE");
		JMenuItem geraTeste = new JMenuItem("CRIA E CARREGA TESTE");
		menu.add(itemCarrega);
		menu.add(geraTeste);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String sql = campo.getText();
				resultados.setText(invoker.executar(sql));

			}
		});
	}
}
