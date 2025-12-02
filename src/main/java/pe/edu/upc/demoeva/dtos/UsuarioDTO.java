package pe.edu.upc.demoeva.dtos;

import java.time.LocalDate;

public class UsuarioDTO {

    private int idUsuario;

    private String rolUsuario;

    private String emailUsuario;
    private String passwordUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private LocalDate feNacimientoUsuario;
    private String condicionmedicaUsuario;
    private boolean movilidadUsuario;

    // 👇 FALTABAN ESTOS CAMPOS
    private String personalizadoUsuario;
    private int volumenUsuario;
    private Boolean enabled;

    private LocalDate fecreacionUsuario;

    // === GETTERS & SETTERS ===

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDate getFecreacionUsuario() {
        return fecreacionUsuario;
    }

    public void setFecreacionUsuario(LocalDate fecreacionUsuario) {
        this.fecreacionUsuario = fecreacionUsuario;
    }
}
