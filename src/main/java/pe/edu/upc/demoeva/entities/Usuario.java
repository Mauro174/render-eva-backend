package pe.edu.upc.demoeva.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    //@JoinColumn(name = "user_id")
    private List<Rol> roles = new ArrayList<>();

    @Column(name = "emailUsuario", nullable = false, unique = true, length = 80)
    private String emailUsuario;

    @Column(name = "passwordUsuario", nullable = false, length = 100)
    private String passwordUsuario;

    @Column(name = "nombreUsuario", nullable = false, length = 120)
    private String nombreUsuario;

    @Column(name = "apellidoUsuario", nullable = false, length = 120)
    private String apellidoUsuario;

    @Column(name = "feNacimientoUsuario", nullable = false)
    private LocalDate feNacimientoUsuario;

    @Column(name = "condicionmedicaUsuario", length = 100)
    private String condicionmedicaUsuario;

    @Column(name = "movilidadUsuario", nullable = false)
    private boolean movilidadUsuario;

    @Column(name = "personalizadoUsuario", length = 100)
    private String personalizadoUsuario;

    @Column(name = "volumenUsuario", nullable = false)
    private int volumenUsuario;

    @CreationTimestamp
    @Column(name = "fecreacionUsuario", nullable = false)
    private LocalDate fecreacionUsuario;

    @UpdateTimestamp
    @Column(name = "feactualizacionUsuario", nullable = false)
    private LocalDate feactualizacionUsuario;

    //aqui falta modificarlo por el FK
    //@Column(name = "Integracionesid",nullable = true)
    //private Integer integracionesid;

    private Boolean enabled;


    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Usuario() {}

    public Usuario(int idUsuario, List<Rol> roles, String emailUsuario, String passwordUsuario, String nombreUsuario, String apellidoUsuario, LocalDate feNacimientoUsuario, String condicionmedicaUsuario, boolean movilidadUsuario, String personalizadoUsuario, int volumenUsuario, LocalDate fecreacionUsuario, LocalDate feactualizacionUsuario, Boolean enabled) {
        this.idUsuario = idUsuario;
        this.roles = roles;
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.feNacimientoUsuario = feNacimientoUsuario;
        this.condicionmedicaUsuario = condicionmedicaUsuario;
        this.movilidadUsuario = movilidadUsuario;
        this.personalizadoUsuario = personalizadoUsuario;
        this.volumenUsuario = volumenUsuario;
        this.fecreacionUsuario = fecreacionUsuario;
        this.feactualizacionUsuario = feactualizacionUsuario;
        this.enabled = enabled;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public LocalDate getFeNacimientoUsuario() {
        return feNacimientoUsuario;
    }

    public void setFeNacimientoUsuario(LocalDate feNacimientoUsuario) {
        this.feNacimientoUsuario = feNacimientoUsuario;
    }

    public String getCondicionmedicaUsuario() {
        return condicionmedicaUsuario;
    }

    public void setCondicionmedicaUsuario(String condicionmedicaUsuario) {
        this.condicionmedicaUsuario = condicionmedicaUsuario;
    }

    public boolean isMovilidadUsuario() {
        return movilidadUsuario;
    }

    public void setMovilidadUsuario(boolean movilidadUsuario) {
        this.movilidadUsuario = movilidadUsuario;
    }

    public String getPersonalizadoUsuario() {
        return personalizadoUsuario;
    }

    public void setPersonalizadoUsuario(String personalizadoUsuario) {
        this.personalizadoUsuario = personalizadoUsuario;
    }

    public int getVolumenUsuario() {
        return volumenUsuario;
    }

    public void setVolumenUsuario(int volumenUsuario) {
        this.volumenUsuario = volumenUsuario;
    }

    public LocalDate getFecreacionUsuario() {
        return fecreacionUsuario;
    }

    public void setFecreacionUsuario(LocalDate fecreacionUsuario) {
        this.fecreacionUsuario = fecreacionUsuario;
    }

    public LocalDate getFeactualizacionUsuario() {
        return feactualizacionUsuario;
    }

    public void setFeactualizacionUsuario(LocalDate feactualizacionUsuario) {
        this.feactualizacionUsuario = feactualizacionUsuario;
    }

    //public Integer getIntegracionesid() {
      //  return integracionesid;
    //}

    //public void setIntegracionesid(Integer integracionesid) {
        //this.integracionesid = integracionesid;
    //}
}
