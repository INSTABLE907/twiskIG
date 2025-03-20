package twisk.mondeIG;
import twisk.vues.Observateur;

import java.util.ArrayList;

public class SujetObserve {
    private ArrayList<Observateur> observateurArrayList;
    public SujetObserve(){
        this.observateurArrayList = new ArrayList<Observateur>();
    }
    /**
     * Méthode pour ajouter des observateurs
     * @param o
     */
    public void ajouterObservateur(Observateur o){
        this.observateurArrayList.add(o);
    }
    /**
     * Méthode pour notifier les observateurs. (appelle la méthode réagir() des classes filles)
     */
    public void notifierObservateurs(){
        //Cette copie est utilisé pour éviter les erreurs.
        ArrayList<Observateur> copieObservateurs = new ArrayList<>(observateurArrayList);
        for(Observateur o : copieObservateurs){
            o.reagir();
        }
    }
}
