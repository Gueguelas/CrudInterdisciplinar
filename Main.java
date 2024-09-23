public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        //Teste de conexão
        if (conexao.conectar()) {
            System.out.println("FUNFO DIMAISI");
        } else {
            System.out.println("num funfo :(");
        }
    }
}
