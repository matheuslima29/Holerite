/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estagiosupervisionado;

import estagiosupervisionado.Model.factory.ConnectionFactory;
import estagiosupervisionado.View.TelaLogin;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.Time;
import java.time.LocalTime;

/**
 *
 * @author Matheus Lima
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TelaLogin tLogin = new TelaLogin();
        tLogin.setVisible(true);
        
    }
    
}
