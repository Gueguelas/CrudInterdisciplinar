package Dao; // Pacote que contém a classe DAO

import Conexao.Conexao; // Importa a classe de conexão ao banco de dados
import Modelos.Produto;

import java.sql.PreparedStatement; // Importa a classe para preparar instruções SQL
import java.sql.SQLException; // Importa a classe para tratar exceções relacionadas ao SQL

public class ProdutoDAO {
    Conexao conexao = new Conexao(); // Cria uma instância da classe de conexão
    PreparedStatement pstm; // Declara um PreparedStatement para executar comandos SQL

    // Método para remover um produto pelo ID
    public int removerProduto(Produto produto) {
        try {
            conexao.conectar(); // Estabelece a conexão com o banco de dados
            // Prepara a instrução SQL para deletar um produto com base no seu ID
            pstm = conexao.getConn().prepareStatement("DELETE FROM produto WHERE sId = ?");
            pstm.setInt(1, produto.getsId()); // Define o ID do produto a ser removido
            return pstm.executeUpdate();
        } catch (SQLException sqle) { // Trata exceções relacionadas ao SQL
            sqle.printStackTrace(); // Imprime a stack trace da exceção
            return -1; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Garante que a conexão seja fechada
        }
    }
}
