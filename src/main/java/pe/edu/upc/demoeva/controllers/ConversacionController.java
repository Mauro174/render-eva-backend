package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.ConversacionDTOInsert;
import pe.edu.upc.demoeva.dtos.ConversacionDTOList;
import pe.edu.upc.demoeva.entities.Conversacion;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.repositories.UsuarioRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IConversacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conversaciones")
public class ConversacionController {

    @Autowired
    private IConversacionService service;

    @GetMapping("/lista_conversacion")
    public List<ConversacionDTOList> listar(){
        return service.listar().stream().map(ent -> {
            ModelMapper m = new ModelMapper();
            ConversacionDTOList dto = m.map(ent, ConversacionDTOList.class);
            if (ent.getUsuario() != null) dto.setUsuarioId(ent.getUsuario().getIdUsuario());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar-conversacion")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertar(@RequestBody ConversacionDTOInsert dto){
        ModelMapper m = new ModelMapper();
        Conversacion ent = m.map(dto, Conversacion.class);
        service.guardar(ent);
    }

    @PutMapping
    public void modificar(@RequestBody ConversacionDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Conversacion c = m.map(dto, Conversacion.class);
        service.update(c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
