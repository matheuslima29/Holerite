/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estagiosupervisionado.Model.daos;

/**
 *
 * @author Matheus Lima
 */
import estagiosupervisionado.Commons.Entities.Funcionario;
import estagiosupervisionado.Commons.Entities.Horario;
import estagiosupervisionado.Commons.Entities.Ponto;
import estagiosupervisionado.Model.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class FuncionarioDAO {
    private Connection connection;

    public FuncionarioDAO(){
        connection = new ConnectionFactory().getConnection();
    }

    public Connection getConnection() {
        return connection;
    }
    
    public Funcionario get(UUID id) {

        Funcionario fun = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Funcionario WHERE id = ?";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);

            stmt.setString(1, id.toString());
            rs = stmt.executeQuery();
            
            getConnection().commit();

            while(rs.next()){
                
                Horario hor = new HorarioDAO().get(id);
                
                fun = new Funcionario(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getInt(4), hor);
                
            }

            stmt.close();
            rs.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return fun;
    }
    
    public UUID getLogin(String login, String senha){
        UUID id = null;
        ResultSet rs = null;
        String sql = "SELECT id FROM Funcionario WHERE login = ? AND senha = ?";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);

            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            getConnection().commit();

            while(rs.next()){
                
                id = UUID.fromString(rs.getString(1));
                
            }

            stmt.close();
            rs.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return id;
    }
    
}
