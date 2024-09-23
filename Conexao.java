
import java.sql.Connection; //Mantêm a conexão aberta e fecha
import java.sql.DriverManager; //Cria uma conexão
import java.sql.SQLException; //Exceções
public class Conexao {
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    //Metodo de conexão com bando de dados
    public boolean conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://dbbimo-dbbimo.b.aivencloud.com:27539/defaultdb", "avnadmin", "AVNS_D2wIoNxVHuwNinxXXOT");
            return true;
        }
        //Tratamento de excessão
        catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return false;
    }

    //Desconectar
    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                //Desconectando do BD
                conn.close();
            }
        }
        //Tratamento de excessão
        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}