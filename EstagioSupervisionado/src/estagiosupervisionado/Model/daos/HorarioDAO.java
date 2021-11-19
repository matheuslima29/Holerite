/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estagiosupervisionado.Model.daos;

import estagiosupervisionado.Commons.Entities.Funcionario;
import estagiosupervisionado.Commons.Entities.Horario;
import estagiosupervisionado.Model.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 *
 * @author Matheus Lima
 */
public class HorarioDAO {
    private Connection connection;

    public HorarioDAO(){
        connection = new ConnectionFactory().getConnection();
    }

    public Connection getConnection() {
        return connection;
    }
    
    public Horario get(UUID id) {

        Horario hor = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Horarios WHERE id = ?";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);

            stmt.setString(1, id.toString());
            rs = stmt.executeQuery();
            
            getConnection().commit();

            while(rs.next()){
                hor = new Horario(UUID.fromString(rs.getString(1)), UUID.fromString(rs.getString(2)), rs.getDate(3), rs.getInt(4));           
            }

            stmt.close();
            rs.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return hor;
    }
}
