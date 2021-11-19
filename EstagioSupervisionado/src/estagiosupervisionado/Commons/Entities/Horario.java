/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estagiosupervisionado.Commons.Entities;

import java.sql.Date;
import java.util.UUID;

/**
 *
 * @author Matheus Lima
 */
public class Horario {
    
    private UUID id;
    private UUID IdFuncionario;
    private Date dataRegistro;
    private Integer cargaHoraiaMensal;

    public Horario(UUID id, UUID IdFuncionario, Date dataRegistro, Integer cargaHoraiaMensal) {
        this.id = id;
        this.IdFuncionario = IdFuncionario;
        this.dataRegistro = dataRegistro;
        this.cargaHoraiaMensal = cargaHoraiaMensal;
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdFuncionario() {
        return IdFuncionario;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public Integer getCargaHoraiaMensal() {
        return cargaHoraiaMensal;
    }
    
    
}
