package Modelos;

public class Midia {
    private String cURLVideo;
    private String cURLFoto;

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

    public Midia(String cURLVideo, String cURLFoto) {
        this.cURLVideo = cURLVideo;
        this.cURLFoto = cURLFoto;
    }
}
