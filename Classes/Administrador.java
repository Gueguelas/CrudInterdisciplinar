package Classes;

public class Administrador {
    private String cNome;
    private String cEmail;
    private String cSenha;

    public Administrador(String cNome, String cEmail, String cSenha) {
        this.cNome = cNome;
        this.cEmail = cEmail;
        this.cSenha = cSenha;
    }

    public String getcNome() {
        return cNome;
    }

    public void setcNome(String cNome) {
        this.cNome = cNome;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "Nome='" + this.cNome + '\'' +
                "Email='" + this.cEmail + '}';
    }
}
