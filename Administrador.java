import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrador {
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

    public Administrador(){}

    public int inserirAdministrador(int sid, String cnome, String cemail, String csenha) {
        this.conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("INSERT INTO ADMINISTRADOR (SID, CNOME, CEMAIl, CSENHA) VALUES(?,?,?,?)");
            this.pstmt.setInt(1, sid);
            this.pstmt.setString(2, cnome);
            this.pstmt.setString(3, cemail);
            this.pstmt.setString(4, csenha);
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
            this.pstmt = conexao.getConn().prepareStatement("DELETE FROM PLANO_PAGAMENTO WHERE SID = ?");
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
                this.pstmt = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CNOME = ?" +
                        "WHERE SID = ?");
//        Setando parametros
                pstmt.setString(1, cnome);//Atualizando os dados
                pstmt.setInt(2, sid);
                return pstmt.executeUpdate();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                return -1;
            } finally {
                conexao.desconectar();
            }
        }

//        ALTERAR EMAIL
    public int alterarEmail(String cemail, int sid) {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CEMAIL = ?" +
                    "WHERE SID = ?");
//        Setando parametros
            pstmt.setString(1, cemail);//Atualizando os dados
            pstmt.setInt(2, sid);
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

//          ALTERAR SENHA
    public int alterarSenha(String csenha, int sid) {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CSENHA = ?" +
                    "WHERE SID = ?");
    //        Setando parametros
            pstmt.setString(1, csenha);//Atualizando os dados
            pstmt.setInt(2, sid);
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }


//    BUSCAR ADMINISTRADOR
    public ResultSet buscar() {
        conexao.conectar();//Abrindo a conexão com o banco
        try {
            //Instanciando o objeto preparedStatemet(pstmt)
            this.pstmt = this.conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR");
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
            conexao.getConn().prepareStatement("SELECT * from ADMINISTRADOR WHERE SID = ?");
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
            conexao.getConn().prepareStatement("SELECT * from ADMINISTRADOR WHERE CNOME = ?");
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

//    BUSCAR POR EMAIL
    public ResultSet buscarPorEmail(String cemail) {
        conexao.conectar();
        try {
            conexao.getConn().prepareStatement("SELECT * from ADMINISTRADOR WHERE CEMAIL = ?");
            pstmt.setString(1, cemail);
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
