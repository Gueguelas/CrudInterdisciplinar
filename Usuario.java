import java.sql.Date;

public class Usuario {
    private String email;
    private String telefone;
    private Date dataNascimento;
    private String nome;
    private String linkLinkedin;
    private Date dataCriacao;
    private String senha;
    private String cnpj;
    private String cpf;

    public Usuario(String email, String telefone, Date dataNascimento, String nome, String linkLinkedin, Date dataCriacao, String senha, String cnpj, String cpf) {
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
        this.linkLinkedin = linkLinkedin;
        this.dataCriacao = dataCriacao;
        this.senha = senha;
        this.cnpj = cnpj;
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getLinkLinkedin() {
        return linkLinkedin;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public String getSenha() {
        return senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCpf() {
        return cpf;
    }
}
