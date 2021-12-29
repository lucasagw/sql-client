package br.ucsal.pooa.client.test;

import br.ucsal.pooa.client.backend.Configuracao;
import br.ucsal.pooa.client.view.ConfiguracaoPanel;
import br.ucsal.pooa.client.view.TelaConsulta;

public class SQLClient {

	/**
	 * Utilizei os padrões tal e xpto / pag 241 do livro
	 * 
	 * O padrão Command serviu para Desacoplar/separar os comandos sql do cliente assim a
	 * view não tem mais dependencias das classes de javax.sql.
	 * 
	 * As classes usadas foram Command <Command>, Consulta<CommandConcreto>
	 */
	
	static ConfiguracaoPanel configuracao; 
	
	public static void main(String[] args) {
		configuracao = new ConfiguracaoPanel();
		configuracao.setVisible(true);

	}

	public static void client() {
		Configuracao bd = configuracao.getConfiguracao();
		TelaConsulta janela = new TelaConsulta(bd);
		janela.setVisible(true);
	}
}
