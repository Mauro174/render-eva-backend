package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.demoeva.entities.Conversacion;
import pe.edu.upc.demoeva.repositories.ConversacionRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IConversacionService;

import java.util.List;

@Service
public class ConversacionServiceImpl implements IConversacionService {
    private final ConversacionRepository repo;
    public ConversacionServiceImpl(ConversacionRepository repo) { this.repo = repo; }
    public Conversacion guardar(Conversacion c) { return repo.save(c); }
    public List<Conversacion> listar() { return repo.findAll(); }

    @Override
    public void update(Conversacion c) {
        repo.save(c);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
