/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import ma.fstg.entites.Filiere;
import ma.fstg.services.FiliereService;

/**
 *
 * @author X1 YOGA
 */
public class SIR1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        FiliereService fs = new FiliereService();
        fs.create(new Filiere("GI", "GI"));
        //fs.delete(fs.findById(1));
        
        for(Filiere f : fs.findAll())
            System.out.println(f);
    }
    
}
