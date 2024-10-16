package Dao;
import Conexao.Conexao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    Conexao conexao = new Conexao();
    PreparedStatement pstm;

    public boolean removerProduto(int sid){
        try{
            conexao.conectar();
            pstm = conexao.getConn().prepareStatement("DELETE FROM PRODUTO WHERE sID = ?");
            pstm.setInt(1, sid);
            return true;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
}
