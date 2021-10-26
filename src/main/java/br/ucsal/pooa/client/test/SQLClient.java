package br.ucsal.pooa.client.test;

import br.ucsal.pooa.client.backend.Configuracao;
import br.ucsal.pooa.client.view.ConfiguracaoPanel;
import br.ucsal.pooa.client.view.TelaConsulta;

public class SQLClient {

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
