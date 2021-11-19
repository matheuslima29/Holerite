/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estagiosupervisionado.Model.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Matheus Lima
 */
public class ConnectionFactory {
    private static Connection conn = null;

        public static Connection getConnection() {
                if(conn == null) {
                        try {
                                return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=EstagioSupervisionado;integratedSecurity=true;");
                        } catch (SQLException e) {
                                throw new RuntimeException(e);
                        }
                }
                else {
                        return conn;
                }
        }
}
