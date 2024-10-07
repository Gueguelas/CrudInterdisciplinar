package Metodos;

public class CategoriaProduto {
    private String cNome;
    private boolean bis_inactive;
    private boolean bis_updated;
    private boolean btransaction_made;

    public CategoriaProduto(String cNome, boolean bis_inactive, boolean bis_updated, boolean btransaction_made) {
        this.cNome = cNome;
        this.bis_inactive = bis_inactive;
        this.bis_updated = bis_updated;
        this.btransaction_made = btransaction_made;
    }

    public String getcNome() {
        return cNome;
    }

    public void setcNome(String cNome) {
        this.cNome = cNome;
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
        return "CategoriaProduto{" +
                "Nome='" + cNome + '\'' +
                "Is_inactive=" + bis_inactive +
                "Is_updated=" + bis_updated +
                "Transaction_made=" + btransaction_made +
                '}';
    }
}
