import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Curso {

    Conexao conn = new Conexao();
    private PreparedStatement pstm;

    public boolean inserirCurso(String cCategoria, String cDescricao, String cNome, int iNumeroInscricao,double fValor, boolean bStatus, String cDuracao, int iIdCategoriaCurso){
        conn.conectar( );
        try{
            pstm = conn.getConn().prepareStatement("INSERT INTO Curso(cCategoria, cDescricao, cNome, iNumeroInscricao, fValor, bStatus,  cDuracao, idCategoria, iIdCategoriaCurso) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            pstm.setString(1, cCategoria);
            pstm.setString(2, cDescricao);
            pstm.setString(3, cNome);
            pstm.setInt(4, iNumeroInscricao);
            pstm.setDouble(5, fValor);
            pstm.setBoolean(6, bStatus);
            pstm.setString(7, cDuracao);
            pstm.setInt(8, iIdCategoriaCurso);
            if (pstm.executeUpdate() <= 0){
                return false;
            }
            else{
                return true;
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conn.desconectar();
        }
    }

    public boolean alterarStatusCurso(boolean bstatus, int sId){
        conn.conectar();
        try{
            pstm = conn.getConn().prepareStatement("UPDATE Curso SET bsatus = ? WHERE sID = ?");
            pstm.setBoolean(1, bstatus);
            pstm.setInt(2, sId);
            if (pstm.executeUpdate() <= 0){
                return false;
            }
            else{
                return true;
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conn.desconectar();
        }
    }

    public boolean alterarNomeCurso(String cNome_curso, int sId){
        conn.conectar();
        try{
            pstm = conn.getConn().prepareStatement("UPDATE Curso SET cNome_curso = ? WHERE sID = ?");
            pstm.setString(1, cNome_curso);
            pstm.setInt(2, sId);
            if (pstm.executeUpdate() <= 0){
                return false;
            }
            else{
                return true;
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conn.desconectar();
        }
    }

    public boolean alterarValorCurso(double fValor, int sId){
        conn.conectar();
        try{
            pstm = conn.getConn().prepareStatement("UPDATE Curso SET fValor = ? WHERE sID = ?");
            pstm.setDouble(1, fValor);
            pstm.setInt(2, sId);
            if (pstm.executeUpdate() <= 0){
                return false;
            }
            else{
                return true;
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conn.desconectar();
        }
    }

    public boolean alterarDescricao(String cDescricao, int sId){
        conn.conectar();
        try{
            pstm = conn.getConn().prepareStatement("UPDATE Curso SET cDescricao = ? WHERE sID = ?");
            pstm.setString(1, cDescricao);
            pstm.setInt(2, sId);
            if (pstm.executeUpdate() <= 0){
                return false;
            }
            else{
                return true;
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conn.desconectar();
        }
    }
}
