/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import ma.fstg.entites.Etudiant;
import ma.fstg.entites.Filiere;
import ma.fstg.services.EtudiantService;
import ma.fstg.services.FiliereService;

/**
 *
 * @author X1 YOGA
 */
public class TestEtudiant {
    
    public static void main(String[] args) {
        FiliereService fs = new FiliereService();
        EtudiantService es = new EtudiantService();
        
     //   es.create(new Etudiant("Alami", "Karim", fs.findById(2)));
       
      //  es.delete(es.findById(1));
        
        for(Etudiant e : es.findAll())
            System.out.println(e);
    }
    
}
