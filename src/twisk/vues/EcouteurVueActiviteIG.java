package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurVueActiviteIG implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private EtapeIG etapeIG;

    public EcouteurVueActiviteIG(MondeIG m,EtapeIG e){
        this.monde=m;
        this.etapeIG=e;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(!this.etapeIG.EstSelectionner()){
            this.etapeIG.setEstSelectionner(true);
        }else{
            this.etapeIG.setEstSelectionner(false);
        }
        this.monde.notifierObservateurs();
    }
}
