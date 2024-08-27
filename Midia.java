import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; //Exceções
import java.sql.Date; // Classe de datas sql
public class Midia {
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

//    INSERIR
    public boolean inserirMidia(int idProduto, String cUrlVideo, String cUrlFoto){
        conexao.conectar();
        try{
            pstmt = conexao.getConn().prepareStatement("INSERT INTO MIDIA (idProduto, cUrlVideo, cUrlFoto) VALUES (?,?,?)");
            pstmt.setInt(1,idProduto);
            pstmt.setString(2, cUrlVideo);
            pstmt.setString(3, cUrlFoto);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    REMOVER POR ?

//    Remover por Id
    public boolean removerPorId(int id){
        conexao.conectar();
        try {
            pstmt = conexao.getConn().prepareStatement("DELETE FROM MIDIA WHERE SID = ?");
            pstmt.setInt(1,id);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    Remover por Nome
    public boolean removerPorIdProduto(int idProduto){
        conexao.conectar();
        try {
            pstmt = conexao.getConn().prepareStatement("DELETE FROM MIDIA WHERE IDPRODUTO = ?");
            pstmt.setInt(1, idProduto);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    Remover por Video
    public boolean removerPorVideo(String cUrlVideo){
        conexao.conectar();
        try {
            pstmt = conexao.getConn().prepareStatement("DELETE FROM MIDIA WHERE CURLVIDEO = ?");
            pstmt.setString(1, cUrlVideo);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    Remover por Foto
    public boolean removerPorFoto(String cUrlFoto){
        conexao.conectar();
        try {
            pstmt = conexao.getConn().prepareStatement("DELETE FROM MIDIA WHERE CURLFOTO = ?");
            pstmt.setString(1, cUrlFoto);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    ALTERAR POR ?
    public boolean alterarUrlVideo(String cUrlVideo, int id){
        conexao.conectar();
        try {
            pstmt = conexao.getConn().prepareStatement("UPDATE MIDIA SET CURLVIDEO = ? WHERE SID = ?");
            pstmt.setString(1,cUrlVideo);
            pstmt.setInt(2,id);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

//    Alterar Url Foto
public boolean alterarUrlFoto(String cUrlFoto, int id){
    conexao.conectar();
    try {
        pstmt = conexao.getConn().prepareStatement("UPDATE MIDIA SET CURLFOTO = ? WHERE SID = ?");
        pstmt.setString(1,cUrlFoto);
        pstmt.setInt(2,id);
        return pstmt.executeUpdate()>0;
    }catch (SQLException sqle){
        sqle.printStackTrace();
        return false;
    }finally {
        conexao.desconectar();
    }
}

//      BUSCAR POR ?

    public ResultSet buscar(){
        conexao.conectar();
        try {
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM MIDIA");
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }

//    Buscar por idProduto
    public ResultSet buscarPorIdProduto(int idProduto){
        conexao.conectar();
        try {
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM MIDIA WHERE IDPRODUTO = ?");
            pstmt.setInt(1, idProduto);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }

//    Buscar por UrlVideo
    public ResultSet buscarPorUrlVideo(String cUrlVideo){
        conexao.conectar();
        try {
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM MIDIA WHERE CURLVIDEO = ?");
            pstmt.setString(1, cUrlVideo);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }

//    Buscar por UrlFoto
    public ResultSet buscarPorUrlFoto(String cUrlFoto){
        conexao.conectar();
        try {
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM MIDIA WHERE CURLFOTO = ?");
            pstmt.setString(1, cUrlFoto);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }
}
