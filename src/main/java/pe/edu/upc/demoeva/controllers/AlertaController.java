package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.AlertaDTOInsert;
import pe.edu.upc.demoeva.dtos.AlertaDTOList;
import pe.edu.upc.demoeva.entities.Alerta;
import pe.edu.upc.demoeva.entities.TipoAlerta;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.repositories.TipoAlertaRepository;
import pe.edu.upc.demoeva.repositories.UsuarioRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IAlertaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private IAlertaService service;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private TipoAlertaRepository tipoRepo;

    @GetMapping
    public List<AlertaDTOList> listar() {
        return service.listar().stream().map(ent -> {
            ModelMapper m = new ModelMapper();
            AlertaDTOList dto = m.map(ent, AlertaDTOList.class);
            dto.setUsuarioId(Long.valueOf(ent.getUsuario() != null ? ent.getUsuario().getIdUsuario() : null));
            dto.setTipoId(ent.getTipo() != null ? ent.getTipo().getId() : null);
            dto.setEmisorId(Long.valueOf(ent.getEmisor() != null ? ent.getEmisor().getIdUsuario() : null));
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertar(@RequestBody AlertaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Alerta ent = m.map(dto, Alerta.class);

        Usuario usuario = usuarioRepo.findById(Math.toIntExact(dto.getUsuarioId()))
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        TipoAlerta tipo = tipoRepo.findById(dto.getTipoId())
                .orElseThrow(() -> new RuntimeException("Tipo de alerta no encontrado"));

        ent.setUsuario(usuario);
        ent.setTipo(tipo);

        if (dto.getEmisorId() != null) {
            Usuario emisor = usuarioRepo.findById(Math.toIntExact(dto.getEmisorId()))
                    .orElseThrow(() -> new RuntimeException("Emisor no encontrado"));
            ent.setEmisor(emisor);
        }

        service.guardar(ent);
    }
}
