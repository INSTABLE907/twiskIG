package twisk.vues;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class VuePointDeControleIG extends Circle implements Observateur {
    private MondeIG m;
    private PointDeControleIG p;
    public VuePointDeControleIG(MondeIG monde, PointDeControleIG p){
        super();
        this.m=monde;
        this.p=p;
        this.setCenterX(this.p.getPosCentreX());
        this.setCenterY(this.p.getPosCentreY());
        this.setFill(Color.RED);
        this.setRadius(5);
        EcouteurVuePtDeControle e = new EcouteurVuePtDeControle(p,this.m);
        this.setOnMouseClicked(e);
    }
    @Override
    public void reagir() {
    }
}
