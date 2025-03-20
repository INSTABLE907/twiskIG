package twisk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import twisk.mondeIG.MondeIG;
import twisk.vues.VueMenu;
import twisk.vues.VueMondeIG;
import twisk.vues.VueOutils;

public class MainTwisk extends Application {

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Twisk - ANDRE Léo");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1280, 720);
        MondeIG monde = new MondeIG();
        VueOutils vueOutils = new VueOutils(monde);
        VueMondeIG vueMondeIG = new VueMondeIG(monde);
        VueMenu vueMenu = new VueMenu(monde);
        root.setBottom(vueOutils);
        root.setCenter(vueMondeIG);
        root.setTop(vueMenu);
        //Affichage sur écran
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
