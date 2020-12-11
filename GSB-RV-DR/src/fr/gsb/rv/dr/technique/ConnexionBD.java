package fr.gsb.rv.dr.technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet ;
import java.sql.Statement;
import static javafx.application.Application.launch;

public class ConnexionBD {
    
    private static String dbURL = "jdbc:mysql://localhost:3306/gsbrv" ;
    private static String user = "dev" ;
    private static String password = "azerty" ;
    
    private static Connection connexion = null ;
     
    
   
    
    private ConnexionBD() throws ConnexionException {
        try {
            Class.forName( "com.mysql.jdbc.Driver" ) ;
            connexion = (Connection) DriverManager.getConnection(dbURL, user, password) ;
        
           
            
            
		 
                 System.out.println( "Reussi" );
                 
        }
        catch( Exception e ){
            throw new ConnexionException() ;
        }
    }
    
    public static Connection getConnexion() throws ConnexionException {
        if( connexion == null ){
            new ConnexionBD() ;
        }
        return connexion ;
    }

 
        public static void main(String[] args) {
        launch(args);
    
    

}
}