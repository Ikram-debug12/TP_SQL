/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.fstg.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.fstg.connexion.Connexion;
import ma.fstg.dao.IDao;
import ma.fstg.entites.Etudiant;

/**
 *
 * @author X1 YOGA
 */
public class EtudiantService implements IDao<Etudiant> {

    FiliereService fs = null;

    public EtudiantService() {
        fs = new FiliereService();
    }
    
    @Override
    public boolean create(Etudiant o) {
        try {
            String req = "INSERT INTO `etudiant` (`id`, `nom`, `prenom`, `filiere`) VALUES (NULL, ?, ?, ?) ";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setInt(3, o.getFiliere().getId());

            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Etudiant o) {
        try {
            String req = "delete from etudiant where id  = ?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Etudiant o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudiant findById(int id) {

        try {
            String req = "select * from Etudiant where id = ?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), fs.findById(rs.getInt("filiere")));
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        
        try {
            String req = "select * from Etudiant";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                etudiants.add(new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), fs.findById(rs.getInt("filiere"))));
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return etudiants;
        
        
    }

}
