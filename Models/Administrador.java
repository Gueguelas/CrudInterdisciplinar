package Models;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Administrador {
    // Atributos do administrador
    private int sId;        // ID do administrador
    private String cNome;   // Nome do administrador
    private String cEmail;  // Email do administrador
    private String cSenha;  // Senha do administrador

    // Construtor para inicializar os atributos
    public Administrador(String cNome, String cEmail, String cSenha) { // construtor para cadastro
        this.cNome = cNome;
        this.cEmail = cEmail;
        this.cSenha = cSenha;
    }

    public Administrador(int sId) {
        this.sId = sId;
    } // construtor para remoção

    public Administrador(int sId, String cNome, String cEmail, String cSenha) { // construtor para alteração
        this.sId = sId;
        if (cNome != null && !cNome.isEmpty()) {
            this.cNome = cNome;
        }
        if (cEmail != null && !cEmail.isEmpty()) {
            this.cEmail = cEmail;
        }
        if (cSenha != null && !cSenha.isEmpty()) {
            this.cSenha = cSenha;
        }
    }

    public String getcSenha(){
        return this.cSenha;
    }

    public int getsId() {
        return sId;
    }

    // Getter para o nome
    public String getcNome() {
        return cNome; // Retorna o nome do administrador
    }

    // Setter para o nome
    public void setcNome(String cNome) {
        this.cNome = cNome; // Atualiza o nome do administrador
    }

    // Getter para o email
    public String getcEmail() {
        return cEmail; // Retorna o email do administrador
    }

    // Setter para o email
    public void setcEmail(String cEmail) {
        this.cEmail = cEmail; // Atualiza o email do administrador
    }

    // Sobrescrita do método toString para exibir informações do administrador
    public String toString() {
        return "Administrador{" +
                "Nome='" + this.cNome + '\'' +
                ", Email='" + this.cEmail + '\'' +
                '}';
    }

    //Metodo com regex para verificar email;
    public static boolean verificarEmail(String email){
        String regexEmail = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2}$";
        try{
            // Cria um objeto Pattern compilando o padrão
            Pattern pattern = Pattern.compile(regexEmail);
            // Cria um objeto Matcher chamando o metodo matcher no objeto Pattern, passando a string de email de entrada
            Matcher verificacao = pattern.matcher(email);
            if(verificacao.matches()){
                return true;
            }else{
                return false;
            }
        }catch(InputMismatchException ime){
            ime.printStackTrace();
            return false;
        }
    }

    //Metodo com regex para verificar senha;
    public static boolean verificarSenha(String senha){
        String regexSenha = "^(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\n";
        try{
            // Cria um objeto Pattern compilando o padrão
            Pattern pattern = Pattern.compile(regexSenha);
            // Cria um objeto Matcher chamando o método matcher no objeto Pattern, passando a string de email de entrada
            Matcher verificacao = pattern.matcher(senha);
            if(verificacao.matches()){
                return true;
            }else{
                return false;
            }
        }catch(InputMismatchException ime){
            ime.printStackTrace();
            return false;
        }
    }

    public String criptografarSenha(String senha) {
        StringBuilder senhaCriptografada = new StringBuilder();
        String alfabetoMinusculo = "abcdefghijklmnopqrstuvwxyz";
        String alfabetoMaiusculo = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String chaveSt = System.getenv("CHAVE_CRIPTOGRAFIA");
        int chave = Integer.getInteger(chaveSt);

        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            if (Character.isLowerCase(caractere)) {
                int novaPosicao = (alfabetoMinusculo.indexOf(caractere) + chave) % alfabetoMinusculo.length();
                char novaLetra = alfabetoMinusculo.charAt(novaPosicao);
                senhaCriptografada.append(novaLetra);
            } else if (Character.isUpperCase(caractere)) {
                int novaPosicao = (alfabetoMaiusculo.indexOf(caractere) + chave) % alfabetoMaiusculo.length();
                char novaLetra = alfabetoMaiusculo.charAt(novaPosicao);
                senhaCriptografada.append(novaLetra);
            } else if (Character.isDigit(caractere)) {
                int novoDigito = (Character.getNumericValue(caractere) + chave) % 10; // Limita a 0-9
                senhaCriptografada.append(novoDigito);
            } else {
                senhaCriptografada.append(caractere); // Mantém caracteres não alfabéticos e não numéricos
            }
        }

        return senhaCriptografada.toString();
    }

}
