package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.Conexao;

public class CategoriaCursoDAO {
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

    public CategoriaCursoDAO() {}

    public int inserirCategoria(int sid, String cnome) {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("INSERT INTO CATEGORIACURSO (SID, CNOME) VALUES (?, ?)");
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

    // Remover
    public int remover(int sid) {
        conexao.conectar();
        try {
            this.pstmt = conexao.getConn().prepareStatement("DELETE FROM CATEGORIACURSO WHERE SID = ?");
            pstmt.setInt(1, sid);
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    // Alterar Nome
    public int alterarNome(String cnome, int sid) {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE CATEGORIACURSO SET CNOME = ? WHERE SID = ?");
            pstmt.setString(1, cnome);
            pstmt.setInt(2, sid);
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    // Buscar Categoria de Serviço
    public ResultSet buscar() {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("SELECT * FROM CATEGORIACURSO");
            return pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } // connection is not closed here as ResultSet is being returned
    }

    // Buscar por ID
    public ResultSet buscarPorId(int sid) {
        conexao.conectar();
        try {
            this.pstmt = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIACURSO WHERE SID = ?");
            pstmt.setInt(1, sid);
            return pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } // connection is not closed here as ResultSet is being returned
    }

    // Buscar por Nome
    public ResultSet buscarPorNome(String cnome) {
        conexao.conectar();
        try {
            this.pstmt = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIACURSO WHERE CNOME = ?");
            pstmt.setString(1, cnome);
            return pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } // connection is not closed here as ResultSet is being returned
    }
}

