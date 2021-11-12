package br.ucsal.pooa.client.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.ucsal.pooa.client.backend.Configuracao;
import br.ucsal.pooa.client.test.SQLClient;

public class ConfiguracaoPanel extends JFrame {

	private Configuracao configuracao = new Configuracao();

	private JLabel url = new JLabel("URL:", SwingConstants.CENTER);
	private JLabel usuario = new JLabel("Usuario:", SwingConstants.CENTER);
	private JLabel senha = new JLabel("Senha:", SwingConstants.CENTER);
	private JLabel driver = new JLabel("Driver:", SwingConstants.CENTER);

	private JTextField urlText = new JTextField(20);
	private JTextField usuarioText = new JTextField(20);
	private JTextField senhaText = new JTextField(20);
	private JTextField driverText = new JTextField(20);
	
    private JPanel grid = new JPanel(new GridLayout(5, 2));
	
	private JButton confirmar = new JButton("Confirmar");
	private JButton cancelar = new JButton("Cancelar");
	
	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}

	public ConfiguracaoPanel() {
		super("Configurações");
		setLayout(new FlowLayout());
		
		setResizable(false);
		
		this.setSize(400, 400);

		grid.add(url);
//		url.setBackground(Color.red);
//		url.setOpaque(true);
		grid.add(urlText);
		urlText.setText("jdbc:hsqldb:mem:mymemdb"); //default
	
		grid.add(usuario);
		grid.add(usuarioText);
		usuarioText.setText("SA"); //default

		grid.add(senha);
		grid.add(senhaText);
		senhaText.setText(""); //default

		grid.add(driver);
		grid.add(driverText);
		driverText.setText("org.hsqldb.jdbc.JDBCDriver"); //default

		grid.add(cancelar);
		grid.add(confirmar);
		
		this.add(grid);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});

		confirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//fazer uma validação disso aqui
				configuracao.setUrl(urlText.getText());
				configuracao.setUsuario(usuarioText.getText());
				configuracao.setSenha(senhaText.getText());
				configuracao.setDriver(driverText.getText());
				setVisible(false);
//				TelaConsulta janela = new TelaConsulta(configuracao);
//				janela.setVisible(true);
				SQLClient.client();

			}
		});
		
		this.pack();
		
	}

}
