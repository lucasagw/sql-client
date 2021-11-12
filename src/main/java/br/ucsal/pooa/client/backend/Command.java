package br.ucsal.pooa.client.backend;

import java.sql.SQLException;
import java.sql.Statement;

public interface Command {

    public String executar(Statement stmt, String sql) throws SQLException;

}
