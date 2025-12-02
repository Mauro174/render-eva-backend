package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.TipoAlertaDTOInsert;
import pe.edu.upc.demoeva.dtos.TipoAlertaDTOList;
import pe.edu.upc.demoeva.entities.TipoAlerta;
import pe.edu.upc.demoeva.servicesinterfaces.ITipoAlertaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipo-alertas")
public class TipoAlertaController {

    @Autowired
    private ITipoAlertaService service;

    @GetMapping
    public List<TipoAlertaDTOList> listar() {
        return service.listar().stream().map(ent -> {
            ModelMapper m = new ModelMapper();
            return m.map(ent, TipoAlertaDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertar(@RequestBody TipoAlertaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        TipoAlerta ent = m.map(dto, TipoAlerta.class);
        service.guardar(ent);
    }
}
