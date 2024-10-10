import Conexao.Conexao;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        //Teste de conexão
        if(conexao.conectar()){
            System.out.println("A conexão com o banco está funcionando!");
        }else{
            System.out.println("Houve erro na conexão com o Banco de Dados...");
        }
    }
}
