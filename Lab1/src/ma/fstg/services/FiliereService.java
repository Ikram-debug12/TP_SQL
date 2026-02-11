/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.fstg.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.fstg.connexion.Connexion;
import ma.fstg.dao.IDao;
import ma.fstg.entites.Filiere;

/**
 *
 * @author X1 YOGA
 */
public class FiliereService implements IDao<Filiere> {

    @Override
    public boolean create(Filiere o) {
        boolean etat = false;
        try {
            String req = "INSERT INTO `filiere` (`id`, `code`, `libelle`) VALUES (NULL, '" + o.getCode() + "', '" + o.getLibelle() + "')";
            Statement st = Connexion.getConnexion().createStatement();
            if (st.executeUpdate(req) == 1) {
                etat = true;
            } else {
                etat = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FiliereService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return etat;
    }

    @Override
    public boolean delete(Filiere o) {
        boolean etat = false;
        try {
            String req = "delete from filiere where id  = "+ o.getId();
            Statement st = Connexion.getConnexion().createStatement();
            if (st.executeUpdate(req) == 1) {
                etat = true;
            } else {
                etat = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FiliereService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return etat;
    }

    @Override
    public boolean update(Filiere o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Filiere findById(int id) {
        try {
            String req = "select * from filiere where id = "+ id;
            Statement st = Connexion.getConnexion().createStatement();
            
            ResultSet rs = st.executeQuery(req);
            
            if(rs.next())
                return new Filiere(rs.getInt("id"), rs.getString("code"), rs.getString("libelle"));

        } catch (SQLException ex) {
            Logger.getLogger(FiliereService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Filiere> findAll() {
        List<Filiere> filieres = new ArrayList<>();
        try {
            String req = "select * from filiere";
            Statement st = Connexion.getConnexion().createStatement();
            
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next())
                filieres.add(new Filiere(rs.getInt("id"), rs.getString("code"), rs.getString("libelle")));

        } catch (SQLException ex) {
            Logger.getLogger(FiliereService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filieres;
    }

}
