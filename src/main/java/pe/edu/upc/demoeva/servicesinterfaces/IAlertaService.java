package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.Alerta;
import java.util.List;

public interface IAlertaService {
    Alerta guardar(Alerta alerta);
    List<Alerta> listar();
}