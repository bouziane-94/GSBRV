/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr.entites;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage ;
import javafx.scene.layout.BorderPane;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import fr.gsb.rv.dr.technique.*;
import fr.gsb.rv.dr.modeles.*;
import static fr.gsb.rv.dr.modeles.ModeleGsbRv.seConnecter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;


/**
 *
 * @author etudiant
 */
public class Appli extends Application {
    private Label label;
    
    Visiteur un = new Visiteur ("OB001" ,"BOUAICHI","Oumayma" );
    
    
    public void start(Stage primaryStage) throws ConnexionException {
       
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
       
       itemSeConnecter.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) { 
                menuRapports.setDisable(false);
               
               menuPraticiens.setDisable(false);
               
               itemSeDeconnecter.setDisable(false);
               
               itemSeConnecter.setDisable(true);
               
               VueConnexion co = new VueConnexion() ;
               Optional<Pair<String,String>> reponse = co.showAndWait();
               
               
                       
                   reponse.ifPresent(pair ->
                   {
                       
                       try {
                           Visiteur vis = seConnecter ( pair.getKey(), pair.getValue());
                           
                            if(vis!= null){ 
                               System.out.println("oui");
                               primaryStage.setTitle (vis.getPrenom() + " " + vis.getNom());
                                  
                               
                           }
                           
                       } catch (ConnexionException ex) {
                           Logger.getLogger(Appli.class.getName()).log(Level.SEVERE, null, ex);
                         
                       
                               
                       }
                       
                       
                
                   });
               }
                 
              });
              
              
          
       
               
                
              
           
       
       
       itemSeDeconnecter.setOnAction( actionEvent -> {
            menuRapports.setDisable(true);
       
            menuPraticiens.setDisable(true);
            
            itemSeDeconnecter.setDisable(true);
            
            itemSeConnecter.setDisable(false);
            
            primaryStage.setTitle ("GSB");
            
            
       }
       );
       
       itemConsulter.setOnAction ( actionEvent -> {
         System.out.println("[Rapports]" + " " + un.getPrenom() + " " + un.getNom());
           
           
       }
       );
       
       
       itemHesitants.setOnAction ( actionEvent -> {
         System.out.println("[Praticiens]" + " " + un.getPrenom() + " " + un.getNom());
         
           
       }            
       );
       
       primaryStage.setTitle ("GSB");
      
       primaryStage.setScene(scene);
       primaryStage.show();
       
       Connection connexion = ConnexionBD.getConnexion();
       
        System.out.println(seConnecter("a131", "azerty")) ;
        
        
      
    }
 
     public static void main(String[] args) {
        launch(args);
    }
    

}

