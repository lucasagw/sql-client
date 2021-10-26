package br.ucsal.pooa.client.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.ucsal.pooa.client.backend.Configuracao;
import br.ucsal.pooa.client.test.SQLClient;

public class ConfiguracaoPanel extends JFrame {

	private Configuracao configuracao = new Configuracao();

	private JLabel url = new JLabel("URL:");
	private JLabel usuario = new JLabel("Usuario:");
	private JLabel senha = new JLabel("Senha:");
	private JLabel driver = new JLabel("Driver:");

	private JTextField urlText = new JTextField();
	private JTextField usuarioText = new JTextField();
	private JTextField senhaText = new JTextField();
	private JTextField driverText = new JTextField();

	private JButton confirmar = new JButton("Confirmar");
	private JButton cancelar = new JButton("Cancelar");
	
	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}

	public ConfiguracaoPanel() {
		super();
		setLayout(new GridLayout(5, 2));
		this.setSize(400, 400);

		this.add(url);
		this.add(urlText);

		this.add(usuario);
		this.add(usuarioText);

		this.add(senha);
		this.add(senhaText);

		this.add(driver);
		this.add(driverText);

		this.add(cancelar);
		this.add(confirmar);

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
	}

}
