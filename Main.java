import java.sql.Date;

public class Main {
    public static void main(String[] args) {
//        Conexao conexao = new Conexao();
////        Teste de conexão
//        if(conexao.conectar()){
//            System.out.println("FUNFO DIMAISI");
//        }else{
//            System.out.println("num funfo :(");
//        }
        Usuario usuario1 = new Usuario();
        //Testando todos os metodos
//        usuario1.inserirUsuario("x","x", Date.valueOf("2004-12-29"),"x","x","x",Date.valueOf("2024-01-01"),"xx", "x","x");
//        usuario1.alterarEmail("KKKKKK",1);
//        System.out.println(usuario1.alterarTelefone("11940543694",1));
//        System.out.println(usuario1.alterarDataNascimento(Date.valueOf("2008-12-28"),1));
//        System.out.println(usuario1.alterarNome("GueguelasPG",1));
//        System.out.println(usuario1.alterarSobrenome("FatDick",1));
//        System.out.println(usuario1.alterarLinkedin("AI AI AI",1));
        System.out.println(usuario1.alterarSenha("GGPG É O MELHOR",1));
    }

}
