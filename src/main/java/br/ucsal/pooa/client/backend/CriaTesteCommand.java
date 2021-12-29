package br.ucsal.pooa.client.backend;

import java.sql.SQLException;
import java.sql.Statement;
/**
 * Command Concreto
 * @author lucas
 *
 */
public class CriaTesteCommand extends Command {

	@Override
	String executar(Statement stmt, String sql) throws SQLException {
		CriarTabela cria = new CriarTabela();
		return cria.executar(stmt, "CREATE TABLE TESTE (ID INT PRIMARY KEY, NAME VARCHAR(50))");
	}
}
