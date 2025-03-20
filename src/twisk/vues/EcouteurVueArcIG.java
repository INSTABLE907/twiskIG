package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;

public class EcouteurVueArcIG implements EventHandler<MouseEvent> {
    private MondeIG mondeIG;
    private ArcIG arc;

    public EcouteurVueArcIG(MondeIG m, ArcIG a){
      this.mondeIG=m;
      this.arc=a;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("Élément : ArcIG est sélectionné");
        if(this.arc.isEstSelec()){
            this.arc.setEstSelec(false);
        }
        else{
            this.arc.setEstSelec(true);
        }
    }
}
