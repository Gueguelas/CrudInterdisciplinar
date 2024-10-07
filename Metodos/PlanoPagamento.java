public class PlanoPagamento {
    private String cDescricao;
    private String cNome;
    private double fValor;
    private boolean bis_inactive;
    private boolean bis_updated;
    private boolean btransaction_made;

    public PlanoPagamento(String cDescricao, String cNome, double fValor, boolean bis_inactive, boolean bis_updated, boolean btransaction_made) {
        this.cDescricao = cDescricao;
        this.cNome = cNome;
        this.fValor = fValor;
        this.bis_inactive = bis_inactive;
        this.bis_updated = bis_updated;
        this.btransaction_made = btransaction_made;
    }

    public String getcDescricao() {
        return cDescricao;
    }

    public void setcDescricao(String cDescricao) {
        this.cDescricao = cDescricao;
    }

    public String getcNome() {
        return cNome;
    }

    public void setcNome(String cNome) {
        this.cNome = cNome;
    }

    public double getfValor() {
        return fValor;
    }

    public void setfValor(double fValor) {
        this.fValor = fValor;
    }

    public boolean isBis_inactive() {
        return bis_inactive;
    }

    public void setBis_inactive(boolean bis_inactive) {
        this.bis_inactive = bis_inactive;
    }

    public boolean isBis_updated() {
        return bis_updated;
    }

    public void setBis_updated(boolean bis_updated) {
        this.bis_updated = bis_updated;
    }

    public boolean isBtransaction_made() {
        return btransaction_made;
    }

    public void setBtransaction_made(boolean btransaction_made) {
        this.btransaction_made = btransaction_made;
    }

    @Override
    public String toString() {
        return "PlanoPagamento{" +
                "Descricao='" + cDescricao + '\'' +
                "Nome='" + cNome + '\'' +
                "Valor=" + fValor +
                "Is_inactive=" + bis_inactive +
                "Is_updated=" + bis_updated +
                "Transaction_made=" + btransaction_made +
                '}';
    }
}

