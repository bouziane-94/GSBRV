/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr.entites;

/**
 *
 * @author etudiant
 */
public class Visiteur {
    
    private String matricule ;
    
    private String nom ;
    
    private String prenom ;
    
    public Visiteur (String matricule , String nom , String prenom){
        super();
        this.matricule = matricule ;
        this.nom = nom ;
        this.prenom = prenom ;
    }
    
    public Visiteur (){
        super();
    }
    
    public String getMatricule() {
        return this.matricule ;
        
    }
    
    public void setMatricule ( String matricule){
        this.matricule = matricule ;
    }
    
    public String getNom() {
        return this.nom ;
        
    }
    
    public void setNom ( String nom){
        this.nom= nom ;
    }
    
    public String getPrenom() {
        return this.prenom ;
        
    }
    
    public void setPrenom ( String prenom){
        this.prenom = prenom ;
        
    }

    @Override
    public String toString() { return this.matricule + " "  +  this.nom  ; }
        
    
    
    
    
   
    
}
