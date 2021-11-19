/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estagiosupervisionado.Commons.Entities;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Matheus Lima
 */
public class Funcionario {
    
    private UUID id;
    private String login;
    private String senha;
    private Integer cargaHoraiaMensal;
    private Horario horarios;

    public Funcionario(UUID id, String login, String senha, Integer cargaHoraiaMensal, Horario horarios) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.cargaHoraiaMensal = cargaHoraiaMensal;
        this.horarios = horarios;
    }

    public UUID getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Integer getCargaHoraiaMensal() {
        return cargaHoraiaMensal;
    }

    public Horario getHorarios() {
        return horarios;
    }

    
    
    
}
