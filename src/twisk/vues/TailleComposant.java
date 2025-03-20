package twisk.vues;

public class TailleComposant {
    private int largeur;
    private int hauteur;
    private int btntaille;
    private static final TailleComposant instance = new TailleComposant();
    private TailleComposant(){
        this.largeur=150;
        this.hauteur=120;
        this.btntaille=25;
    }

    public static TailleComposant getInstance(){
        return instance;
    }
    public int getLargeur(){
        return this.largeur;
    }
    public int getHauteur(){
        return this.hauteur;
    }
    public int getBtntaille(){
        return this.btntaille;
    }

}
