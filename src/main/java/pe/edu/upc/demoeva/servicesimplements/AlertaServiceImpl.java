package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.demoeva.entities.Alerta;
import pe.edu.upc.demoeva.repositories.AlertaRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IAlertaService;

import java.util.List;

@Service
public class AlertaServiceImpl implements IAlertaService {
    private final AlertaRepository repo;

    public AlertaServiceImpl(AlertaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Alerta guardar(Alerta alerta) {
        return repo.save(alerta);
    }

    @Override
    public List<Alerta> listar() {
        return repo.findAll();
    }
}
