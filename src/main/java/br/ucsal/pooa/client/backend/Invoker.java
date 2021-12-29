package br.ucsal.pooa.client.backend;

import java.util.HashMap;
import java.util.Map;

public class Invoker {

	//Invoker
	private Map<String, Command> storeComandos;
	
	private Banco banco;
	
	public Invoker(Banco banco) {
		this.banco = banco;
		storeComandos = new HashMap<>();
		storeComandos.put("SELECT", new Consulta());
		storeComandos.put("CREATE", new CriarTabela());
		storeComandos.put("UPDATE", new Update());
		storeComandos.put("TESTE", new CriaTesteCommand());
		
	}

	public String executar(String sql) {

		String[] comandos = sql.toUpperCase().split(" ");

		Command comando = this.storeComandos.getOrDefault(comandos[0], 
				this.storeComandos.get("CREATE"));

		String retorno = "";
		try {
			retorno = comando.executar(banco.getConnection().createStatement(), sql);
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
