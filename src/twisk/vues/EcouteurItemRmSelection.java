package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurItemRmSelection implements EventHandler<ActionEvent> {
    private MondeIG monde;

    public EcouteurItemRmSelection(MondeIG m){
        this.monde=m;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.monde.effacerSelection();
        this.monde.notifierObservateurs();
    }
}
