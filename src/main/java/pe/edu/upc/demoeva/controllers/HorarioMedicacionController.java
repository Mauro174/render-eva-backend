package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.HorariosMedicacionDTO;
import pe.edu.upc.demoeva.entities.HorariosMedicacion;
import pe.edu.upc.demoeva.servicesinterfaces.HorarioMedicacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/horarios_medicacion")
public class HorarioMedicacionController {
    @Autowired
    private HorarioMedicacionService hS;

    @GetMapping("/lista")
    public List<HorariosMedicacionDTO> listar() {
        return hS.listar().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, HorariosMedicacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/prueba")
    public void insertar(@RequestBody HorariosMedicacionDTO dto) {
        ModelMapper m = new ModelMapper();
        HorariosMedicacion f = m.map(dto, HorariosMedicacion.class);
        hS.insertar(f);
    }

    @PutMapping
    public void modificar(@RequestBody HorariosMedicacionDTO dto) {
        ModelMapper m = new ModelMapper();
        HorariosMedicacion f = m.map(dto, HorariosMedicacion.class);
        hS.update(f);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        hS.delete(id);
    }
}
