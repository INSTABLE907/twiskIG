package twisk.vues;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import twisk.mondeIG.MondeIG;

public class VueMenu extends MenuBar implements Observateur{
    private MenuItem quitter;
    private MenuItem supprimmer;
    private MenuItem renommer;
    private MenuItem rmselection;
    private MenuItem entre;
    private MenuItem sortie;
    private MenuItem delai;
    private MenuItem ecart;
    private Menu fichier;
    private Menu edition;
    private Menu menuMonde;
    private Menu parametre;
    private MondeIG monde;

    public VueMenu(MondeIG monde){
        super();
        this.monde = monde;
        this.monde.ajouterObservateur(this);
        creationMenu();
        creationMenuItem();
        this.fichier.getItems().add(this.quitter);
        this.menuMonde.getItems().addAll(this.entre,this.sortie);
        this.edition.getItems().addAll(this.supprimmer,this.renommer,this.rmselection);
        this.parametre.getItems().addAll(this.delai,this.ecart);
    }
    public void creationMenu(){
        this.fichier = new Menu("Fichier");
        this.edition = new Menu("Edition");
        this.menuMonde = new Menu("Monde");
        this.parametre = new Menu("Paramètre");
        this.getMenus().addAll(this.fichier,this.edition,this.menuMonde,this.parametre);
    }

    public void creationMenuItem(){
        this.quitter = new MenuItem("Quitter");
        this.supprimmer = new MenuItem("Supprimer");
        this.renommer = new MenuItem("Renommer");
        this.entre = new MenuItem("Entrée");
        this.sortie = new MenuItem("Sortie");
        this.rmselection = new MenuItem("Effacer la sélection");
        this.delai = new MenuItem("Délai (temps) activité");
        this.ecart = new MenuItem("Ecart (temps) activité");

        this.renommer.setDisable(true);
        this.delai.setDisable(true);
        this.ecart.setDisable(true);

        this.quitter.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));

        this.quitter.setOnAction(e -> Platform.exit());
        EcouteurItemSupp ecouteur = new EcouteurItemSupp(this.monde);
        EcouteurItemRenommer ecouteur2 = new EcouteurItemRenommer(this.monde);
        EcouteurItemRmSelection ecouteur3 = new EcouteurItemRmSelection(this.monde);
        EcouteurItemDelai ecouteur4 = new EcouteurItemDelai(this.monde);
        EcouteurItemEcartTemps ecouteur5 = new EcouteurItemEcartTemps(this.monde);
        EcouteurItemEntree ecouteur6 = new EcouteurItemEntree(this.monde);
        EcouteurItemSortie ecouteur7 = new EcouteurItemSortie(this.monde);
        this.supprimmer.setOnAction(ecouteur);
        this.renommer.setOnAction(ecouteur2);
        this.rmselection.setOnAction(ecouteur3);
        this.delai.setOnAction(ecouteur4);
        this.ecart.setOnAction(ecouteur5);
        this.entre.setOnAction(ecouteur6);
        this.sortie.setOnAction(ecouteur7);
    }

    @Override
    public void reagir() {
        if(this.monde.nbEtapeSelectionne()>1 || this.monde.nbEtapeSelectionne()==0){
            this.renommer.setDisable(true);
            this.ecart.setDisable(true);
            this.delai.setDisable(true);
        }else{
            this.renommer.setDisable(false);
            this.ecart.setDisable(false);
            this.delai.setDisable(false);
        }
    }
}
