import java.sql.PreparedStatement; //Gerencia e executa os comandos
import java.sql.ResultSet; // Guarda os resultados da consulta ao banco
import java.sql.SQLException; //Exceções
import java.sql.Date; // Classe de datas sql
public class UsuarioDAO {
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

    //O id de usuario é SERIAL, ou seja, não precisa ser inserido
    public boolean inserirUsuario(String email,String telefone, Date dataNascimento,String nome,String sobrenome,String linkLinkedin,Date dataCriacao,String senha,String cnpj, String cpf){
        conexao.conectar();
        try {
            pstmt = conexao.getConn().prepareStatement("INSERT INTO USUARIO (CEMAIL,CTELEFONE,DDATANASCIMENTO,CNOME,CSOBRENOME,CLINKLINKEDIN,DDATACRIACAO,CSENHA,CCNPJ,CCPF) VALUES (?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, email);
            pstmt.setString(2, telefone);
            pstmt.setDate(3, dataNascimento);
            pstmt.setString(4, nome);
            pstmt.setString(5, sobrenome);
            pstmt.setString(6, linklinkedin);
            pstmt.setDate(7, dataCriacao);
            pstmt.setString(8, senha);
            pstmt.setString(9, cnpj);
            pstmt.setString(10, cpf);
            return pstmt.executeUpdate()>0;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
    public int alterarEmail(String email, int id) {
        try {
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE usuario SET cEMAIL = ? WHERE sId = ?");
//          Argumentos
            pstmt.setString(1, email);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (java.sql.SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
//          Desconectando do DB
            conexao.desconectar();
        }


    }
    public int alterarTelefone(String telefone, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE usuario SET cTelefone = ? WHERE sId = ?");
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
    public int alterarDataNascimento(Date data_nascimento, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE usuario SET dDataNascimento = ? WHERE sId = ?");
//          Argumentos
            pstmt.setDate(1, data_nascimento);
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
            pstmt = conexao.getConn().prepareStatement("UPDATE usuario SET cNome = ? WHERE sId = ?");
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
    public int alterarSobrenome(String sobrenome, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE usuario SET cSobrenome = ? WHERE sId = ?");
//          Argumentos
            pstmt.setString(1, sobrenome);
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
    public int alterarLinkedin(String link_linkedin, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE usuario SET cLinkLinkedin = ? WHERE sId = ?");
//          Argumentos
            pstmt.setString(1, link_linkedin);
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
    //NAO SE PODE ALTERAR DATA DE CRIAÇAO
    public int alterarSenha(String senha, int id) {
        try{
//          Conectando com o db
            conexao.conectar();
//          Comando SQL
            pstmt = conexao.getConn().prepareStatement("UPDATE usuario SET cSenha = ? WHERE sId = ?");
//          Argumentos
            pstmt.setString(1, senha);
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
    //CPF E CNPJ NAO PODERAO SER ALTERADOS
}