package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.Conversacion;
import pe.edu.upc.demoeva.entities.Medicamento;

import java.util.List;

public interface IConversacionService {
    public Conversacion guardar(Conversacion c);
    public List<Conversacion> listar();
    public void update(Conversacion c);
    public void delete(Long id);
}
