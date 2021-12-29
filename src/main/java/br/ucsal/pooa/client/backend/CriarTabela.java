package br.ucsal.pooa.client.backend;

import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela extends Command {

	@Override
	public String executar(Statement stmt, String sql) throws SQLException {
		Boolean b = stmt.execute(sql);
		stmt.closeOnCompletion();
		return !b + "";
	}
}
