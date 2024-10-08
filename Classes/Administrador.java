package Classes;

public class Administrador {
    // Atributos do administrador
    private String cNome;   // Nome do administrador
    private String cEmail;  // Email do administrador
    private String cSenha;  // Senha do administrador

    // Construtor para inicializar os atributos
    public Administrador(String cNome, String cEmail, String cSenha) {
        this.cNome = cNome;
        this.cEmail = cEmail;
        this.cSenha = cSenha; // Considerar criptografar a senha em uma aplicação real
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
}
