package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurItemEntree implements EventHandler<ActionEvent> {
    private MondeIG mondeIG;

    public EcouteurItemEntree(MondeIG m) {
        this.mondeIG=m;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.mondeIG.defUneEntree();
        this.mondeIG.notifierObservateurs();
    }
}
