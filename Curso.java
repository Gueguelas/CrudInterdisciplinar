import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Curso {
    private boolean bstatus;
    private String nome_curso;
    private String categoria;

    Conexao conn = new Conexao();
    private PreparedStatement pstm;

    public boolean inserir_Curso(int iNumeroInscricao, boolean bStatus, String cNome_curso, double fDuracao, double fValor, String cDescricao){
        conn.conectar();
        try{
            pstm = conn.getConn().prepareStatement("INSERT INTO Curso(iNumeroInscricao, bStatus, cNome_curso, fDuracao, fValor, cDescricao) VALUES(?, ?, ?, ?, ?, ?)");
            pstm.setInt(1, iNumeroInscricao);
            pstm.setBoolean(2, bStatus);
            pstm.setString(3, cNome_curso);
            pstm.setDouble(4, fDuracao);
            pstm.setDouble(5, fValor);
            pstm.setString(6, cDescricao);
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
