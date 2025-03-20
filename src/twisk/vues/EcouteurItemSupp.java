package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurItemSupp implements EventHandler<ActionEvent> {
    private MondeIG monde;
    public EcouteurItemSupp(MondeIG m){
        this.monde=m;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.monde.supprimerEtape();
        this.monde.supprimerArc();
        this.monde.notifierObservateurs();
    }
}
