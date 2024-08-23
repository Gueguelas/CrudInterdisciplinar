import java.sql.Connection; //Mantêm a conexão aberta e fecha
import java.sql.DriverManager; //Cria uma conexão
import java.sql.PreparedStatement; //Gerencia e executa os comandos
import java.sql.ResultSet; // Guarda os resultados da consulta ao banco
import java.sql.SQLException; //Exceções
import java.sql.Date; // Classe de datas sql

public class Curriculo {
    private PreparedStatement pstmt;
    Conexao conexao = new Conexao();

    public boolean inserirCurriculo(String infosGerais, Date dataCriacao, String projetos, String habilidades, Date dataAtualizacao, String linkLinkedin, String telefone, int idUsuario) {
        try{
            conexao.conectar();
            pstmt = conexao.conn.prepareStatement("INSERT INTO CURRICULO (cInfosGerais, dDataCriacao, cProjetos, cHabilidades, dDataAtualizacao, cLinkLinkedin, cTelefone, idUsuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, infosGerais);
            pstmt.setDate(2, dataCriacao);
            pstmt.setString(3, projetos);
            pstmt.setString(4, habilidades);
            pstmt.setDate(5, dataAtualizacao);
            pstmt.setString(6, linkLinkedin);
            pstmt.setString(7, telefone);
            pstmt.setInt(8, idUsuario);

            if (pstmt.executeUpdate() <= 0){
                return false;
            }
            else{
                return true;
            }
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar(); //fechando a conexão com o banco
        }
    }

    public int alterarInfosGerais(String infosGerais, int id) {
        try{
            conexao.conectar();
            pstmt = conexao.conn.prepareStatement("UPDATE tabela SET cInfosGerais = ? WHERE sId = ?");
            pstmt.setString(1, infosGerais);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }

    public int alterarProjetos(String projetos, int id) {
        try{
            conexao.conectar();
            pstmt = conexao.conn.prepareStatement("UPDATE tabela SET cProjetos = ? WHERE sId = ?");
            pstmt.setString(1, projetos);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }

    public int alterarHabilidades(String habilidades, int id) {
        try{
            conexao.conectar();
            pstmt = conexao.conn.prepareStatement("UPDATE tabela SET cHabilidades = ? WHERE sId = ?");
            pstmt.setString(1, habilidades);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }

    public int alterarDataAtualizacao(Date dataAtualizacao, int id) {
        try{
            conexao.conectar();
            pstmt = conexao.conn.prepareStatement("UPDATE tabela SET dDataAtualizacao = ? WHERE sId = ?");
            pstmt.setDate(1, dataAtualizacao);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }

    public int alterarLinkLinkedin(String linkLikedin, int id) {
        try{
            conexao.conectar();
            pstmt = conexao.conn.prepareStatement("UPDATE tabela SET cLinkLinkedin = ? WHERE sId = ?");
            pstmt.setString(1, linkLikedin);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }

    public int alterarTelefone(String telefone, int id) {
        try{
            conexao.conectar();
            pstmt = conexao.conn.prepareStatement("UPDATE tabela SET cTelefone = ? WHERE sId = ?");
            pstmt.setString(1, telefone);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }

    public int remover(int id) {
        try{
            conexao.conectar();
            String remover = "DELETE FROM CURRICULO WHERE sId = ?";
            pstmt = conexao.conn.prepareStatement(remover);
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0){
                return 1;
            }
            else{
                return 0;
            }
        }catch(java.sql.SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }

    public ResultSet buscar() {
        try{
            conexao.conectar(); //Abrindo a conexão com o banco
            // Instanciando o objeto preparedStatement (pstmt)
            pstmt = conexao.conn.prepareStatement("SELECT * FROM CURRICULO ORDER BY sId");
            // Executando o comando sql do objeto preparedStatement e armazenando no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset;
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }
}