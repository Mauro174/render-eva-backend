package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.demoeva.entities.Medicamento;
import pe.edu.upc.demoeva.repositories.MedicamentoRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IMedicamentoService;

import java.util.List;

@Service
public class MedicamentoServiceImpl implements IMedicamentoService {
    private final MedicamentoRepository repo;
    public MedicamentoServiceImpl(MedicamentoRepository repo) { this.repo = repo; }
    @Override public Medicamento guardar(Medicamento m) { return repo.save(m); }
    @Override public List<Medicamento> listar() { return repo.findAll(); }

    @Override
    public void update(Medicamento m) {
        repo.save(m);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<String[]> TratamientoCompleto() {
        return repo.TratamientoCompleto();
    }
}
