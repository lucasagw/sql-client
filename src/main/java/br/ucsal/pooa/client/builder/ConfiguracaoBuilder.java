package br.ucsal.pooa.client.builder;

import br.ucsal.pooa.client.backend.Configuracao;

public class ConfiguracaoBuilder {

	private static final String URL_DEFAULT = "jdbc:hsqldb:mem:mymemdb";

	private static final String USUARIO_DEFAULT = "SA";

	private static final String SENHA_DEFAULT = "";

	private static final String DRIVER_DEFAULT = "org.hsqldb.jdbc.JDBCDriver";

	private String url = URL_DEFAULT;

	private String usuario = USUARIO_DEFAULT;

	private String senha = SENHA_DEFAULT;

	private String driver = DRIVER_DEFAULT;

	private ConfiguracaoBuilder() {

	}

	public static ConfiguracaoBuilder umBanco() {
		return new ConfiguracaoBuilder();
	}

	public ConfiguracaoBuilder comURL(String url) {
		this.url = url;
		return this;
	}

	public ConfiguracaoBuilder comUsuario(String usuario) {
		this.usuario = usuario;
		return this;
	}

	public ConfiguracaoBuilder comSenha(String senha) {
		this.senha = senha;
		return this;
	}

	public ConfiguracaoBuilder comDriver(String driver) {
		this.driver = driver;
		return this;
	}

	public ConfiguracaoBuilder mas() {
		return new ConfiguracaoBuilder().comURL(url).comUsuario(usuario).comSenha(senha).comDriver(driver);
	}

	public Configuracao build() {

		Configuracao configuracao = new Configuracao();
		configuracao.setUrl(url);
		configuracao.setUsuario(usuario);
		configuracao.setSenha(senha);
		configuracao.setDriver(driver);

		return configuracao;
	}

}
