/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsb.rv.dr;


import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.application.Platform;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;




/**
 *
 * @author etudiant
 */
public class GSBRVDR extends Application {
    private Label label;
    
    
    
    public void start(Stage primaryStage) {
       
       MenuBar barreMenus = new MenuBar() ;
       
       Menu menuFichier = new Menu ("Fichier") ;
       
       Menu menuRapports = new Menu ("Rapports");
       
       Menu menuPraticiens = new Menu ("Praticiens");
       
       MenuItem itemSeConnecter = new MenuItem( "Se connecter");
       
       MenuItem itemSeDeconnecter = new MenuItem ("Se deconnecter");
       
       MenuItem itemQuitter  = new MenuItem ("Quitter");
       
       MenuItem itemConsulter  = new MenuItem ("Consulter");
       
       MenuItem itemHesitants  = new MenuItem ("Hesitants");
       
       
       menuFichier.getItems().addAll(itemSeConnecter, itemSeDeconnecter , itemQuitter);
       
       menuRapports.getItems().add(itemConsulter);
       
       menuPraticiens.getItems().add(itemHesitants);
       
       barreMenus.getMenus().addAll(menuFichier , menuRapports , menuPraticiens) ;
       
       BorderPane bord = new BorderPane();
       
       bord.setTop(barreMenus);
       
       Scene scene = new Scene (bord , 300 , 250) ;
       
       menuRapports.setDisable(true);
       
       menuPraticiens.setDisable(true);
       
       itemSeDeconnecter.setDisable(true);
       
       itemQuitter.setOnAction( actionEvent -> {
           Alert alerteQuitter = new Alert ( Alert.AlertType.CONFIRMATION) ;
        
        alerteQuitter.setTitle("Quitter");
        alerteQuitter.setHeaderText("Demande de confirmation");
        alerteQuitter.setContentText("Voulez-vous quitter l'application ?");
        Optional<ButtonType> reponse = alerteQuitter.showAndWait();
        if (reponse.get()== ButtonType.OK){
            Platform.exit();
        }else{
            
            
            
        }
        
        
       }
       );
       
       itemSeConnecter.setOnAction( actionEvent -> {
            menuRapports.setDisable(false);
       
            menuPraticiens.setDisable(false);
            
            itemSeDeconnecter.setDisable(false);
            
            itemSeConnecter.setDisable(true);
            
            primaryStage.setTitle ("Oumayma Bouaichi");
            
            
       }
       );
       
       itemSeDeconnecter.setOnAction( actionEvent -> {
            menuRapports.setDisable(true);
       
            menuPraticiens.setDisable(true);
            
            itemSeDeconnecter.setDisable(true);
            
            itemSeConnecter.setDisable(false);
       }
       );
       
       
       
       primaryStage.setTitle ("GSB");
       primaryStage.setScene(scene);
       primaryStage.show();
       
       
        }
 
     public static void main(String[] args) {
        launch(args);
    }
    

}

