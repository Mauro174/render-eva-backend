package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeva.entities.Fotos;
import pe.edu.upc.demoeva.repositories.FotosRepository;
import pe.edu.upc.demoeva.servicesinterfaces.FotoService;

import java.util.List;

@Service
public class FotoServiceImpl implements FotoService {

    @Autowired
    private FotosRepository fR;

    @Override
    public void insertar(Fotos f) {
        fR.save(f);
    }

    @Override
    public List<Fotos> listar() {
        return fR.findAll();
    }

    @Override
    public Fotos listarPorId(Long id) {
        return fR.findById(id).orElse(null);
    }

    @Override
    public void update(Fotos f) {
        fR.save(f);
    }

    @Override
    public void delete(Long id) {
        fR.deleteById(id);
    }

    @Override
    public List<String[]> MasFotos() {
        return fR.MasFotos();
    }

    @Override
    public List<Fotos> listarPorUsuario(int idUsuario) {
        return fR.findByIdUsuario_IdUsuarioOrderByIdAsc(idUsuario);
    }

}
