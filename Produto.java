import java.sql.PreparedStatement; //Gerencia e executa os comandos
import java.sql.ResultSet; // Guarda os resultados da consulta ao banco
import java.sql.SQLException; //Exceções
import java.sql.Date; // Classe de datas sql
public class Produto {
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

    public boolean inserirProduto(String cNome, double fPreco, String cCategoria, String cEstado, String cDescricao, int idUsuario){
        conexao.conectar();
        try {
            pstmt= conexao.conn.prepareStatement("INSERT INTO PRODUTO (CNOME, FPRECO, CCATEGORIA, CESTADO, CDESCRICAO, IDUSUARIO) VALUES (?,?,?,?,?,?)");
            pstmt.setString(1,cNome);
            pstmt.setDouble(2,fPreco);
            pstmt.setString(3,cCategoria);
            pstmt.setString(4,cEstado);
            pstmt.setString(5,cDescricao);
            pstmt.setInt(6,idUsuario);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    REMOVER POR ?
//    Remover por nome
    public boolean removerPorNome(String cNome){
        conexao.conectar();
        try {
            pstmt = conexao.conn.prepareStatement("DELETE FROM PRODUTO WHERE CNOME = ?");
            pstmt.setString(1, cNome);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    Remover por Preco
    public boolean removerPorPreco(double fPreco){
        conexao.conectar();
        try {
            pstmt = conexao.conn.prepareStatement("DELETE FROM PRODUTO WHERE FPRECO = ?");
            pstmt.setDouble(1, fPreco);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
//     Remover por Categoria
    public boolean removerPorCategoria(String cCategoria){
        conexao.conectar();
        try {
            pstmt = conexao.conn.prepareStatement("DELETE FROM PRODUTO WHERE CCATEGORIA = ?");
            pstmt.setString(1, cCategoria);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    Remover por Estado
    public boolean removerPorEstado(String cEstado){
        conexao.conectar();
        try {
            pstmt = conexao.conn.prepareStatement("DELETE FROM PRODUTO WHERE CESTADO = ?");
            pstmt.setString(1, cEstado);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    Remover por Descrição
    public boolean removerPorDescricao(String cDescricao){
        conexao.conectar();
        try {
            pstmt = conexao.conn.prepareStatement("DELETE FROM PRODUTO WHERE CDESCRICAO = ?");
            pstmt.setString(1, cDescricao);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    Remover por idUsuario
    public boolean removerPorIdUsuario(int idUsuario){
        conexao.conectar();
        try {
            pstmt = conexao.conn.prepareStatement("DELETE FROM PRODUTO WHERE IDUSUARIO = ?");
            pstmt.setInt(1, idUsuario);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    ALTERAR POR ?
//    Alterar Nome
    public boolean alterarNome(String cNome, int sId){
        conexao.conectar();
        try {
            pstmt = conexao.conn.prepareStatement("UPDATE PRODUTO SET CNOME = ? WHERE SID = ?");
            pstmt.setString(1, cNome);
            pstmt.setInt(2, sId);
            return pstmt.executeUpdate()>0;

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    Alterar Preco
    public boolean alterarPreco(double fPreco, int sId){
        conexao.conectar();
        try {
            pstmt = conexao.conn.prepareStatement("UPDATE PRODUTO SET FPRECO = ? WHERE SID = ?");
            pstmt.setDouble(1, fPreco);
            pstmt.setInt(2, sId);
            return pstmt.executeUpdate()>0;

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    Alterar Categoria
    public boolean alterarCategoria(String cCategoria, int sId){
        conexao.conectar();
        try {
            pstmt = conexao.conn.prepareStatement("UPDATE PRODUTO SET CCATEGORIA = ? WHERE SID = ?");
            pstmt.setString(1, cCategoria);
            pstmt.setInt(2, sId);
            return pstmt.executeUpdate()>0;

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    Alterar Estado
    public boolean alterarEstado(String cEstado, int sId){
        conexao.conectar();
        try {
            pstmt = conexao.conn.prepareStatement("UPDATE PRODUTO SET CESTADO = ? WHERE SID = ?");
            pstmt.setString(1, cEstado);
            pstmt.setInt(2, sId);
            return pstmt.executeUpdate()>0;

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    Alterar Descrição
    public boolean alterarDescricao(String cDescricao, int sId){
        conexao.conectar();
        try {
            pstmt = conexao.conn.prepareStatement("UPDATE PRODUTO SET CDESCRICAO = ? WHERE SID = ?");
            pstmt.setString(1, cDescricao);
            pstmt.setInt(2, sId);
                return pstmt.executeUpdate()>0;

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

}
