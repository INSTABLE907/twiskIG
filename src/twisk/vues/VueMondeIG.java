package twisk.vues;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import twisk.mondeIG.*;

public class VueMondeIG extends Pane implements Observateur {
    MondeIG m;
    public VueMondeIG(MondeIG monde){
        super();
        this.m=monde;
        this.m.ajouterObservateur(this);
        this.ajouterVue();
        //Drag And Drop drop setOnDragOver et setOnDragDropped
        this.setOnDragOver(dragEvent -> {
            final Dragboard dragBroard = dragEvent.getDragboard();
            if (dragBroard.hasString()) {
                dragEvent.acceptTransferModes(TransferMode.MOVE);
            }
            dragEvent.consume();
        });

        this.setOnDragDropped(dragEvent -> {
                Dragboard dragboard = dragEvent.getDragboard();
                boolean success = false;
                if (dragboard.hasString()) {
                    String nodeid = dragboard.getString();
                    VueEtapeIG vueE = (VueEtapeIG) this.lookup("#" + nodeid);
                    if (vueE != null) {
                        this.m.dragAndDNouveauEmplacement((int)dragEvent.getX(),(int)dragEvent.getY(),nodeid);
                        success = true;
                    }
                }
                this.m.notifierObservateurs();
                dragEvent.setDropCompleted(success);
                dragEvent.consume();
        });
    }

    public void ajouterVue(){
        for(EtapeIG etape : this.m){
            VueEtapeIG view = new VueActiviteIG(this.m,etape);
            getChildren().add(view);
        }
        this.ajouterPdc();
    }
    public void ajouterPdc(){
        for(EtapeIG e : this.m) {
            for (PointDeControleIG p : e) {
                VuePointDeControleIG v = new VuePointDeControleIG(this.m, p);
                getChildren().add(v);
            }
        }
    }
    public void ajouterArc(){
        this.m.streamArcs().forEach(arc -> {
            VueArcIG vueArc = new VueArcIG(this.m, arc);
            getChildren().add(vueArc);
        });
    }
    @Override
    public void reagir() {
        getChildren().clear();
        this.ajouterVue();
        this.ajouterArc();
        this.ajouterPdc();
    }
}
