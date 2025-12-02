package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.demoeva.entities.TipoAlerta;
import pe.edu.upc.demoeva.repositories.TipoAlertaRepository;
import pe.edu.upc.demoeva.servicesinterfaces.ITipoAlertaService;

import java.util.List;

@Service
public class TipoAlertaServiceImpl implements ITipoAlertaService {

    private final TipoAlertaRepository repo;

    public TipoAlertaServiceImpl(TipoAlertaRepository repo) {
        this.repo = repo;
    }

    @Override
    public TipoAlerta guardar(TipoAlerta t) {
        return repo.save(t);
    }

    @Override
    public List<TipoAlerta> listar() {
        return repo.findAll();
    }
}
