/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr.entites;
import javafx.util.Pair;
import fr.gsb.rv.dr.entites.*;
import fr.gsb.rv.dr.modeles.*;
import fr.gsb.rv.dr.technique.*;
import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.* ;
import javafx.geometry.Insets;
import javafx.event.* ;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import static fr.gsb.rv.dr.modeles.ModeleGsbRv.seConnecter;
import com.mysql.jdbc.Driver;
import static javafx.application.Application.launch;
import javafx.application.Application; 
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import static javafx.scene.control.ButtonBar.ButtonData.CANCEL_CLOSE;
import static javafx.scene.control.ButtonBar.ButtonData.OK_DONE;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.util.Callback;

        
/**
 *
 * @author etudiant
 */
public class VueConnexion extends Dialog{
   
    
     
     
      public VueConnexion(){
          super() ;
      
      
     
     GridPane grid = new GridPane();
 
       grid.setPadding(new Insets(20));
       grid.setHgap(25);
       grid.setVgap(15);
       
       
       Label labelUserName = new Label("Nom de compte");
       TextField fieldUserName = new TextField();
 
       Label labelPassword = new Label("Mot de passe");
 
       PasswordField fieldPassword = new PasswordField();
 
       ButtonType connectButton = new ButtonType("Connect", OK_DONE); 
       
       ButtonType cancelButton = new ButtonType("Cancel" , CANCEL_CLOSE);
       
       getDialogPane().getButtonTypes().addAll(connectButton , cancelButton);
       
       GridPane.setHalignment(labelUserName, HPos.RIGHT);
 
      
       grid.add(labelUserName, 0, 1);
 
        
       GridPane.setHalignment(labelPassword, HPos.RIGHT);
       grid.add(labelPassword, 0, 2);
 
       
       GridPane.setHalignment(fieldUserName, HPos.LEFT);
       grid.add(fieldUserName, 1, 1);
 
       
       GridPane.setHalignment(fieldPassword, HPos.LEFT);
       grid.add(fieldPassword, 1, 2);
 
       
       super.setTitle("Authentification");
       super.setHeaderText("Saisir vos données");
       
       
       super.getDialogPane().setContent(grid);
       
      
    
    
    
    
        setResultConverter ( 
        new Callback<ButtonType , Pair<String , String>> (){
            
            public Pair<String , String > call ( ButtonType typeBouton) {
                if( typeBouton == connectButton) {
                    return new Pair<String ,String> ( fieldUserName.getText() ,fieldPassword.getText() );
                    
                }
                return null;
            }
        
          
          
        
    
        }
        );      }
      
      
      public static void main(String[] args) {
        launch(args);
      }
        }
    

        


