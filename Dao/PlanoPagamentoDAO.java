package Dao;

import java.sql.PreparedStatement; // Importa a classe para executar instruções SQL preparadas
import java.sql.ResultSet; // Importa a classe para manipular resultados de consultas SQL
import java.sql.SQLException; // Importa a classe para tratar exceções relacionadas ao SQL
import Conexao.Conexao;


// Classe responsável pela manipulação de planos de pagamento
public class PlanoPagamentoDAO {
    private PreparedStatement pstmt; // Objeto para executar comandos SQL preparados
    Conexao conexao = new Conexao();// Instância da classe de conexão com o banco de dados;

    // Construtor da classe
    public PlanoPagamentoDAO() {
    }

    // Método para inserir um novo plano de pagamento
    public int inserirPlanoPagamento(String cFormaPagamento, String cTipoPlano, String cDescricao, double fValor) {
        this.conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para inserção
            this.pstmt = this.conexao.getConn().prepareStatement("INSERT INTO PLANO_PAGAMENTO (cFormaPagamento, cTipoPlano, cDescricao, fValor) VALUES(?,?,?,?)");
            // Define os valores dos parâmetros
            this.pstmt.setString(1, cFormaPagamento);
            this.pstmt.setString(2, cTipoPlano);
            this.pstmt.setString(3, cDescricao);
            this.pstmt.setDouble(4, fValor);
            // Executa a inserção e retorna o número de linhas afetadas
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar a forma de pagamento por ID
    public int alterarFormaPagamento(String cFormaPagamento, int sid) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização da forma de pagamento
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE PLANO_PAGAMENTO SET CFORMAPAGAMENTO = ? WHERE SID = ?");
            // Define os parâmetros
            pstmt.setString(1, cFormaPagamento); // Atualiza a forma de pagamento
            pstmt.setInt(2, sid); // Define o ID do plano a ser atualizado
            // Executa a atualização e retorna o número de linhas afetadas
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar o tipo de plano por ID
    public int alterarTipoPlano(String cTipoPlano, int sid) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização do tipo de plano
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE PLANO_PAGAMENTO SET CTIPOPLANO = ? WHERE SID = ?");
            // Define os parâmetros
            pstmt.setString(1, cTipoPlano); // Atualiza o tipo de plano
            pstmt.setInt(2, sid); // Define o ID do plano a ser atualizado
            // Executa a atualização e retorna o número de linhas afetadas
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar a descrição por ID
    public int alterarDescricao(String cDescricao, int sid) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização da descrição
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE PLANO_PAGAMENTO SET CDESCRICAO = ? WHERE SID = ?");
            // Define os parâmetros
            pstmt.setString(1, cDescricao); // Atualiza a descrição
            pstmt.setInt(2, sid); // Define o ID do plano a ser atualizado
            // Executa a atualização e retorna o número de linhas afetadas
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar o valor por ID
    public int alterarValor(double fValor, int sid) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização do valor
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE PLANO_PAGAMENTO SET FVALOR = ? WHERE SID = ?");
            // Define os parâmetros
            pstmt.setDouble(1, fValor); // Atualiza o valor
            pstmt.setInt(2, sid); // Define o ID do plano a ser atualizado
            // Executa a atualização e retorna o número de linhas afetadas
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para remover um plano de pagamento por ID
    public int removerPlanoPagamento(int sid) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para remoção
            this.pstmt = conexao.getConn().prepareStatement("DELETE FROM PLANO_PAGAMENTO WHERE sId = ?");
            // Define o parâmetro
            pstmt.setInt(1, sid); // Define o ID do plano a ser removido
            // Executa a remoção e retorna o número de linhas afetadas
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para buscar todos os planos de pagamento
    public ResultSet buscarTodosPlanoPagamento() {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de todos os planos
            this.pstmt = this.conexao.getConn().prepareStatement("SELECT * FROM PLANO_PAGAMENTO");
            // Executa a consulta e armazena o resultado no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset; // Retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para buscar um plano de pagamento por ID
    public ResultSet buscarPlanoPagamentoPorId(int sid) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de um plano por ID
            this.pstmt = conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE SID = ?");
            pstmt.setInt(1, sid); // Define o ID do plano a ser buscado
            // Executa a consulta e armazena o resultado no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset; // Retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para buscar um plano de pagamento por valor
    public ResultSet buscarPlanoPagamentoPorValor(double valor) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de um plano por valor
            this.pstmt = conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE FVALOR = ?");
            pstmt.setDouble(1, valor); // Define o valor do plano a ser buscado
            // Executa a consulta e armazena o resultado no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset; // Retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para buscar um plano de pagamento por forma de pagamento
    public ResultSet buscarPorFormaPagamento(String FormaPagamento) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de um plano por forma de pagamento
            this.pstmt = conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE CFORMAPAGAMENTO = ?");
            pstmt.setString(1, FormaPagamento); // Define a forma de pagamento do plano a ser buscado
            // Executa a consulta e armazena o resultado no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset; // Retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para buscar um plano de pagamento por tipo de plano
    public ResultSet buscarPorTipoPlano(String TipoPlano) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de um plano por tipo de plano
            this.pstmt = conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE CTIPOPLANO = ?");
            pstmt.setString(1, TipoPlano); // Define o tipo de plano do plano a ser buscado
            // Executa a consulta e armazena o resultado no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset; // Retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para buscar um plano de pagamento por descrição
    public ResultSet buscarPorDescricao(String Descricao) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de um plano por descrição
            this.pstmt = conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE CDESCRICAO = ?");
            pstmt.setString(1, Descricao); // Define a descrição do plano a ser buscado
            // Executa a consulta e armazena o resultado no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset; // Retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }
}
