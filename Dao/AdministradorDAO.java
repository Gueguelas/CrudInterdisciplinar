package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.Conexao;
import Modelos.Administrador;


// Classe responsável pela manipulação de administradores
public class AdministradorDAO {
    private PreparedStatement pstm; // Objeto para executar comandos SQL
    private Conexao conexao = new Conexao(); // Instância da classe de conexão ao banco de dados

    // Construtor da classe
    public AdministradorDAO() {}

    // Método para inserir um novo administrador
    public boolean inserirAdministrador(Administrador adm) {

        this.conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para inserção
            this.pstm = this.conexao.getConn().prepareStatement("INSERT INTO ADMINISTRADOR (CNOME, CEMAIL, CSENHA) VALUES(?,?,?)");
            this.pstm.setString(1, adm.getcNome()); // Define o valor do parâmetro CNOME
            this.pstm.setString(2, adm.getcEmail()); // Define o valor do parâmetro CEMAIL
            this.pstm.setString(3, adm.getcSenha()); // Define o valor do parâmetro CSENHA
            return pstm.executeUpdate() > 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para remover um administrador pelo SID
    public int removerAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {

            // Prepara a instrução SQL para remoção
            this.pstm = conexao.getConn().prepareStatement("DELETE FROM ADMINISTRADOR WHERE SID = ?");
            pstm.setInt(1, adm.getsId()); // Define o valor do parâmetro SID
            return pstm.executeUpdate(); // Executa a remoção e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar o nome de um administrador
    public int alterarNomeAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            this.pstm = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CNOME = ? WHERE SID = ?");
            pstm.setString(1, adm.getcNome()); // Define o novo nome
            pstm.setInt(2, adm.getsId()); // Define o valor do parâmetro SID
            return pstm.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar o email de um administrador
    public int alterarEmailAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            this.pstm = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CEMAIL = ? WHERE SID = ?");
            pstm.setString(1, adm.getcEmail()); // Define o novo email
            pstm.setInt(2, adm.getsId()); // Define o valor do parâmetro SID
            return pstm.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar a senha de um administrador
    public int alterarSenhaAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            this.pstm = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CSENHA = ? WHERE SID = ?");
            pstm.setString(1, adm.getcSenha()); // Define a nova senha
            pstm.setInt(2, adm.getsId()); // Define o valor do parâmetro SID
            return pstm.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar todos os administradores
    public ResultSet buscarTodosAdministradores() {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca
            this.pstm = this.conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR");
            // Executa a busca e retorna o ResultSet com os resultados
            return pstm.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar um administrador pelo SID
    public ResultSet buscarAdministradorPorId(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por ID
            this.pstm = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE SID = ?");
            pstm.setInt(1, adm.getsId()); // Define o valor do parâmetro SID
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar um administrador pelo nome
    public ResultSet buscarAdministradorPorNome(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por nome
            this.pstm = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE CNOME = ?");
            pstm.setString(1, adm.getcNome()); // Define o valor do parâmetro CNOME
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar um administrador pelo email
    public ResultSet buscarAdministradorPorEmail(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por email
            this.pstm = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE CEMAIL = ?");
            pstm.setString(1, adm.getcEmail()); // Define o valor do parâmetro CEMAIL
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }
}
