import java.sql.Connection; //Mantêm a conexão aberta e fecha
import java.sql.DriverManager; //Cria uma conexão
import java.sql.PreparedStatement; //Gerencia e executa os comandos
import java.sql.ResultSet; // Guarda os resultados da consulta ao banco
import java.sql.SQLException; //Exceções
import java.sql.Date; // Classe de datas sql

public class Curriculo {
    private PreparedStatement pstmt;
//  Instanciando a classe conexao
    Conexao conexao = new Conexao();



    // Metodo para instanciar um curriculo no banco
    public boolean inserirCurriculo(String infosGerais, Date dataCriacao, String projetos, String habilidades, Date dataAtualizacao, String linkLinkedin, String telefone, int idUsuario) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("INSERT INTO CURRICULO (cInfosGerais, dDataCriacao, cProjetos, cHabilidades, dDataAtualizacao, cLinkLinkedin, cTelefone, idUsuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
//          Argumentos
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
//          Desconectando do DB
            conexao.desconectar(); //fechando a conexão com o banco
        }
    }
//    Metodos para modificar uma coluna da tabela curriculo
    public int alterarInfosGerais(String infosGerais, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE tabela SET cInfosGerais = ? WHERE sId = ?");
//          Argumentos
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
//          Desconectando do DB
            conexao.desconectar();
        }
    }

    public int alterarProjetos(String projetos, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE tabela SET cProjetos = ? WHERE sId = ?");
//          Argumentos
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
//          Desconectando do DB
            conexao.desconectar();
        }
    }

    public int alterarHabilidades(String habilidades, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE tabela SET cHabilidades = ? WHERE sId = ?");
//          Argumentos
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
//          Desconectando do DB
            conexao.desconectar();
        }
    }

    public int alterarDataAtualizacao(Date dataAtualizacao, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE tabela SET dDataAtualizacao = ? WHERE sId = ?");
//          Argumentos
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
//          Desconectando do DB
            conexao.desconectar();
        }
    }

    public int alterarLinkLinkedin(String linkLikedin, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE tabela SET cLinkLinkedin = ? WHERE sId = ?");
//          Argumentos
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
//          Desconectando do DB
            conexao.desconectar();
        }
    }

    public int alterarTelefone(String telefone, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE tabela SET cTelefone = ? WHERE sId = ?");
//          Argumentos
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
//          Desconectando do DB
            conexao.desconectar();
        }
    }
// Metodo para remover uma linha no DB
    public int remover(int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            String remover = "DELETE FROM CURRICULO WHERE sId = ?";
            pstmt = conexao.getConn().prepareStatement(remover);
//          Argumentos
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
//          Desconectando do DB
            conexao.desconectar();
        }
    }
// Metodo para mostrar informações da tabela curriculo
    public ResultSet buscar() {
        try{
            conexao.conectar(); //Abrindo a conexão com o banco
            // Instanciando o objeto preparedStatement (pstmt)
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM CURRICULO ORDER BY sId");
            // Executando o comando sql do objeto preparedStatement e armazenando no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset;
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
//          Desconectando do DB
            conexao.desconectar();
        }
    }
}