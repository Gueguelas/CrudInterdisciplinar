package Modelos;

public class CategoriaCurso {
    private boolean bis_updated;
    private boolean btransaction_made;
    private boolean bis_inactive;
    private String cNome;

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

    public boolean isBis_inactive() {
        return bis_inactive;
    }

    public void setBis_inactive(boolean bis_inactive) {
        this.bis_inactive = bis_inactive;
    }

    public String getcNome() {
        return cNome;
    }

    public void setcNome(String cNome) {
        this.cNome = cNome;
    }

    @Override
    public String toString() {
        return "CategoriaCurso{" +
                "bis_updated=" + this.bis_updated +
                ", btransaction_made=" + this.btransaction_made +
                ", bis_inactive=" + this.bis_inactive +
                ", cNome='" + this.cNome + '\'' +
                '}';
    }
}
