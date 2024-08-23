import java.sql.PreparedStatement; //Gerencia e executa os comandos
import java.sql.ResultSet; // Guarda os resultados da consulta ao banco
import java.sql.SQLException; //Exceções
import java.sql.Date; // Classe de datas sql
public class Usuario {
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

    //O id de usuario é SERIAL, ou seja, não precisa ser inserido
    public boolean inserirCliente(String email,String telefone, Date data_nascimento,String nome,String sobrenome,String senha,String cnpj, String cpf){
        conexao.conectar();
        try {
            pstmt = conexao.conn.prepareStatement("INSERT INTO USUARIO (CEMAIL,CTELEFONE,DDATANASCIMENTO,CNOME,CSOBRENOME,CSENHA,CCNPJ,CCPF) VALUES (?,?,?,?,?,?,?,?)");
            pstmt.setString(1, email);
            pstmt.setString(2, telefone);
            pstmt.setDate(3, data_nascimento);
            pstmt.setString(4, nome);
            pstmt.setString(5, sobrenome);
            pstmt.setString(6, senha);
            pstmt.setString(7, cnpj);
            pstmt.setString(8, cpf);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

}

