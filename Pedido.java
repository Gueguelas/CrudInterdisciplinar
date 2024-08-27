import java.sql.Connection; //Mantêm a conexão aberta e fecha
import java.sql.DriverManager; //Cria uma conexão
import java.sql.PreparedStatement; //Gerencia e executa os comandos
import java.sql.ResultSet; // Guarda os resultados da consulta ao banco
import java.sql.SQLException; //Exceções
import java.sql.Date; // Classe de datas sql
public class Pedido {
    private PreparedStatement pstmt;

    //Instanciando a classe conexão
    Conexao conexao = new Conexao();


    //Método para instanciar um produto no banco
    public boolean inserirProduto(Date dData, int iQuantidade, double fValorTotal, String cStatus, int idUsuario){
        try {
            conexao.conectar(); //conectando o bd
            //Comando SQL
            pstmt = conexao.getConn().prepareStatement("INSERT INTO PRODUTO (dData, iQuantidade, fValorTotal, cStatus, idUsuario) VALUES(?, ?, ?, ?, ?)");
            //Argumentos
            pstmt.setDate(1, dData);
            pstmt.setInt(2, iQuantidade);
            pstmt.setDouble(3, fValorTotal);
            pstmt.setString(4, cStatus);
            pstmt.setInt(5, idUsuario);
            if (pstmt.executeUpdate() <= 0){
                return false;
            }
            else{
                return true;
            }
        } catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(); //desconectando o nd
        }
    }


    //Métodos para modificar uma coluna da tabela Produto
    public int alterarQuantidade(int iQuantidade, int id){
        try {
            conexao.conectar(); //conectando o bd

            //Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE tabela SET iQuantidade = ? WHERE sId = ?");
            //Argumentos
            pstmt.setInt(1, iQuantidade);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        } catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar(); //desconectando o bd
        }
    }

    public int alterarStatus(String cStatus, int id){
        try {
            conexao.conectar(); //conectando o bd

            //Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE tabela SET cStatus = ? WHERE sId = ?");
            //Argumentos
            pstmt.setString(1, cStatus);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        } catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar(); //desconectando o bd
        }
    }

    public int alterarValorTotal(double fValorTotal, int id){
        try {
            conexao.conectar(); //conectando o bd

            //Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE tabela SET fValorTotal = ? WHERE sId = ?");
            //Argumentos
            pstmt.setDouble(1, fValorTotal);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        } catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar(); //desconectando o bd
        }
    }

    //Método para remover uma linha no bd
    public int remover(int id) {
        try{
            conexao.conectar(); //Conectando o bd
            //Comando SQL
            String remover = "DELETE FROM PEDIDO WHERE sId = ?";
            pstmt = conexao.getConn().prepareStatement(remover);
            //Argumento
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
            conexao.desconectar(); //desconectando o bd
        }
    }

    // Metodo para mostrar informações da tabela curriculo
    public ResultSet buscar() {
        try{
            conexao.conectar(); //Conectando o bd
            //Comando SQL
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM PEDIDO ORDER BY sId");
            ResultSet rset = pstmt.executeQuery();return rset;
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //desconectando o bd
        }
    }
}

