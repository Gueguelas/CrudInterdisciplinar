package Dao; // Pacote que contém a classe DAO

import Conexao.Conexao; // Importa a classe de conexão ao banco de dados
import Models.Usuario;

import java.sql.PreparedStatement; // Importa a classe para preparar instruções SQL
import java.sql.SQLException; // Importa a classe para tratar exceções relacionadas ao SQL

public class UsuarioDAO {
    // Método para remover um usuário pelo ID
    public int removerUsuario(Usuario user) {
        Conexao conexao = new Conexao(); // Cria uma nova instância da classe de conexão
        PreparedStatement pstm; // Declara um PreparedStatement para executar comandos SQL
        try {
            conexao.conectar(); // Estabelece a conexão com o banco de dados
            // Prepara a instrução SQL para deletar um usuário com base no seu ID
            pstm = conexao.getConn().prepareStatement("DELETE FROM usuario WHERE SID = ?");
            pstm.setString(1, user.getsId()); // Define o ID do usuário a ser removido
            return pstm.executeUpdate(); // Retorna true se a operação for bem-sucedida
        } catch (SQLException sqle) { // Trata exceções relacionadas ao SQL
            sqle.printStackTrace(); // Imprime a stack trace da exceção para depuração
            return -1; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Garante que a conexão seja fechada
        }
    }
}
