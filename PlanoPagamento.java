import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanoPagamento {
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();


    public PlanoPagamento() {
    }

    //    Inserir
    public int inserirPlanoPagamento(int sid, String cFormaPagamento, String cTipoPlano, String cDescricao, double fValor) {
        this.conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("INSERT INTO PLANO_PAGAMENTO (sId, cFormaPagamento, cTipoplano, cDescricao, fValor) VALUES(?,?,?,?,?)");
            this.pstmt.setInt(1, sid);
            this.pstmt.setString(2, cFormaPagamento);
            this.pstmt.setString(3, cTipoPlano);
            this.pstmt.setString(4, cDescricao);
            this.pstmt.setDouble(5, fValor);
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    //      Alterar por id
    public int alterarFormaPagamento(String cFormaPagamento, int sid) {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE PLANO_PAGAMENTO SET CFORMA_PAGAMENTO = ?" +
                    "WHERE SID = ?");
//        Setando parametros
            pstmt.setString(1, cFormaPagamento);//Atualizando os dados
            pstmt.setInt(2, sid);
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    //      Alterar por Tipo plano
    public int TipoPlano(String cTipoPlano, int sid) {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE PLANO_PAGAMENTO SET CTIPOPLANO = ?" +
                    "WHERE SID = ?");
//        Setando parametros
            pstmt.setString(1, cTipoPlano);//Atualizando os dados
            pstmt.setInt(2, sid);
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    //      Alterar por Descricao
    public int Descricao(String cDescricao, int sid) {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE PLANO_PAGAMENTO SET CTIPOPLANO = ?" +
                    "WHERE SID = ?");
//        Setando parametros
            pstmt.setString(1, cDescricao);//Atualizando os dados
            pstmt.setInt(2, sid);
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    public int Valor(double fValor, int sid) {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE PLANO_PAGAMENTO SET CTIPOPLANO = ?" +
                    "WHERE SID = ?");
//        Setando parametros
            pstmt.setDouble(1, fValor);//Atualizando os dados
            pstmt.setInt(2, sid);
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

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


    public ResultSet buscar() {
        conexao.conectar();//Abrindo a conexão com o banco
        try {
            //Instanciando o objeto preparedStatemet(pstmt) = ps
            this.pstmt = this.conexao.getConn().prepareStatement("SELECT * FROM PLANO_PAGAMENTO");
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
            conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE SID = ?");
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

//    BUSCAR POR VALOR
    public ResultSet buscarPorValor(double valor) {
        conexao.conectar();
        try {
            conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE FVALOR = ?");
            pstmt.setDouble(1, valor);
            ResultSet rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

//    BUSCAR POR FORMA DE PAGAMENTO
    public ResultSet buscarPorFormaPagamento(String FormaPamento) {
        conexao.conectar();
        try {
            conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE CFORMAPAGAMENTO = ?");
            pstmt.setString(1, FormaPamento);
            ResultSet rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

//    BUSCAR POR TIPO DE PLANO
    public ResultSet buscarPorTipoPlano(String TipoPlano) {
        conexao.conectar();
        try {
            conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE CTIPOPLANO = ?");
            pstmt.setString(1, TipoPlano);
            ResultSet rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

//    BUSCAR POR DESCRICAO
    public ResultSet buscarPorDescricao(String Descricao) {
        conexao.conectar();
        try {
            conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE CDESCRICAO = ?");
            pstmt.setString(1, Descricao);
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