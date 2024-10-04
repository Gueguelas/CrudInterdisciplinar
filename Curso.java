public class Curso {
    private String cCategoria;
    private String cNome;
    private double fValor;
    private boolean bis_inactive;
    private boolean bis_updated;
    private String cDescricao;
    private boolean bStatus;
    private int iNumeroInscricao;
    private String cDuracao;
    private boolean btransaction_made;

    public Curso(String cCategoria, String cNome, double fValor, boolean bis_inactive, boolean bis_updated, String cDescricao, boolean bStatus, int iNumeroInscricao, String cDuracao, boolean btransaction_made) {
        this.cCategoria = cCategoria;
        this.cNome = cNome;
        this.fValor = fValor;
        this.bis_inactive = bis_inactive;
        this.bis_updated = bis_updated;
        this.cDescricao = cDescricao;
        this.bStatus = bStatus;
        this.iNumeroInscricao = iNumeroInscricao;
        this.cDuracao = cDuracao;
        this.btransaction_made = btransaction_made;
    }

    public String getcCategoria() {
        return cCategoria;
    }

    public void setcCategoria(String cCategoria) {
        this.cCategoria = cCategoria;
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

    public String getcDescricao() {
        return cDescricao;
    }

    public void setcDescricao(String cDescricao) {
        this.cDescricao = cDescricao;
    }

    public boolean isbStatus() {
        return bStatus;
    }

    public void setbStatus(boolean bStatus) {
        this.bStatus = bStatus;
    }

    public int getiNumeroInscricao() {
        return iNumeroInscricao;
    }

    public void setiNumeroInscricao(int iNumeroInscricao) {
        this.iNumeroInscricao = iNumeroInscricao;
    }

    public String getcDuracao() {
        return cDuracao;
    }

    public void setcDuracao(String cDuracao) {
        this.cDuracao = cDuracao;
    }

    public boolean isBtransaction_made() {
        return btransaction_made;
    }

    public void setBtransaction_made(boolean btransaction_made) {
        this.btransaction_made = btransaction_made;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "Categoria='" + cCategoria + '\'' +
                "Nome='" + cNome + '\'' +
                "Valor=" + fValor +
                "Is_inactive=" + bis_inactive +
                "Is_updated=" + bis_updated +
                "Descricao='" + cDescricao + '\'' +
                "Status=" + bStatus +
                "NumeroInscricao=" + iNumeroInscricao +
                "Duracao='" + cDuracao + '\'' +
                "Transaction_made=" + btransaction_made +
                '}';
    }
}
