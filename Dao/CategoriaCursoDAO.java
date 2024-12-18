package Dao;

import java.sql.PreparedStatement; // Importa a classe para preparar instruções SQL
import java.sql.ResultSet; // Importa a classe para trabalhar com resultados de consultas SQL
import java.sql.SQLException; // Importa a classe para tratar exceções relacionadas ao SQL
import Conexao.Conexao; // Importa a classe de conexão ao banco de dados
import Models.CategoriaCurso;

public class CategoriaCursoDAO {
    private Conexao conexao; // Instância da classe de conexão

    // Construtor da classe
    public CategoriaCursoDAO() {
        conexao = new Conexao(); // Inicializa a conexão ao banco de dados
    }

    // Método para inserir uma nova categoria
    public boolean inserirCategoriaCurso(CategoriaCurso categoriaCurso) {
        try (PreparedStatement pstm = conexao.getConn().prepareStatement("INSERT INTO CATEGORIACURSO(cNome) VALUES (?)")) { // Prepara a instrução SQL
            pstm.setString(1, categoriaCurso.getcNome()); // Define o parâmetro CNOME na instrução SQL
            return pstm.executeUpdate() > 0;// Executa a inserção e retorna true
        } catch (SQLException sqle) { // Trata exceções SQL
            sqle.printStackTrace(); // Exibe a stack trace da exceção
            return false; // Retorna false em caso de erro
        }
    }

    // Método para remover uma categoria pelo ID
    public int removerCategoriaCurso(CategoriaCurso categoriaCurso) {
        try (PreparedStatement pstm = conexao.getConn().prepareStatement("UPDATE CATEGORIACURSO SET bIsInactive = true")) { // Prepara a instrução SQL
            pstm.setInt(1, categoriaCurso.getsId()); // Define o parâmetro sId na instrução SQL
            return pstm.executeUpdate(); // Executa a deleção e retorna true
        }catch (SQLException sqle) { // Trata exceções SQL
            sqle.printStackTrace(); // Exibe a stack trace da exceção
            return -1; // Retorna false em caso de erro
        }
    }

    // Método para alterar o nome de uma categoria pelo ID
    public int alterarNome(CategoriaCurso categoriaCurso) {
        String sql = "UPDATE CATEGORIACURSO SET CNOME = ? WHERE sId = ?"; // SQL para atualizar
        try (PreparedStatement pstm = conexao.getConn().prepareStatement(sql)) { // Prepara a instrução SQL
            pstm.setString(1, categoriaCurso.getcNome()); // Define o novo nome da categoria
            pstm.setInt(2, categoriaCurso.getsId()); // Define o ID da categoria a ser atualizada
            return pstm.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) { // Trata exceções SQL
            sqle.printStackTrace(); // Exibe a stack trace da exceção
            return -1; // Retorna -1 em caso de erro
        }
    }

    // Método para buscar todas as categorias
    public ResultSet buscarTodasCategorias() {
        try {
            PreparedStatement pstm = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIACURSO"); // Prepara a instrução SQL
            return pstm.executeQuery(); // Executa a consulta e retorna o ResultSet
        } catch (SQLException sqle) { // Trata exceções SQL
            sqle.printStackTrace(); // Exibe a stack trace da exceção
            return null; // Retorna null em caso de erro
        }
        // Nota: A conexão não é fechada aqui, pois o ResultSet está sendo retornado.
    }

    // Método para buscar uma categoria pelo ID
    public ResultSet buscarPorId(CategoriaCurso categoriaCurso) {
        try {
            PreparedStatement pstm = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIACURSO WHERE sId = ?"); // Prepara a instrução SQL
            pstm.setInt(1, categoriaCurso.getsId()); // Define o ID da categoria a ser buscada
            return pstm.executeQuery(); // Executa a consulta e retorna o ResultSet
        } catch (SQLException sqle) { // Trata exceções SQL
            sqle.printStackTrace(); // Exibe a stack trace da exceção
            return null; // Retorna null em caso de erro
        }
        // Nota: A conexão não é fechada aqui, pois o ResultSet está sendo retornado.
    }

    // Método para buscar uma categoria pelo nome
    public ResultSet buscarPorNome(CategoriaCurso categoriaCurso) {
        try {
            PreparedStatement pstm = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIACURSO WHERE CNOME = ?"); // Prepara a instrução SQL
            pstm.setString(1, categoriaCurso.getcNome()); // Define o nome da categoria a ser buscada
            return pstm.executeQuery(); // Executa a consulta e retorna o ResultSet
        } catch (SQLException sqle) { // Trata exceções SQL
            sqle.printStackTrace(); // Exibe a stack trace da exceção
            return null; // Retorna null em caso de erro
        }
        // Nota: A conexão não é fechada aqui, pois o ResultSet está sendo retornado.
    }
}
