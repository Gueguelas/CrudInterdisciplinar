import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        //Teste de conexão
//        if(conexao.conectar()){
//            System.out.println("FUNFO DIMAISI");
//        }else{
//            System.out.println("num funfo :(");
//        }
        Usuario usuario1 = new Usuario();
        usuario1.inserirCliente("x","x", Date.valueOf("2004-12-29"),"x","x","x","x","xx");
    }

}
