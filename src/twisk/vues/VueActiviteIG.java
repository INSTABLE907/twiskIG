package twisk.vues;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class VueActiviteIG extends VueEtapeIG implements Observateur{

    private HBox hb;
    private Image imgEntre;
    private Image imgSortie;

    public VueActiviteIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);

        TailleComposant tc = TailleComposant.getInstance();

        this.hb = new HBox();
        this.hb.setStyle("-fx-border-color: #0059FF; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px;");

        if(!etape.EstSelectionner()){
            this.setStyle("-fx-padding: 3px;-fx-border-color: black;-fx-border-width:5;-fx-border-height:5;");
        }else{
            this.setStyle("-fx-padding: 3px;-fx-border-color: yellow;-fx-border-width:5;-fx-border-height:5;");
        }

        if(etape.EstUneEntree()){
            this.imgEntre = new Image(getClass().getResourceAsStream("/images/entree.png"), 16, 16, false, true);
            ImageView iv = new ImageView(this.imgEntre);
            getChildren().add(iv);
        }
        if(etape.EstUneSortie()){
            this.imgSortie = new Image(getClass().getResourceAsStream("/images/sortie.png"), 16, 16, false, true);
            ImageView iv2 = new ImageView(this.imgSortie);
            getChildren().add(iv2);
        }
        this.setMaxWidth(tc.getLargeur());
        this.setMinWidth(tc.getLargeur());
        this.setMaxHeight(tc.getHauteur());
        this.setMinHeight(tc.getHauteur());

        this.hb.setMaxWidth(tc.getLargeur()-15);
        this.hb.setMinWidth(tc.getLargeur()-20);
        this.hb.setMaxHeight(tc.getHauteur());
        this.hb.setMinHeight(tc.getHauteur()-50);

        EcouteurVueActiviteIG eva = new EcouteurVueActiviteIG(monde,etape);
        this.setOnMouseClicked(eva);
        getChildren().add(this.hb);
    }
    @Override
    public void reagir() {
    }
}
