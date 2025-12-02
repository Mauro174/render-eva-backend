package pe.edu.upc.demoeva.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.demoeva.entities.Medicamento;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class HorariosMedicacionDTO {
    private Long id;
    private Medicamento idmedicamente;
    private String frecuencia;
    private LocalDateTime fechaHora;
    private LocalTime horaDiaria;
    private String diasSemana;
    private Boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medicamento getIdmedicamente() {
        return idmedicamente;
    }

    public void setIdmedicamente(Medicamento idmedicamente) {
        this.idmedicamente = idmedicamente;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public LocalTime getHoraDiaria() {
        return horaDiaria;
    }

    public void setHoraDiaria(LocalTime horaDiaria) {
        this.horaDiaria = horaDiaria;
    }

    public String getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(String diasSemana) {
        this.diasSemana = diasSemana;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
