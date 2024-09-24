import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CategoriaCurso {
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();
    public CategoriaCurso(){}
    public int inserirCategoria(int sid, String cnome) {
        this.conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("INSERT INTO CATEGORIACURSO (SID, CNOME) VALUES(?,?)");
            this.pstmt.setInt(1, sid);
            this.pstmt.setString(2, cnome);
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    //    REMOVER
    public int remover(int sid){
        conexao.conectar();
        try {
            this.pstmt = conexao.getConn().prepareStatement("DELETE FROM CATEGORIACURSO WHERE SID = ?");
            //          Instanciando o objeto preparedStatement
            //            Setando o valor do parametro
            pstmt.setInt(1,sid);
            return pstmt.executeUpdate();
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }
    //    ALTERAR NOME
    public int alterarNome(String cnome, int sid) {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE CATEGORIACURSO SET CNOME = ?" +
                    "WHERE SID = ?");
            // Setando parametros
            pstmt.setString(1, cnome);// Atualizando os dados
            pstmt.setInt(2, sid);
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }


    //    BUSCAR CATEGORIA DE SERVIÇO
    public ResultSet buscar() {
        conexao.conectar();//Abrindo a conexão com o banco
        try {
            //Instanciando o objeto preparedStatemet(pstmt)
            this.pstmt = this.conexao.getConn().prepareStatement("SELECT * FROM CATEGORIACURSO");
            //        Executando o comando sql do objeto preparedStatement e Armazenando no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
    //    BUSCAR POR ID
    public ResultSet buscarPorId(int sid) {
        conexao.conectar();
        try {
            conexao.getConn().prepareStatement("SELECT * from CATEGORIACURSO WHERE SID = ?");
            pstmt.setInt(1, sid);
            ResultSet rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
    //    BUSCAR POR NOME
    public ResultSet buscarPorNome(String cnome) {
        conexao.conectar();
        try {
            conexao.getConn().prepareStatement("SELECT * from CATEGORIACURSO WHERE CNOME = ?");
            pstmt.setString(1, cnome);
            ResultSet rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
}