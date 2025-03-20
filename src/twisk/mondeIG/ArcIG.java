package twisk.mondeIG;

public class ArcIG {
    private PointDeControleIG p1;
    private PointDeControleIG p2;
    private boolean estSelec;
    public ArcIG(PointDeControleIG p1, PointDeControleIG p2){
        this.p1=p1;
        this.p2=p2;
        this.estSelec=false;
    }
    public PointDeControleIG getP1() {
        return this.p1;
    }

    public PointDeControleIG getP2() {
        return this.p2;
    }

    public boolean isEstSelec() {return this.estSelec;}

    public void setEstSelec(boolean estSelec) {this.estSelec = estSelec;}
}
