package pe.edu.upc.demoeva.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="HorariosMedicacion")
public class HorariosMedicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idmedicamento", nullable = false)
    private Medicamento idmedicamente;

    @Column(name = "frecuencia", length = 20)
    private String frecuencia;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "hora_diaria")
    private LocalTime horaDiaria;

    @Column(name = "dias_semana", length = 20)
    private String diasSemana;

    @Column(name = "activo")
    private Boolean activo = true;

    public HorariosMedicacion() {
    }

    public HorariosMedicacion(Long id, Medicamento idmedicamente, String frecuencia, LocalDateTime fechaHora, LocalTime horaDiaria, String diasSemana, Boolean activo) {
        this.id = id;
        this.idmedicamente = idmedicamente;
        this.frecuencia = frecuencia;
        this.fechaHora = fechaHora;
        this.horaDiaria = horaDiaria;
        this.diasSemana = diasSemana;
        this.activo = activo;
    }

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
