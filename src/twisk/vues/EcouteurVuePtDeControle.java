package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.exceptions.TwiskException;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurVuePtDeControle implements EventHandler<MouseEvent> {
    private PointDeControleIG pt;
    private MondeIG m;
    public EcouteurVuePtDeControle(PointDeControleIG p, MondeIG m){
        this.pt=p;
        this.m=m;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("point de contrôle sélectionné: x=" + pt.getPosCentreX() + ", y=" + pt.getPosCentreY());
        this.m.getP().add(this.pt);
        if (this.m.getP().size() == 2) {
            try {
                this.m.ajouter(this.m.getP().get(0), this.m.getP().get(1));
            }catch (TwiskException e){
                if(e.getMessage().equals("Erreur cycle")){
                    System.out.println("TwiskException := "+e.getMessage());
                    e.afficherAlerteBoucle();
                }
                if(e.getMessage().equals("Erreur même étape")){
                    System.out.println("TwiskException := "+e.getMessage());
                    e.afficherMemeEtape();
                }
                if(e.getMessage().equals("Erreur création chemin existant")){
                    System.out.println("TwiskException := "+e.getMessage());
                    e.afficherCheminDejaExistant();
                }
            }
            this.m.getP().clear();
        }
        this.m.notifierObservateurs();
    }
}
