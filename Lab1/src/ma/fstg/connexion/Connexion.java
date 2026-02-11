/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.fstg.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author X1 YOGA
 */
public class Connexion {
    
    private static String login = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/sir";
    private static Connection connexion;
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver introvable");
        } catch (SQLException ex) {
            System.out.println("Impossible d etablir la connexion "+ex.getMessage());

        }
    }

    public static Connection getConnexion() {
        return connexion;
    }

    
    public static void main(String[] args) {
        getConnexion();
    }
    
    
}
