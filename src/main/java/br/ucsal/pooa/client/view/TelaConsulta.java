package br.ucsal.pooa.client.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ucsal.pooa.client.backend.Configuracao;

public class TelaConsulta extends JFrame {

	private Configuracao configuracao;

	private JTextField campo = new JTextField(30);

	private JButton botao = new JButton("Executar");

	private JEditorPane resultados = new JEditorPane();

	private Connection connection;
	
	// melhorar isso aqui, refatorar. APLICAR O SOLID, PARA DIVIDIR AS
	// RESPONSABILIDADES.

	public TelaConsulta(Configuracao configuracao) {
		super("JSQLClient");
		this.configuracao = configuracao;
		setSize(400, 800);
		JPanel topo = new JPanel();
		topo.add(new JLabel("SQL:"));
		topo.add(campo);
		topo.add(botao);
		this.add(topo, BorderLayout.NORTH);
		this.add(resultados);

		try {
			Class.forName(configuracao.getDriver());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

		try {
			DriverManager.getConnection(configuracao.getUrl(), configuracao.getUsuario(), configuracao.getSenha());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sql = campo.getText();
				try {
					Boolean b = connection.createStatement().execute(sql);
					sql.toUpperCase().startsWith("UPDATE");
					int quantidade = connection.createStatement().executeUpdate(sql);
					sql.toUpperCase().startsWith("SELECT");	
					ResultSet rs = connection.createStatement().executeQuery(sql);
					
					
					//resultados.setText(resultado);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
