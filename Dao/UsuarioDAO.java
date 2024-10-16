package Dao;

import Conexao.Conexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    public boolean removerUsuario(int sid){
        Conexao conexao = new Conexao();
        PreparedStatement pstm;
        try{
            conexao.conectar();
            pstm = conexao.getConn().prepareStatement("DELETE FROM USUSARIO WHERE sId = ?");
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
