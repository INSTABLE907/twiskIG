package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurItemSortie implements EventHandler<ActionEvent> {

    private MondeIG mondeIG;

    public EcouteurItemSortie(MondeIG m) {
        this.mondeIG=m;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.mondeIG.defUneSortie();
        this.mondeIG.notifierObservateurs();
    }
}
