package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.MondeIG;

public class EcouteurItemRenommer implements EventHandler<ActionEvent> {
    private MondeIG monde;
    public EcouteurItemRenommer(MondeIG m){
        this.monde=m;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog tid = new TextInputDialog("nouveau nom");
        tid.setHeaderText("ENTRE UN NOUVEAU NOM");
        tid.showAndWait();
        String textinput = tid.getEditor().getText();
        if(!textinput.equals("nouveau nom")) {
            this.monde.renommerEtape(textinput);
        }
        this.monde.notifierObservateurs();
    }
}
