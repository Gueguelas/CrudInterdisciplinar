public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        //Teste de conexão
        if(conexao.conectar()){
            System.out.println("FUNFO DIMAISI");
        }else{
            System.out.println("num funfo :(");
        }
        Produto produto = new Produto();
//        produto.inserirProduto("Betonera 10/100", 149.99, "Obra", "Usado", "Betonera foda", 1);
          produto.alterarNome("Betonera TOpzera", 1);
    }
}
