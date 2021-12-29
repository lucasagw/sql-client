package br.ucsal.pooa.client.backend;

import java.sql.SQLException;
import java.sql.Statement;

public class Update extends Command {

	@Override
	public String executar(Statement stmt, String sql) throws SQLException {
		int up = stmt.executeUpdate(sql);
		stmt.closeOnCompletion();
		return up + "";
	}
}
