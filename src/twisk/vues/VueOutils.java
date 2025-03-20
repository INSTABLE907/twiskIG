package twisk.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.TilePane;
import twisk.mondeIG.MondeIG;

public class VueOutils extends TilePane implements Observateur{
    private MondeIG m;
    public VueOutils(MondeIG monde) {
        super();
        this.m=monde;
        this.m.ajouterObservateur(this);
        TailleComposant tc = TailleComposant.getInstance();
        Button buttonAjouter = new Button("+");
        buttonAjouter.setPrefSize(tc.getBtntaille(),tc.getBtntaille());
        this.setStyle("-fx-background-color: gray");
        Tooltip tooltip = new Tooltip();
        tooltip.setText("Ajouter une activité");
        buttonAjouter.setTooltip(tooltip);
        EcouteurBouton eb = new EcouteurBouton(monde);
        buttonAjouter.setOnAction(eb);
        this.getChildren().add(buttonAjouter);
    }
    @Override
    public void reagir(){
    }
}
