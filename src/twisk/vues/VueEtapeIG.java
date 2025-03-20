package twisk.vues;

import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public abstract class VueEtapeIG extends VBox implements Observateur {
    private MondeIG m;
    private EtapeIG ei;
    private Label label;

    public VueEtapeIG(MondeIG monde, EtapeIG etape) {
        this.m=monde;
        this.ei=etape;
        String d = String.valueOf(etape.getDelaiEtape());
        String e = String.valueOf(etape.getEcartTempsEtape());
        this.label= new Label(etape.getNom()+" : " + d +"±"+e);
        getChildren().add(label);
        this.relocate(etape.getPosX(),etape.getPosY());
        //Drag And Drop setOnDragDetected
        this.setId(this.ei.getIdentifiant());
        this.setOnDragDetected(mouseEvent -> {
            final Dragboard dragBroard = this.startDragAndDrop(TransferMode.MOVE);
            final ClipboardContent content = new ClipboardContent();
            content.putString(this.ei.getIdentifiant());
            final WritableImage capture = this.snapshot(null, null);
            content.putImage(capture);
            dragBroard.setContent(content);
            mouseEvent.consume();
        });
    }
}
