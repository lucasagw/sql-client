package br.ucsal.pooa.client.backend;

import java.sql.SQLException;
import java.sql.Statement;

public abstract class Command {

    //pode usar Object no return
	abstract String executar(Statement stmt, String sql) throws SQLException;

}
