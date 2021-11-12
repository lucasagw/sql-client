package br.ucsal.pooa.client.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Banco {

	private Connection connection;

	private Map<String, Command> comandos = new HashMap<>();

	public Banco(Configuracao configuracao) {

		try {
			Class.forName(configuracao.getDriver());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(configuracao.getUrl(), configuracao.getUsuario(),
					configuracao.getSenha());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		comandos.put("SELECT", new Consulta());
		comandos.put("CREATE", new CriarTabela());
		comandos.put("UPDATE", new Update());

	}

	public String executar(String sql) {

		String[] comandos = sql.toUpperCase().split(" ");

		Command comando = this.comandos.getOrDefault(comandos[0], 
				this.comandos.get("CREATE"));

		String retorno = "";
		try {
			retorno = comando.executar(connection.createStatement(), sql);
			// SELECT * FROM XPTO
			// SELECT NOME FROM XPTO
			// CREATE TABLE XPTO (ID IDENTITY PRIMARY KEY, NOME VARCHAR(30))
			// INSERT INTO XPTO VALUES (1, 'Lucas')
		} catch (Exception sqlErro) {
			sqlErro.printStackTrace();
			retorno = sqlErro.getMessage();
		}
		return retorno;
	}
}
