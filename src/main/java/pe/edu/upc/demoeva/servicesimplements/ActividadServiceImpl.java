package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.demoeva.servicesinterfaces.IActividadService;
import pe.edu.upc.demoeva.repositories.ActividadRepository;
import pe.edu.upc.demoeva.repositories.UsuarioRepository;
import pe.edu.upc.demoeva.entities.Actividad;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.dtos.ActividadDTOInsert;
import pe.edu.upc.demoeva.dtos.ActividadDTOList;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActividadServiceImpl implements IActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private ActividadDTOList convertToDTO(Actividad actividad) {
        ActividadDTOList dto = new ActividadDTOList();
        dto.setId(actividad.getId());
        dto.setUsuarioId((long) actividad.getUsuario().getIdUsuario());
        dto.setTipo(actividad.getTipo());
        dto.setDescripcion(actividad.getDescripcion());
        dto.setOcurrioEn(actividad.getOcurrioEn());
        return dto;
    }

    private Actividad convertToEntity(ActividadDTOInsert dto) {
        Actividad actividad = new Actividad();
        Usuario usuario = usuarioRepository.findById(Math.toIntExact(dto.getUsuarioId()))
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        actividad.setUsuario(usuario);
        actividad.setTipo(dto.getTipo());
        actividad.setDescripcion(dto.getDescripcion());
        actividad.setOcurrioEn(dto.getOcurrioEn());
        return actividad;
    }

    @Override
    public List<ActividadDTOList> listar() {
        return actividadRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ActividadDTOList obtenerPorId(Long id) {
        return actividadRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
    }

    @Override
    public ActividadDTOList registrar(ActividadDTOInsert dto) {
        Actividad actividad = convertToEntity(dto);
        return convertToDTO(actividadRepository.save(actividad));
    }

    @Override
    public ActividadDTOList actualizar(Long id, ActividadDTOInsert dto) {
        if (!actividadRepository.existsById(id)) {
            throw new RuntimeException("Actividad no encontrada");
        }
        Actividad actividad = convertToEntity(dto);
        actividad.setId(id);
        return convertToDTO(actividadRepository.save(actividad));
    }

    @Override
    public void eliminar(Long id) {
        if (!actividadRepository.existsById(id)) {
            throw new RuntimeException("Actividad no encontrada");
        }
        actividadRepository.deleteById(id);
    }
}
