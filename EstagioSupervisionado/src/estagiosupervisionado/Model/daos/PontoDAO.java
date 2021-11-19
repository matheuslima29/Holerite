/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estagiosupervisionado.Model.daos;

import estagiosupervisionado.Commons.Entities.Funcionario;
import estagiosupervisionado.Commons.Entities.Ponto;
import estagiosupervisionado.Model.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Matheus Lima
 */
public class PontoDAO {
    private Connection connection;

    public PontoDAO(){
        connection = new ConnectionFactory().getConnection();
    }

    public Connection getConnection() {
        return connection;
    }
    
    public ArrayList<Ponto> getAll(UUID id) {

        ArrayList<Ponto> listPontos = new ArrayList<Ponto>();
        ResultSet rs = null;
        String sql = "SELECT Data, Entrada1, Saida1, Entrada2, Saida2 FROM Pontos WHERE id_funcionario = ? AND Data BETWEEN ? AND ? ORDER BY Data";
        
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            
            Integer mes = LocalDate.now().getMonthValue();
            Integer ano = LocalDate.now().getYear();
            Integer totalDias = LocalDate.of(1, mes, 1).lengthOfMonth();
            
            stmt.setString(1, id.toString());
            stmt.setDate(2, Date.valueOf(LocalDate.of(ano, mes, 1)));
            stmt.setDate(3, Date.valueOf(LocalDate.of(ano, mes, totalDias)));
            
            rs = stmt.executeQuery();
            
            getConnection().commit();

            while(rs.next()){
                listPontos.add( new Ponto(rs.getDate(1), rs.getTime(2), rs.getTime(3), rs.getTime(4), rs.getTime(5)));
            }
            
            for(int i = 1; i <= totalDias; i++){

                Date data = Date.valueOf(LocalDate.of(ano, mes, i));
                boolean last = true;
                for (Ponto p : listPontos){
                    if(p.getDia().equals(data)){
                        last = false;
                    }
                }
                
                if(last){
                    listPontos.add(new Ponto(data, null, null, null, null));
                }

            }

            stmt.close();
            rs.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return listPontos;
    }
    
    public void addNew(Ponto pnt, UUID id_funcionario){
        ResultSet rs = null;
        String sql = "INSERT INTO Pontos (id, id_funcionario, data, entrada1, saida1, entrada2, saida2) VALUES (NEWID(), ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            
            String en1 = pnt.getEntrada1() == null ? null : pnt.getEntrada1().toString();
            String sa1 = pnt.getSaida1() == null ? null : pnt.getSaida1().toString();
            String en2 = pnt.getEntrada2() == null ? null : pnt.getEntrada2().toString();
            String sa2 = pnt.getSaida2() == null ? null : pnt.getSaida2().toString();

            stmt.setString(1, id_funcionario.toString());
            stmt.setDate(2, pnt.getDia());
            stmt.setString(3, en1);
            stmt.setString(4, sa1);
            stmt.setString(5, en2);
            stmt.setString(6, sa2);
            
            stmt.execute();
            
            getConnection().commit();

            stmt.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void updatePonto(Ponto pnt, UUID id_funcionario){
        ResultSet rs = null;
        String sql = "UPDATE Pontos SET Entrada1 = ?, Saida1 = ?, Entrada2 = ?, Saida2 = ? WHERE Data = ? AND id_funcionario = ?";
        
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);

            String en1 = pnt.getEntrada1() == null ? null : pnt.getEntrada1().toString();
            String sa1 = pnt.getSaida1() == null ? null : pnt.getSaida1().toString();
            String en2 = pnt.getEntrada2() == null ? null : pnt.getEntrada2().toString();
            String sa2 = pnt.getSaida2() == null ? null : pnt.getSaida2().toString();
            
            stmt.setString(1, en1);
            stmt.setString(2, sa1);
            stmt.setString(3, en2);
            stmt.setString(4, sa2);
            stmt.setDate(5, pnt.getDia());
            stmt.setString(6, id_funcionario.toString());
            
            stmt.execute();
            
            getConnection().commit();

            stmt.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
