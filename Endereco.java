import java.sql.PreparedStatement; //Gerencia e executa os comandos
import java.sql.ResultSet; // Guarda os resultados da consulta ao banco
import java.sql.Date; //Datas em sql
import java.sql.SQLException;
import java.time.Period;

public class Endereco {
    Conexao conexao = new Conexao();
    private PreparedStatement pstm;
    //Inserir todas as informações de endereço;
    public boolean inserirNovoEndereco(String cep, String bairro, String pais, int numero, String estado, String rua, int idUsusario){
        conexao.conectar();
        try{
            pstm = conexao.getConn().prepareStatement("INSERT INTO Endereco(cCep, cBairro, cPais, iNumero, cEstado, cRua, idUsuario) VALUES(?, ?, ?, ?, ?, ?, ?)");
            pstm.setString(1, cep);
            pstm.setString(2, bairro);
            pstm.setString(3, pais);
            pstm.setInt(4, numero);
            pstm.setString(5, estado);
            pstm.setString(6, rua);
            pstm.setInt(7, idUsusario);
            if (pstm.executeUpdate() <= 0){
                return false;
            }
            else{
                return true;
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

    public boolean alterarEnderecoCep(String cep, int id){
        conexao.conectar();
        try{
            pstm = conexao.getConn().prepareStatement("UPDATE ENDERECO SET cCep = ? WHERE sId = ?");
            pstm.setString(1, cep);
            pstm.setInt(2, id);
            if (pstm.executeUpdate() <= 0){
                return false;
            }
            else{
                return true;
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    }

    public boolean alterarEnderecoNumero(int numero, int id){
        conexao.conectar();
        try{
            pstm = conexao.getConn().prepareStatement("UPDATE ENDERECO SET iNumero = ? WHERE sId = ?");
            pstm.setInt(1, numero);
            pstm.setInt(2, id);
            if (pstm.executeUpdate() <= 0){
                return false;
            }
            else{
                return true;
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    }

    public boolean alterarEnderecoRua(String rua, int id){
        conexao.conectar();
        try{
            pstm = conexao.getConn().prepareStatement("UPDATE ENDERECO SET cRua = ? WHERE sId = ?");
            pstm.setString(1, rua);
            pstm.setInt(2, id);
            if (pstm.executeUpdate() <= 0){
                return false;
            }
            else{
                return true;
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    }

    public int remover(int id){
        try{
            conexao.conectar();
            String remover = "DELETE FROM ENDERECO WHERE sId = ?";
            pstm = conexao.getConn().prepareStatement(remover);
            pstm.setInt(1, id);
            if (pstm.executeUpdate() > 0){
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

    public ResultSet buscar(){
        try{
            conexao.conectar();
            pstm = conexao.getConn().prepareStatement("SELECT * FROM ENDERECO ORDER BY sId");
            ResultSet rset = pstm.executeQuery();
            return rset;
        }catch (java.sql.SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }
}

