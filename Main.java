import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Conexao conexao = new Conexao();
        //Teste de conexão
        if(conexao.conectar()){
            System.out.println("FUNFO DIMAISI");
        }else{
            System.out.println("num funfo :(");
        }
        Produto produto = new Produto();
//        produto.inserirProduto("Betonera 10/100", 149.99, "Obra", "Usado", "Betonera foda", 1);
//          produto.alterarNome("Betonera TOpzera", 1);

//        BUSCAR POR NOME
//        ResultSet rsCategoria = produto.buscarPorNome("Betonera TOpzera");
//        try {
//                if (rsCategoria != null){
//                    while (rsCategoria.next()) {
//                        String lista = ("cNome: "
//                                + rsCategoria.getString("cNome")
//                                + "\nfPreco: " + rsCategoria.getString("fPreco")
//                                + "\ncCategoria: " + rsCategoria.getString("cCategoria")
//                                + "\ncEstado: " + rsCategoria.getString("cEstado")
//                                + "\ncDecricao: " + rsNome.getString("cDescricao")
//                                + "\nidUsuario: " + rsNome.getInt("idUsuario"));
//                        System.out.println(lista);
//                    }
//                }else{
//                    System.out.println("Nome não existe");
//                }
//            } catch (SQLException sqle) {
//                sqle.printStackTrace();
//            }

//        BUSCAR POR PRECO
//        ResultSet rsPreco = produto.buscarPorPreco(149.99);
//        try {
//            if (rsPreco != null){
//                while (rsPreco.next()) {
//                    String lista = ("cNome: "
//                            + rsPreco.getString("cNome")
//                            + "\nfPreco: " + rsPreco.getString("fPreco")
//                            + "\ncCategoria: " + rsPreco.getString("cCategoria")
//                            + "\ncEstado: " + rsPreco.getString("cEstado")
//                            + "\ncDecricao: " + rsPreco.getString("cDescricao")
//                            + "\nidUsuario: " + rsPreco.getInt("idUsuario"));
//                    System.out.println(lista);
//                }
//            }else {
//                System.out.println("Nome não existe");
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }

//        BUSCAR POR CATEGORIA
//        ResultSet rsCategoria  = produto.buscarPorCategoria("Obra");
//        try {
//            if (rsCategoria != null){
//                while (rsCategoria.next()) {
//                    String lista = ("cNome: "
//                            + rsCategoria.getString("cNome")
//                            + "\nfPreco: " + rsCategoria.getString("fPreco")
//                            + "\ncCategoria: " + rsCategoria.getString("cCategoria")
//                            + "\ncEstado: " + rsCategoria.getString("cEstado")
//                            + "\ncDecricao: " + rsCategoria.getString("cDescricao")
//                            + "\nidUsuario: " + rsCategoria.getInt("idUsuario"));
//                    System.out.println(lista);
//                }
//            }else{
//                System.out.println("Nome não existe");
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }

//        BUSCAR POR ESTADO
//        ResultSet rsEstado  = produto.buscarPorEstado("Obra");
//        try {
//            if (rsEstado != null){
//                while (rsEstado.next()) {
//                    String lista = ("cNome: "
//                            + rsEstado.getString("cNome")
//                            + "\nfPreco: " + rsEstado.getString("fPreco")
//                            + "\ncCategoria: " + rsEstado.getString("cCategoria")
//                            + "\ncEstado: " + rsEstado.getString("cEstado")
//                            + "\ncDecricao: " + rsEstado.getString("cDescricao")
//                            + "\nidUsuario: " + rsEstado.getInt("idUsuario"));
//                    System.out.println(lista);
//                }
//            }else{
//                System.out.println("Nome não existe");
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }

//          Buscar por Descrição
//        ResultSet rsDescricao  = produto.buscarPorDescricao("Obra");
//        try {
//            if (rsDescricao != null){
//                while (rsDescricao.next()) {
//                    String lista = ("cNome: "
//                            + rsDescricao.getString("cNome")
//                            + "\nfPreco: " + rsDescricao.getString("fPreco")
//                            + "\ncCategoria: " + rsDescricao.getString("cCategoria")
//                            + "\ncEstado: " + rsDescricao.getString("cEstado")
//                            + "\ncDecricao: " + rsDescricao.getString("cDescricao")
//                            + "\nidUsuario: " + rsDescricao.getInt("idUsuario"));
//                    System.out.println(lista);
//                }
//            }else{
//                System.out.println("Nome não existe");
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }

//        Buscar por ID USUARIO
//        ResultSet rsIdUsuario  = produto.buscarPoridUsuario(1);
//        try {
//            if (rsIdUsuario != null){
//                while (rsIdUsuario.next()) {
//                    String lista = ("cNome: "
//                            + rsIdUsuario.getString("cNome")
//                            + "\nfPreco: " + rsIdUsuario.getString("fPreco")
//                            + "\ncCategoria: " + rsIdUsuario.getString("cCategoria")
//                            + "\ncEstado: " + rsIdUsuario.getString("cEstado")
//                            + "\ncDecricao: " + rsIdUsuario.getString("cDescricao")
//                            + "\nidUsuario: " + rsIdUsuario.getInt("idUsuario"));
//                    System.out.println(lista);
//                }
//            }else{
//                System.out.println("Nome não existe");
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }

    }
}
