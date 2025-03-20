package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;

import twisk.exceptions.TwiskException;
import twisk.mondeIG.MondeIG;

public class EcouteurItemEcartTemps implements EventHandler<ActionEvent> {
    private MondeIG mondeIG;

    public EcouteurItemEcartTemps(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog tid = new TextInputDialog("1");
        tid.setTitle("Configuration - écart-temps");
        tid.setHeaderText("PARAMÈTRE := nb > 0 et nb < délai");
        tid.showAndWait();
        int tmpEcart = Integer.parseInt(tid.getEditor().getText());

        try {
            this.mondeIG.setEcartTemps(tmpEcart);
        }catch(TwiskException e){
            System.out.println(e.getMessage());
            e.afficherEcartTempsIncorrect();
        }
        this.mondeIG.notifierObservateurs();
    }
}
