package twisk.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class TwiskException extends Exception {
    Alert alertBoucle;
    Alert alertEtape;
    Alert alertTemps;

    public TwiskException(String s){
        super(s);
        this.alertBoucle=new Alert(Alert.AlertType.WARNING);
        this.alertEtape=new Alert(Alert.AlertType.WARNING);
        this.alertTemps=new Alert(Alert.AlertType.WARNING);
    }

    public void afficherAlerteBoucle() {
        PauseTransition pt = new PauseTransition(Duration.millis(3000));
        pt.setOnFinished(e -> this.alertBoucle.close());
        this.alertBoucle.setTitle("ATTENTION");
        this.alertBoucle.setHeaderText("Arc non valide : Pdc1 == Pdc2");
        pt.play();
        this.alertBoucle.showAndWait();
    }

    public void afficherMemeEtape(){
        PauseTransition pt2 = new PauseTransition(Duration.millis(3000));
        pt2.setOnFinished(e -> this.alertEtape.close());
        this.alertEtape.setTitle("ATTENTION");
        this.alertEtape.setHeaderText("Arc non-valide : Arc Étape vers la même Étape");
        pt2.play();
        this.alertEtape.showAndWait();
    }

    public void afficherCheminDejaExistant(){
        PauseTransition pt3 = new PauseTransition(Duration.millis(3000));
        pt3.setOnFinished(e -> this.alertEtape.close());
        this.alertEtape.setTitle("ATTENTION");
        this.alertEtape.setHeaderText("Creation impossible : Un Arc réalisant la même liaison est déjà présent");
        pt3.play();
        this.alertEtape.showAndWait();
    }

    public void afficherDelaiIncorrect(){
        PauseTransition pt4 = new PauseTransition(Duration.millis(3000));
        pt4.setOnFinished(e -> this.alertTemps.close());
        this.alertTemps.setTitle("ATTENTION");
        this.alertTemps.setHeaderText("ERREUR := nb > 0");
        pt4.play();
        this.alertTemps.showAndWait();
    }

    public void afficherEcartTempsIncorrect(){
        PauseTransition pt5 = new PauseTransition(Duration.millis(3000));
        pt5.setOnFinished(e -> this.alertTemps.close());
        this.alertTemps.setTitle("ATTENTION");
        this.alertTemps.setHeaderText("ERREUR := 0 < nb < délai");
        pt5.play();
        this.alertTemps.showAndWait();
    }
}
