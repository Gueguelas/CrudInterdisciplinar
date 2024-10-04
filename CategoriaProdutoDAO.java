import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Classe responsável pela manipulação de categorias de produtos
public class CategoriaProdutoDAO {
    private PreparedStatement pstmt; // Objeto para executar comandos SQL
    private ResultSet rs; // Objeto para armazenar resultados de consultas
    private Conexao conexao = new Conexao(); // Instância da classe de conexão ao banco de dados

    // Construtor da classe
    public CategoriaProdutoDAO() {}

    // Método para inserir uma nova categoria de produto
    public int inserirCategoriaProduto(int sid, String cnome) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para inserção
            pstmt = conexao.getConn().prepareStatement("INSERT INTO CATEGORIAPRODUTO (SID, CNOME) VALUES(?, ?)");
            pstmt.setInt(1, sid); // Define o valor do parâmetro SID
            pstmt.setString(2, cnome); // Define o valor do parâmetro CNOME
            return pstmt.executeUpdate(); // Executa a inserção e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para remover uma categoria pelo SID
    public int remover(int sid) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para remoção
            pstmt = conexao.getConn().prepareStatement("DELETE FROM CATEGORIAPRODUTO WHERE SID = ?");
            pstmt.setInt(1, sid); // Define o valor do parâmetro SID
            return pstmt.executeUpdate(); // Executa a remoção e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar o nome de uma categoria
    public int alterarNome(String cnome, int sid) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            pstmt = conexao.getConn().prepareStatement("UPDATE CATEGORIAPRODUTO SET CNOME = ? WHERE SID = ?");
            pstmt.setString(1, cnome); // Define o valor do novo nome
            pstmt.setInt(2, sid); // Define o valor do parâmetro SID
            return pstmt.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar todas as categorias
    public ResultSet buscar() {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIAPRODUTO");
            return pstmt.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            // Não fecha a conexão aqui, pois o ResultSet ainda pode ser utilizado
        }
    }

    // Método para buscar uma categoria pelo SID
    public ResultSet buscarPorId(int sid) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por ID
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIAPRODUTO WHERE SID = ?");
            pstmt.setInt(1, sid); // Define o valor do parâmetro SID
            return pstmt.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            // Não fecha a conexão aqui, pois o ResultSet ainda pode ser utilizado
        }
    }

    // Método para buscar uma categoria pelo nome
    public ResultSet buscarPorNome(String cnome) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por nome
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIAPRODUTO WHERE CNOME = ?");
            pstmt.setString(1, cnome); // Define o valor do parâmetro CNOME
            return pstmt.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            // Não fecha a conexão aqui, pois o ResultSet ainda pode ser utilizado
        }
    }
}
