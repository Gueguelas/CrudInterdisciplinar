package Dao;

import java.sql.PreparedStatement; // Importa a classe para executar instruções SQL preparadas
import java.sql.SQLException;// Importa a classe para tratar exceções relacionadas ao SQL
import Conexao.Conexao;

// Classe responsável pela manipulação de cursos
public class CursoDAO {
    private Conexao conn = new Conexao(); // Instância da classe de conexão com o banco de dados
    private PreparedStatement pstm; // Objeto para executar comandos SQL preparados

    // Método para inserir um novo curso no banco de dados
    public boolean inserirCurso(String cCategoria, String cDescricao, String cNome, int iNumeroInscricao, double fValor, boolean bStatus, String cDuracao, int iIdCategoriaCurso) {
        conn.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para inserção
            pstm = conn.getConn().prepareStatement("INSERT INTO Curso(cCategoria, cDescricao, cNome, iNumeroInscricao, fValor, bStatus, cDuracao, idCategoria, iIdCategoriaCurso) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            // Define os valores dos parâmetros
            pstm.setString(1, cCategoria);
            pstm.setString(2, cDescricao);
            pstm.setString(3, cNome);
            pstm.setInt(4, iNumeroInscricao);
            pstm.setDouble(5, fValor);
            pstm.setBoolean(6, bStatus);
            pstm.setString(7, cDuracao);
            pstm.setInt(8, iIdCategoriaCurso);
            // Executa a inserção e verifica se houve sucesso
            if (pstm.executeUpdate() <= 0) {
                return false; // Retorna false se a inserção falhar
            } else {
                return true; // Retorna true se a inserção for bem-sucedida
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return false; // Retorna false em caso de erro
        } finally {
            conn.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar o status de um curso
    public boolean alterarStatusCurso(boolean bstatus, int sId) {
        conn.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização do status
            pstm = conn.getConn().prepareStatement("UPDATE Curso SET bStatus = ? WHERE sID = ?");
            pstm.setBoolean(1, bstatus); // Define o novo status
            pstm.setInt(2, sId); // Define o ID do curso a ser atualizado
            // Executa a atualização e verifica se houve sucesso
            if (pstm.executeUpdate() <= 0) {
                return false; // Retorna false se a atualização falhar
            } else {
                return true; // Retorna true se a atualização for bem-sucedida
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return false; // Retorna false em caso de erro
        } finally {
            conn.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar o nome de um curso
    public boolean alterarNomeCurso(String cNome_curso, int sId) {
        conn.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização do nome do curso
            pstm = conn.getConn().prepareStatement("UPDATE Curso SET cNome_curso = ? WHERE sID = ?");
            pstm.setString(1, cNome_curso); // Define o novo nome
            pstm.setInt(2, sId); // Define o ID do curso a ser atualizado
            // Executa a atualização e verifica se houve sucesso
            if (pstm.executeUpdate() <= 0) {
                return false; // Retorna false se a atualização falhar
            } else {
                return true; // Retorna true se a atualização for bem-sucedida
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return false; // Retorna false em caso de erro
        } finally {
            conn.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar o valor de um curso
    public boolean alterarValorCurso(double fValor, int sId) {
        conn.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização do valor do curso
            pstm = conn.getConn().prepareStatement("UPDATE Curso SET fValor = ? WHERE sID = ?");
            pstm.setDouble(1, fValor); // Define o novo valor
            pstm.setInt(2, sId); // Define o ID do curso a ser atualizado
            // Executa a atualização e verifica se houve sucesso
            if (pstm.executeUpdate() <= 0) {
                return false; // Retorna false se a atualização falhar
            } else {
                return true; // Retorna true se a atualização for bem-sucedida
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return false; // Retorna false em caso de erro
        } finally {
            conn.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar a descrição de um curso
    public boolean alterarDescricaoCurso(String cDescricao, int sId) {
        conn.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização da descrição do curso
            pstm = conn.getConn().prepareStatement("UPDATE Curso SET cDescricao = ? WHERE sID = ?");
            pstm.setString(1, cDescricao); // Define a nova descrição
            pstm.setInt(2, sId); // Define o ID do curso a ser atualizado
            // Executa a atualização e verifica se houve sucesso
            if (pstm.executeUpdate() <= 0) {
                return false; // Retorna false se a atualização falhar
            } else {
                return true; // Retorna true se a atualização for bem-sucedida
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return false; // Retorna false em caso de erro
        } finally {
            conn.desconectar(); // Fecha a conexão com o banco de dados
        }
    }
}
