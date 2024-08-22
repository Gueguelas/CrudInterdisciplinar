public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        //Teste de conexão
        if(conexao.conectar()){
            System.out.println("funfo");
        }else{
            System.out.println("Nao funfo");
        }
    }
}
