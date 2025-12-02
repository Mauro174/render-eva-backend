package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeva.entities.RelacionesUsuarios;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.repositories.RelacionesUsuariosRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IRelacionesUsuariosService;

import java.util.List;


@Service
public class RelacionesUsuariosServiceImpl implements IRelacionesUsuariosService {
    @Autowired
    private RelacionesUsuariosRepository repo;

    @Override
    public RelacionesUsuarios insert(RelacionesUsuarios relacionesUsuarios){ return repo.save(relacionesUsuarios); }
    @Override
    public List<RelacionesUsuarios> list(){ return repo.findAll(); }

    @Override
    public RelacionesUsuarios ListId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(RelacionesUsuarios relacionesUsuarios) {
        repo.save(relacionesUsuarios);
    }

    @Override
    public List<RelacionesUsuarios> buscarRelaciones(String nombre, String apellido) {
       return repo.buscar(nombre, apellido);
    }

    @Override
    public List<String[]> cantidadUsuariosSinFamiliares() {
        return repo.cantidadUsuariosSinFamiliares();
    }

    @Override
    public List<String[]> cantidadRelacionesPorMovilidad() {
        return repo.cantidadRelacionesPorMovilidad();
    }
}
