public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        //Teste de conexão
        if(conexao.conectar()){
            System.out.println("FUNFO DIMAISI");
        }else{
            System.out.println("num funfo :(");
        }

        //teste inserirNovoEndereço
        Endereco endereco = new Endereco();
        if(endereco.inserirNovoEndereco("06310300", "Carapicuíba", "Brasil", 976576032, "SP", "Gustavo Avelino Correa", 1)){
            System.out.println("Endereço adicionado :)");
        } else {
            System.out.println("Houve erro...");
        }

        if(endereco.alterarEnderecoCep("06310310", 1)){
            System.out.println("Endereco mudança cep funciona");
        }else{
            System.out.println("Endereco mudanca cep não funciona");
        }

        if(endereco.alterarEnderecoRua("Antonio dos Santos Neto", 1)){
            System.out.println("Endereco mudança rua funciona");
        }else{
            System.out.println("Endereco mudanca rua não funciona");
        }

        if(endereco.alterarEnderecoNumero(183, 1)){
            System.out.println("Endereco mudança numero funciona");
        }else{
            System.out.println("Endereco mudanca numero não funciona");
        }
    }
}
