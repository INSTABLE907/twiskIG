package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;

import twisk.exceptions.TwiskException;
import twisk.mondeIG.MondeIG;

public class EcouteurItemDelai implements EventHandler<ActionEvent> {

    private MondeIG mondeIG;

    public EcouteurItemDelai(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog tid = new TextInputDialog("2");
        tid.setTitle("Configuration - délai");
        tid.setHeaderText("PARAMÈTRE := nb > 0");
        tid.showAndWait();
        int tmp = Integer.parseInt(tid.getEditor().getText());
        try {
            this.mondeIG.setDelai(tmp);
        }catch (TwiskException e){
            System.out.println(e.getMessage());
            e.afficherDelaiIncorrect();
        }
        this.mondeIG.notifierObservateurs();
    }
}
