package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.TipoAlerta;

import java.util.List;

public interface ITipoAlertaService {
    TipoAlerta guardar(TipoAlerta t);
    List<TipoAlerta> listar();
}
