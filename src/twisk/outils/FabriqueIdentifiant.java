package twisk.outils;

public class FabriqueIdentifiant {
    private int noEtape;
    private static FabriqueIdentifiant instance = new FabriqueIdentifiant();
    private FabriqueIdentifiant(){
        this.noEtape=0;
    }
    public static FabriqueIdentifiant getInstance(){
        return instance;
    }
    public String getidentifiantEtape(){
        return Integer.toString(this.noEtape++);
    }
    public void reset(){
        this.noEtape=0;
    }
}
