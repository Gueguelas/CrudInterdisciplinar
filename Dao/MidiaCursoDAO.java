package Dao; // Pacote que contém a classe DAO

import Conexao.Conexao; // Importa a classe de conexão ao banco de dados
import Modelos.MidiaCurso; // Importa a classe que representa o modelo de MidiaCurso
import java.sql.PreparedStatement; // Importa a classe para preparar instruções SQL
import java.sql.SQLException; // Importa a classe para tratar exceções relacionadas ao SQL

public class MidiaCursoDAO {
    private PreparedStatement pstm; // Objeto para executar comandos SQL preparados
    Conexao conexao = new Conexao(); // Instância da classe de conexão com o banco de dados

    // Método para remover a mídia de um curso
    public int removerMidiaCurso(MidiaCurso midiaCurso) {
        conexao.conectar(); // Estabelece a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualizar a mídia, definindo bisUpdated como false
            this.pstm = conexao.getConn().prepareStatement("UPDATE MIDIACURSO SET bisInactive = true WHERE sId = ?");
            pstm.setInt(1, midiaCurso.getsId()); // Define o ID da mídia a ser atualizada
            return pstm.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) { // Trata exceções relacionadas ao SQL
            sqle.printStackTrace(); // Imprime a stack trace da exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Garante que a conexão seja fechada
        }
    }

    // Método para inserir uma nova mídia de curso
    public boolean inserirMidiaCurso(MidiaCurso midiaCurso) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para inserção
            this.pstm = conexao.getConn().prepareStatement("INSERT INTO MIDIACURSO (idCurso, cUrlFoto) VALUES(?)");
            this.pstm.setInt(1, midiaCurso.getIdCurso());
            this.pstm.setString(2, midiaCurso.getcURLFoto()); // Define o URL da foto
            return pstm.executeUpdate() > 0; // Executa a inserção e retorna o número de linhas afetadas
        } catch (SQLException sqle) { // Trata exceções relacionadas ao SQL
            sqle.printStackTrace(); // Imprime a stack trace da exceção
            return false; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar a foto de uma mídia de curso
    public int alterarMidiaCursoFoto(MidiaCurso midiaCurso) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização
            pstm = conexao.getConn().prepareStatement("UPDATE MIDIACURSO SET CURLFOTO = ? WHERE SID = ?");
            pstm.setString(1, midiaCurso.getcURLFoto()); // Define o novo URL da foto
            pstm.setInt(2, midiaCurso.getsId()); // Define o ID da mídia a ser atualizada
            return pstm.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) { // Trata exceções relacionadas ao SQL
            sqle.printStackTrace(); // Imprime a stack trace da exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    public int alterarMidiaCursoidCurso(MidiaCurso midiaCurso) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização
            pstm = conexao.getConn().prepareStatement("UPDATE MIDIACURSO SET iIdCurso = ? WHERE SID = ?");
            pstm.setInt(1, midiaCurso.getIdCurso()); // Define o novo URL da foto
            pstm.setInt(2, midiaCurso.getsId()); // Define o ID da mídia a ser atualizada
            return pstm.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) { // Trata exceções relacionadas ao SQL
            sqle.printStackTrace(); // Imprime a stack trace da exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }
}
