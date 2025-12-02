package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.Medicamento;
import java.util.List;

public interface IMedicamentoService {
    public Medicamento guardar(Medicamento m);
    public List<Medicamento> listar();
    public void update(Medicamento m);
    public void delete(Long id);
    public List<String[]> TratamientoCompleto();
}
