package twisk.mondeIG;

import twisk.vues.TailleComposant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public abstract class EtapeIG implements Iterable<PointDeControleIG>{
    private String nom;
    private String identifiant;

    private int posX;
    private int posY;
    private int largeur;
    private int hauteur;

    private int delaiEtape;
    private int ecartTempsEtape;

    private ArrayList<PointDeControleIG> pdc;

    private boolean estSelectionner;
    private boolean estUneEntree;
    private boolean estUneSortie;

    public EtapeIG(String nom, int larg, int haut,String id){
        this.estSelectionner=false;
        this.estUneEntree=false;
        this.estUneSortie=false;
        this.delaiEtape=2;
        this.ecartTempsEtape=1;
        this.nom=nom;
        this.largeur=larg;
        this.hauteur=haut;
        this.identifiant=id;
        this.posX=aleatoirePosX();
        this.posY=aleatoirePosY();
        this.pdc=new ArrayList<>();
        initialisationPdc();
    }

    public int aleatoirePosX(){
        Random rand = new Random();
        return rand.nextInt(800-getLargeur());
    }
    public int aleatoirePosY(){
        Random rand = new Random();
        return rand.nextInt(600-getHauteur()-50);
    }
    public void initialisationPdc(){
        TailleComposant t = TailleComposant.getInstance();
        PointDeControleIG p1,p2,p3,p4;
        p1 = new PointDeControleIG(this.posX+(t.getLargeur()/2),this.posY,this.identifiant+"A",this);
        p2 = new PointDeControleIG(this.posX+t.getLargeur(),this.posY+(t.getHauteur()/2),this.identifiant+"AA",this);
        p3 = new PointDeControleIG(this.posX+(t.getLargeur()/2),this.posY+t.getHauteur(),this.identifiant+"AAA",this);
        p4 = new PointDeControleIG(this.posX,this.posY+(t.getHauteur()/2),this.identifiant+"AAAA",this);
        this.pdc.add(p1);
        this.pdc.add(p2);
        this.pdc.add(p3);
        this.pdc.add(p4);
    }

    public void miseAJourPdc(){
        TailleComposant t = TailleComposant.getInstance();
        PointDeControleIG p1 = this.pdc.get(0);
        p1.setPosCentreX(this.posX+(t.getLargeur()/2));
        p1.setPosCentreY(this.posY);
        PointDeControleIG p2 = this.pdc.get(1);
        p2.setPosCentreX(this.posX+t.getLargeur());
        p2.setPosCentreY(this.posY+(t.getHauteur()/2));
        PointDeControleIG p3 = this.pdc.get(2);
        p3.setPosCentreY(this.posY+t.getHauteur());
        p3.setPosCentreX(this.posX+(t.getLargeur()/2));
        PointDeControleIG p4 = this.pdc.get(3);
        p4.setPosCentreX(this.posX);
        p4.setPosCentreY(this.posY+(t.getHauteur()/2));
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    public int getPosX() {
        return posX;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public int getPosY() {
        return this.posY;
    }
    public void setXY(int x, int y){
        this.setPosY(y);
        this.setPosX(x);
        this.miseAJourPdc();
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public int getLargeur() {
        return largeur;
    }
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
    public int getHauteur() {
        return hauteur;
    }
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
    public boolean EstSelectionner() {
        return this.estSelectionner;
    }
    public void setEstSelectionner(boolean estSelectionner) {
        this.estSelectionner = estSelectionner;
    }
    public boolean EstUneSortie() {
        return this.estUneSortie;
    }
    public void setEstUneSortie(boolean estUneSortie) {
        this.estUneSortie = estUneSortie;
    }
    public boolean EstUneEntree() {
        return this.estUneEntree;
    }
    public void setEstUneEntree(boolean estUneEntree) {
        this.estUneEntree = estUneEntree;
    }
    public int getEcartTempsEtape() {
        return this.ecartTempsEtape;
    }

    public void setEcartTempsEtape(int ecartTempsEtape) {
        this.ecartTempsEtape = ecartTempsEtape;
    }

    public int getDelaiEtape() {
        return this.delaiEtape;
    }

    public void setDelaiEtape(int delaiEtape) {
        this.delaiEtape = delaiEtape;
    }

    @Override
    public Iterator<PointDeControleIG> iterator(){
        return this.pdc.iterator();
    }
}
