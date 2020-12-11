/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr.technique;

import fr.gsb.rv.dr.entites.Visiteur;
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
public class Session {
    
    private static Session session = null ;
    
    private Visiteur leVisiteur ;
    
    private Session(Visiteur leVisiteur){
        this.leVisiteur = leVisiteur ;
    } 

  
    
    
    
    public static void ouvrir ( Visiteur leVisiteur ){
        
        if (session == null){
            session = new Session(leVisiteur);
        }
        
       
        
    }
    
    public static void fermer () {
        
        Session session = null ;
        
        
    }
    
    public static Session getSession() {
        
      return Session.session ;
    }
    
    public Visiteur getLeVisiteur(){
        return this.leVisiteur ;
    }
    
    public static boolean estOuverte(){
        
       if (session == null){
           return false ;
       }else {
           return true ;
       }
        
    }
}
        
   
    
    
    

