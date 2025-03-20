package twisk.mondeIG;

public class PointDeControleIG {

    private String idpdc;
    private int posCentreX;
    private int posCentreY;
    private EtapeIG etapeRattachement;

    public PointDeControleIG(int posCentreX,int posCentreY,String identifiant,EtapeIG etapeRattache){
        this.idpdc=identifiant;
        this.posCentreX=posCentreX;
        this.posCentreY=posCentreY;
        this.etapeRattachement=etapeRattache;
    }
    public String getIdpdc() {
        return this.idpdc;
    }

    public void setIdpdc(String idpdc) {
        this.idpdc = idpdc;
    }

    public int getPosCentreX() {
        return this.posCentreX;
    }

    public void setPosCentreX(int posCentreX) {
        this.posCentreX = posCentreX;
    }

    public int getPosCentreY() {
        return this.posCentreY;
    }

    public void setPosCentreY(int posCentreY) {
        this.posCentreY = posCentreY;
    }

    public EtapeIG getEtapeRattachement() {
        return this.etapeRattachement;
    }

    public void setEtapeRattachement(EtapeIG etapeRattachement) {
        this.etapeRattachement = etapeRattachement;
    }
}
