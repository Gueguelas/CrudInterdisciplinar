import java.sql.PreparedStatement; //Gerencia e executa os comandos
import java.sql.ResultSet; // Guarda os resultados da consulta ao banco


public class CursoDAO {
    private PreparedStatement pstmt;
    //  Instanciando a classe conexao
    Conexao conexao = new Conexao();

    public boolean inserirCurso(String descricao, String duracao, String certificacao, String nome, double valor, int quantidade, String categoria, int numeroInscricao, int idUsuario) {
        try{
            conexao.conectar();
            pstmt = conexao.getConn().prepareStatement("INSERT INTO CURSO (cDescricao, cDuracao, cCertificacao, cNome, fValor, iQuantidade, cCategoria, iNumeroInscricao, idUsuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, descricao);
            pstmt.setString(2, duracao);
            pstmt.setString(3, certificacao);
            pstmt.setString(4, nome);
            pstmt.setDouble(5, valor);
            pstmt.setInt(6, quantidade);
            pstmt.setString(7, categoria);
            pstmt.setInt(8, numeroInscricao);
            pstmt.setInt(9, idUsuario);

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

    public int alterarDescricao(String descricao, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE CURSO SET cDescricao = ? WHERE sId = ?");
//          Argumentos
            pstmt.setString(1, descricao);
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

    public int alterarDuracao(String duracao, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE CURSO SET cDuracao = ? WHERE sId = ?");
//          Argumentos
            pstmt.setString(1, duracao);
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

    public int alterarCertificacao(String certificacao, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE CURSO SET cCertificacao = ? WHERE sId = ?");
//          Argumentos
            pstmt.setString(1, certificacao);
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

    public int alterarNome(String nome, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE CURSO SET cNome = ? WHERE sId = ?");
//          Argumentos
            pstmt.setString(1, nome);
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

    public int alterarValor(double valor, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE CURSO SET fValor = ? WHERE sId = ?");
//          Argumentos
            pstmt.setDouble(1, valor);
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

    public int alterarQuantidade(int quantidade, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE CURSO SET iQuantidade = ? WHERE sId = ?");
//          Argumentos
            pstmt.setInt(1, quantidade);
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

    public int alterarCategoria(String categoria, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE CURSO SET cCategoria = ? WHERE sId = ?");
//          Argumentos
            pstmt.setString(1, categoria);
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

    public int alterarNumeroInscricao(int numeroInscricao, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE CURSO SET iNumeroInscricao = ? WHERE sId = ?");
//          Argumentos
            pstmt.setInt(1, numeroInscricao);
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
            String remover = "DELETE FROM CURSO WHERE sId = ?";
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
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM CURSO ORDER BY sId");
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
