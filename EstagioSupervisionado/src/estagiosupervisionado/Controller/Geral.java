/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estagiosupervisionado.Controller;

import estagiosupervisionado.Commons.Entities.Funcionario;
import estagiosupervisionado.Commons.Entities.Ponto;
import estagiosupervisionado.Model.daos.PontoDAO;
import estagiosupervisionado.View.TelaPrincipal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus Lima
 */
public class Geral {
    
    public static void registraPonto(Ponto pontoAtual, Funcionario funcionarioLogado, TelaPrincipal TP){
        Time registro = Time.valueOf(LocalTime.now());
        
        if(pontoAtual.getEntrada1() == null){
            pontoAtual.setEntrada1(registro);
            new PontoDAO().addNew(pontoAtual, funcionarioLogado.getId());
        }
        else if(pontoAtual.getSaida1() == null){
            pontoAtual.setSaida1(registro);
            new PontoDAO().updatePonto(pontoAtual, funcionarioLogado.getId());
        }
        else if(pontoAtual.getEntrada2() == null){
            pontoAtual.setEntrada2(registro);
            new PontoDAO().updatePonto(pontoAtual, funcionarioLogado.getId());
        }
        else if(pontoAtual.getSaida2() == null){
            pontoAtual.setSaida2(registro);
            new PontoDAO().updatePonto(pontoAtual, funcionarioLogado.getId());
        }
        else{
            JOptionPane.showMessageDialog(TP,
                                          "Todos os pontos de hoje já foram registrados.",
                                          "Falha ao Registrar Ponto",
                                          JOptionPane.WARNING_MESSAGE);
        }
        
    }
}
