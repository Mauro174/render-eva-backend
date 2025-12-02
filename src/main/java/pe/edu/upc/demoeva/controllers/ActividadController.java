package pe.edu.upc.demoeva.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.demoeva.servicesinterfaces.IActividadService;
import pe.edu.upc.demoeva.dtos.ActividadDTOInsert;
import pe.edu.upc.demoeva.dtos.ActividadDTOList;

import java.util.List;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    @Autowired
    private IActividadService actividadService;

    @GetMapping
    public List<ActividadDTOList> listar() {
        return actividadService.listar();
    }

    @GetMapping("/{id}")
    public ActividadDTOList obtenerPorId(@PathVariable Long id) {
        return actividadService.obtenerPorId(id);
    }

    @PostMapping
    public ActividadDTOList registrar(@RequestBody ActividadDTOInsert dto) {
        return actividadService.registrar(dto);
    }

    @PutMapping("/{id}")
    public ActividadDTOList actualizar(@PathVariable Long id, @RequestBody ActividadDTOInsert dto) {
        return actividadService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        actividadService.eliminar(id);
    }
}