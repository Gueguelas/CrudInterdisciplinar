package Modelos;

public class MidiaCurso {
    private int sId;
    private String cURLVideo;
    private String cURLFoto;
    private boolean btransaction_made;
    private boolean bisInactive;
    private boolean bisUpdates;

    public String getcURLVideo() {
        return cURLVideo;
    }

    public void setcURLVideo(String cURLVideo) {
        this.cURLVideo = cURLVideo;
    }

    public String getcURLFoto() {
        return cURLFoto;
    }

    public void setcURLFoto(String cURLFoto) {
        this.cURLFoto = cURLFoto;
    }

    public boolean isBtransaction_made() {
        return btransaction_made;
    }

    public void setBtransaction_made(boolean btransaction_made) {
        this.btransaction_made = btransaction_made;
    }

    public boolean isBisInactive() {
        return bisInactive;
    }

    public void setBisInactive(boolean bisInactive) {
        this.bisInactive = bisInactive;
    }

    public boolean isBisUpdates() {
        return bisUpdates;
    }

    public void setBisUpdates(boolean bisUpdates) {
        this.bisUpdates = bisUpdates;
    }

    public int getsId() {
        return sId;
    }

    public MidiaCurso(String cURLVideo, String cURLFoto, boolean btransaction_made, boolean bisInactive, boolean bisUpdates) {
        this.cURLVideo = cURLVideo;
        this.cURLFoto = cURLFoto;
        this.btransaction_made = btransaction_made;
        this.bisInactive = bisInactive;
        this.bisUpdates = bisUpdates;
    }

    @Override
    public String toString() {
        return "MidiaCurso{" +
                "cURLVideo='" + this.cURLVideo + '\'' +
                ", cURLFoto='" + this.cURLFoto + '\'' +
                ", btransaction_made=" + this.btransaction_made +
                ", bisInactive=" + this.bisInactive +
                ", bisUpdates=" + this.bisUpdates +
                '}';
    }
}