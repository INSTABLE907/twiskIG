package twisk.mondeIG;

import twisk.exceptions.TwiskException;
import twisk.outils.FabriqueIdentifiant;
import twisk.vues.TailleComposant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.stream.Stream;

public class MondeIG extends SujetObserve implements Iterable<EtapeIG>{

    private final HashMap<String,EtapeIG> hm;
    private final ArrayList<ArcIG> arcArray;
    private ArrayList<PointDeControleIG> arrayPointDeControleIG;

    public MondeIG() {
        this.hm = new HashMap<>();
        this.arcArray = new ArrayList<>();
        this.arrayPointDeControleIG = new ArrayList<>(2);
        this.ajouter("Activité");
    }

    public void ajouter(String type) {
        FabriqueIdentifiant fi = FabriqueIdentifiant.getInstance();
        String keynoE = fi.getidentifiantEtape();
        TailleComposant tc = TailleComposant.getInstance();
        int composantLargeur = tc.getLargeur();
        int composantHauteur = tc.getHauteur();
        this.hm.put(keynoE,new ActiviteIG(type+" "+keynoE,composantLargeur,composantHauteur,keynoE));
    }
    public boolean memeEtape(){
        PointDeControleIG p1 = this.getP().get(0);
        PointDeControleIG p2 = this.getP().get(1);
        return p1.getEtapeRattachement().equals(p2.getEtapeRattachement());
    }
    public int nbEtapeSelectionne(){
        int k=0;
        Iterator<String> it = this.hm.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (this.hm.get(key).EstSelectionner()) {
                k++;
            }
        }
        return k;
    }

    public void supprimerEtape(){
        Iterator<String> it = this.hm.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (this.hm.get(key).EstSelectionner()) {
                it.remove();
            }
        }
    }
    public void supprimerArc(){
        ArrayList<ArcIG> arcTmp = new ArrayList<>();
        for(ArcIG a : this.arcArray){
            if(a.isEstSelec()){
                arcTmp.add(a);
            }
        }
        for(ArcIG a : arcTmp){
            this.arcArray.remove(a);
        }
    }
    public void effacerSelection(){
        Iterator<String> it = this.hm.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (this.hm.get(key).EstSelectionner()) {
                this.hm.get(key).setEstSelectionner(false);
            }
        }
        for(ArcIG a : this.arcArray){
            if(a.isEstSelec()){
                a.setEstSelec(false);
            }
        }
    }
    public void renommerEtape(String s){
        Iterator<String> it = this.hm.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (this.hm.get(key).EstSelectionner()) {
                this.hm.get(key).setNom(s);
            }
        }
    }

    public void defUneEntree(){
        Iterator<String> it = this.hm.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (this.hm.get(key).EstSelectionner()) {
                if(this.hm.get(key).EstUneEntree()){
                    this.hm.get(key).setEstUneEntree(false);
                }else{
                    this.hm.get(key).setEstUneEntree(true);
                }
            }
        }
    }

    public void defUneSortie(){
        Iterator<String> it = this.hm.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (this.hm.get(key).EstSelectionner()) {
                if(this.hm.get(key).EstUneSortie()){
                    this.hm.get(key).setEstUneSortie(false);
                }else {
                    this.hm.get(key).setEstUneSortie(true);
                }
            }
        }
    }

    public void setDelai(int k) throws TwiskException {
        if(k==0 || k<0){
            throw new TwiskException("Délai incorrect");
        }
        Iterator<String> it = this.hm.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (this.hm.get(key).EstSelectionner()) {
                this.hm.get(key).setDelaiEtape(k);
            }
        }
    }

    public int getDelai(){
        Iterator<String> it = this.hm.keySet().iterator();
        int d = 0;
        while (it.hasNext()) {
            String key = it.next();
            if (this.hm.get(key).EstSelectionner()) {
                 d = this.hm.get(key).getDelaiEtape();
            }
        }
        return d;
    }

    public void setEcartTemps(int k) throws TwiskException {
        int delai = this.getDelai();
        if(k<0 || k > delai || k == 0){
            throw new TwiskException("Écart-Temps incorrect");
        }
        Iterator<String> it = this.hm.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (this.hm.get(key).EstSelectionner()) {
                this.hm.get(key).setEcartTempsEtape(k);
            }
        }
    }

    public EtapeIG getEtapeKey(String id) {
        return this.hm.get(id);
    }
    public void dragAndDNouveauEmplacement(int x, int y, String id) {
        this.getEtapeKey(id).setXY(x,y);
    }
    public Stream<ArcIG> streamArcs(){
        return this.arcArray.stream();
    }

    public void ajouter(PointDeControleIG pt1, PointDeControleIG pt2) throws TwiskException {
            ArcIG tmp = new ArcIG(pt1,pt2);
            if(this.getP().get(0) == this.getP().get(1)){
                throw new TwiskException("Erreur cycle");
            }
            if(memeEtape()){
                throw new TwiskException("Erreur même étape");
            }
            for(ArcIG a : arcArray){
                if(this.getP().get(0).getEtapeRattachement() == a.getP1().getEtapeRattachement() && this.getP().get(1).getEtapeRattachement() == a.getP2().getEtapeRattachement()){
                    throw new TwiskException("Erreur création chemin existant");
                }
            }
            if(this.getP().get(0) != this.getP().get(1) && !memeEtape()){
                this.arcArray.add(tmp);
            }
    }

    public int tailleHashMap(){
        return this.hm.size();
    }
    public ArrayList<PointDeControleIG> getP() {
        return this.arrayPointDeControleIG;
    }
    public void setP(ArrayList<PointDeControleIG> p) {
        this.arrayPointDeControleIG = p;
    }
    public ArrayList<ArcIG> getArcArray() {
        return this.arcArray;
    }
    @Override
    public Iterator<EtapeIG> iterator() {return this.hm.values().iterator();}
}
