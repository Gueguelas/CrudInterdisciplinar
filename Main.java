import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        CategoriaServico categoriaServico = new CategoriaServico();
        //Teste de conexão
        if (conexao.conectar()) {
            System.out.println("FUNFO DIMAISI");
        } else {
            System.out.println("num funfo :(");
        }

        // TESTANDO MÉTODO INSERIRCATEGORIASERVICO
//        categoriaServico.inserirCategoriaServico(1, "categoria teste");
//        categoriaServico.inserirCategoriaServico(2, "categoria de teste 2");
//        categoriaServico.inserirCategoriaServico(3, "categoria de teste 3");
//        categoriaServico.inserirCategoriaServico(4, "categoria de teste 4");
//        categoriaServico.inserirCategoriaServico(5, "categoria de teste 5");


        // TESTANDO MÉTODO BUSCAR
        ResultSet rsbusca = categoriaServico.buscar();
        try {
            if (rsbusca.next()) {
                String lista = ("sID: " + rsbusca.getInt("SID") + "\tNome: " + rsbusca.getString("CNOME"));
                System.out.println(lista);

            } else {
                System.out.println("Chave primaria não existe");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        categoriaServico.alterarNome("categoria de teste 1", 1);


        // TESTANDO O MÉTODO REMOVER
//        System.out.println(categoriaServico.remover(2));
    }
}