package Modelos;

import java.util.Date;

public class Produto {
    private double fValor;
    private String cDescricao;
    private Date dDataCriacao;
    private String cNome;
    private String cCategoria;
    private String cEstado;

    public double getfValor() {
        return fValor;
    }

    public void setfValor(double fValor) {
        this.fValor = fValor;
    }

    public String getcDescricao() {
        return cDescricao;
    }

    public void setcDescricao(String cDescricao) {
        this.cDescricao = cDescricao;
    }

    public Date getdDataCriacao() {
        return dDataCriacao;
    }

    public void setdDataCriacao(Date dDataCriacao) {
        this.dDataCriacao = dDataCriacao;
    }

    public String getcNome() {
        return cNome;
    }

    public void setcNome(String cNome) {
        this.cNome = cNome;
    }

    public String getcCategoria() {
        return cCategoria;
    }

    public void setcCategoria(String cCategoria) {
        this.cCategoria = cCategoria;
    }

    public String getcEstado() {
        return cEstado;
    }

    public void setcEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "fValor=" + this.fValor +
                ", cDescricao='" + this.cDescricao + '\'' +
                ", dDataCriacao=" + this.dDataCriacao +
                ", cNome='" + this.cNome + '\'' +
                ", cCategoria='" + this.cCategoria + '\'' +
                ", cEstado='" + this.cEstado + '\'' +
                '}';
    }
}
