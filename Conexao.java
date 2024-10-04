import java.sql.Connection; // Mantém a conexão aberta e fecha
import java.sql.DriverManager; // Cria uma conexão
import java.sql.SQLException; // Exceções

public class Conexao {
    private Connection conn;
    String nomeUsusario = System.getenv("NOME_USUARIO_DO_BANCO_DE_DADOS");
    String senhaBanco = System.getenv("SENHA_DO_BANCO_DE_DADOS");
    String maintanceBanco = System.getenv("MAINTANCE_DATABASE_BANCO_DE_DADOS");
    String portaBanco = System.getenv("PORTA_DO_BANCO_DE_DADOS");
    String hostBanco = System.getenv("HOST_BANCO_DE_DADOS");

    public Connection getConn() {
        return conn;
    }
//Oi
    // Método de conexão com banco de dados
    public boolean conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://" + hostBanco + ":" + portaBanco + "/" + maintanceBanco, nomeUsusario, senhaBanco);
            return true;
        }
        // Tratamento de exceção
        catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return false;
    }

    // Desconectar
    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                // Desconectando do BD
                conn.close();
            }
        }
        // Tratamento de exceção
        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
