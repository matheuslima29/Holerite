/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estagiosupervisionado.Commons.Entities;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Matheus Lima
 */
public class Ponto {
    
    private Date dia;
    private Time entrada1;
    private Time saida1;
    private Time entrada2;
    private Time saida2;

    public Ponto(Date dia, Time entrada1, Time saida1, Time entrada2, Time saida2) {
        this.dia = dia;
        this.entrada1 = entrada1;
        this.saida1 = saida1;
        this.entrada2 = entrada2;
        this.saida2 = saida2;
    }

    public Date getDia() {
        return dia;
    }

    public Time getEntrada1() {
        return entrada1;
    }

    public Time getSaida1() {
        return saida1;
    }

    public Time getEntrada2() {
        return entrada2;
    }

    public Time getSaida2() {
        return saida2;
    }

    public void setEntrada1(Time entrada1) {
        this.entrada1 = entrada1;
    }

    public void setSaida1(Time saida1) {
        this.saida1 = saida1;
    }

    public void setEntrada2(Time entrada2) {
        this.entrada2 = entrada2;
    }

    public void setSaida2(Time saida2) {
        this.saida2 = saida2;
    }
    
    
    
}
