package pe.edu.upc.demoeva.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Mensajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensaje;

    @ManyToOne
    @JoinColumn(name="relacionado_id")
    private Usuario relacionado;
}
