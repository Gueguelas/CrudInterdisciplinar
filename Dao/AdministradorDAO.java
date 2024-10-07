package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.Conexao;


// Classe responsável pela manipulação de administradores
public class AdministradorDAO {
    private PreparedStatement pstmt; // Objeto para executar comandos SQL
    private ResultSet rs; // Objeto para armazenar resultados de consultas
    private Conexao conexao = new Conexao(); // Instância da classe de conexão ao banco de dados

    // Construtor da classe
    public AdministradorDAO() {}

    // Método para inserir um novo administrador
    public int inserirAdministrador(int sid, String cnome, String cemail, String csenha) {

        this.conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para inserção
            this.pstmt = this.conexao.getConn().prepareStatement("INSERT INTO ADMINISTRADOR (SID, CNOME, CEMAIL, CSENHA) VALUES(?,?,?,?)");
            this.pstmt.setInt(1, sid); // Define o valor do parâmetro SID
            this.pstmt.setString(2, cnome); // Define o valor do parâmetro CNOME
            this.pstmt.setString(3, cemail); // Define o valor do parâmetro CEMAIL
            this.pstmt.setString(4, csenha); // Define o valor do parâmetro CSENHA
            return pstmt.executeUpdate(); // Executa a inserção e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para remover um administrador pelo SID
    public int remover(int sid) {
        conexao.conectar(); // Abre a conexão com o banco
        try {

            // Prepara a instrução SQL para remoção
            this.pstmt = conexao.getConn().prepareStatement("DELETE FROM ADMINISTRADOR WHERE SID = ?");
            pstmt.setInt(1, sid); // Define o valor do parâmetro SID
            return pstmt.executeUpdate(); // Executa a remoção e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar o nome de um administrador
    public int alterarNome(String cnome, int sid) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CNOME = ? WHERE SID = ?");
            pstmt.setString(1, cnome); // Define o novo nome
            pstmt.setInt(2, sid); // Define o valor do parâmetro SID
            return pstmt.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar o email de um administrador
    public int alterarEmail(String cemail, int sid) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CEMAIL = ? WHERE SID = ?");
            pstmt.setString(1, cemail); // Define o novo email
            pstmt.setInt(2, sid); // Define o valor do parâmetro SID
            return pstmt.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar a senha de um administrador
    public int alterarSenha(String csenha, int sid) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CSENHA = ? WHERE SID = ?");
            pstmt.setString(1, csenha); // Define a nova senha
            pstmt.setInt(2, sid); // Define o valor do parâmetro SID
            return pstmt.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar todos os administradores
    public ResultSet buscar() {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca
            this.pstmt = this.conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR");
            // Executa a busca e retorna o ResultSet com os resultados
            return pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar um administrador pelo SID
    public ResultSet buscarPorId(int sid) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por ID
            this.pstmt = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE SID = ?");
            pstmt.setInt(1, sid); // Define o valor do parâmetro SID
            return pstmt.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar um administrador pelo nome
    public ResultSet buscarPorNome(String cnome) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por nome
            this.pstmt = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE CNOME = ?");
            pstmt.setString(1, cnome); // Define o valor do parâmetro CNOME
            return pstmt.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar um administrador pelo email
    public ResultSet buscarPorEmail(String cemail) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por email
            this.pstmt = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE CEMAIL = ?");
            pstmt.setString(1, cemail); // Define o valor do parâmetro CEMAIL
            return pstmt.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }
}
