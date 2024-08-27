import java.sql.PreparedStatement; //Gerencia e executa os comandos
import java.sql.ResultSet; // Guarda os resultados da consulta ao banco
import java.sql.SQLException; //Exceções
import java.sql.Date; // Classe de datas sql
public class Item {
    private PreparedStatement pstmt;
    //  Instanciando a classe conexao
    Conexao conexao = new Conexao();

    public boolean inserirItem(int quantidade, double valor, int idPedido, int idCurso, int idProduto) {
        try{
            conexao.conectar();
            pstmt = conexao.getConn().prepareStatement("INSERT INTO ITEM (iQuantidade, fValor, idPedido, idCurso, idProduto) VALUES(?, ?, ?, ?, ?)");
            pstmt.setInt(1, quantidade);
            pstmt.setDouble(2, valor);
            pstmt.setInt(3, idPedido);
            pstmt.setInt(4, idCurso);
            pstmt.setInt(5, idProduto);

            if (pstmt.executeUpdate() <= 0){
                return false;
            }
            else{
                return true;
            }
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar(); //fechando a conexão com o banco
        }
    }

    public int alterarQuantidade(int quantidade, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE ITEM SET iQuantidade = ? WHERE sId = ?");
//          Argumentos
            pstmt.setInt(1, quantidade);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }finally {
//          Desconectando do DB
            conexao.desconectar();
        }
    }

    public int alterarValor(double valor, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE ITEM SET fValor = ? WHERE sId = ?");
//          Argumentos
            pstmt.setDouble(1, valor);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }finally {
//          Desconectando do DB
            conexao.desconectar();
        }
    }

    public int remover(int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            String remover = "DELETE FROM ITEM WHERE sId = ?";
            pstmt = conexao.getConn().prepareStatement(remover);
//          Argumentos
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        }catch(java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }finally {
//          Desconectando do DB
            conexao.desconectar();
        }
    }
    // Metodo para mostrar informações da tabela curriculo
    public ResultSet buscar() {
        try{
            conexao.conectar(); //Abrindo a conexão com o banco
            // Instanciando o objeto preparedStatement (pstmt)
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM ITEM ORDER BY sId");
            // Executando o comando sql do objeto preparedStatement e armazenando no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset;
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
//          Desconectando do DB
            conexao.desconectar();
        }
    }
}