package twisk.vues;

import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;

public class VueArcIG extends Group implements Observateur{
    private Line line;
    private Polyline polyline;
    private MondeIG monde;
    private ArcIG arcIG;

    public VueArcIG(MondeIG m,ArcIG a){
        super();
        this.monde=m;
        this.monde.ajouterObservateur(this);
        this.arcIG=a;
        this.line = new Line(x1(), y1(), x2(), y2());
        this.polyline = creerFleche(x1(),y1(),x2(),y2());
        this.line.setStrokeWidth(5);
        this.polyline.setStrokeWidth(6);
        EcouteurVueArcIG e = new EcouteurVueArcIG(this.monde,this.arcIG);
        this.setOnMouseClicked(e);
        getChildren().add(this.line);
        getChildren().add(this.polyline);
    }

    private Polyline creerFleche(double x1, double y1, double x2, double y2) {
        Polyline fleche = new Polyline();
        double longeur = 12;
        double angle = Math.atan2(y2 - y1, x2 - x1);
        double x = x2;
        double y = y2;
        double angle1 = angle - Math.toRadians(40);
        double angle2 = angle + Math.toRadians(40);
        double xArrowPoint1 = x - longeur * Math.cos(angle1);
        double yArrowPoint1 = y - longeur * Math.sin(angle1);
        double xArrowPoint2 = x - longeur * Math.cos(angle2);
        double yArrowPoint2 = y - longeur * Math.sin(angle2);
        fleche.getPoints().addAll(new Double[]{
                x, y,
                xArrowPoint1, yArrowPoint1,
                x, y,
                xArrowPoint2, yArrowPoint2
        });
        return fleche;
    }
    public int x1(){
        return this.arcIG.getP1().getPosCentreX();
    }
    public int x2(){
        return this.arcIG.getP2().getPosCentreX();
    }
    public int y1(){
        return this.arcIG.getP1().getPosCentreY();
    }
    public int y2(){
        return this.arcIG.getP2().getPosCentreY();
    }

    private void miseAjourPosition() {
        this.line.setStartX(x1());
        this.line.setStartY(y1());
        this.line.setEndX(x2());
        this.line.setEndY(y2());
    }
    @Override
    public void reagir() {
        this.miseAjourPosition();
    }
}
