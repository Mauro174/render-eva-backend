package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.*;
import pe.edu.upc.demoeva.entities.RelacionesUsuarios;
import pe.edu.upc.demoeva.servicesinterfaces.IRelacionesUsuariosService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/RelacionesUsuarios")
public class RelacionesUsuariosController {

    @Autowired
    private IRelacionesUsuariosService iRelacionesUsuariosService;

    @PostMapping
    public RelacionesUsuarios insertar(@RequestBody RelacionesUsuarios u) {
        return iRelacionesUsuariosService.insert(u);
    }

    @GetMapping
    public List<RelacionesUsuariosDTO> listar() {
        return iRelacionesUsuariosService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RelacionesUsuariosDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        RelacionesUsuarios soft = iRelacionesUsuariosService.ListId(id);
        if (soft == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RelacionesUsuariosDTO dto = m.map(soft, RelacionesUsuariosDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        RelacionesUsuarios s = iRelacionesUsuariosService.ListId(id);
        if (s == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        iRelacionesUsuariosService.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RelacionesUsuariosDTO dto) {
        ModelMapper m = new ModelMapper();
        RelacionesUsuarios li = m.map(dto, RelacionesUsuarios.class);

        // Validación de existencia
        RelacionesUsuarios existente = iRelacionesUsuariosService.ListId(li.getIdRelacion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + li.getIdRelacion());
        }

        // Actualización si pasa validaciones
        iRelacionesUsuariosService.update(li);
        return ResponseEntity.ok("Registro con ID " + li.getIdRelacion() + " modificado correctamente.");
    }

    //se consulta buscarEmail?emailUsuario=ejemplo@upc.edu.pe
    @GetMapping("/buscarRelacionporUsuario")
    public ResponseEntity<?> buscarRelaciones(@RequestParam String nombre, String apellido) {
        List<RelacionesUsuarios> relaciones = iRelacionesUsuariosService.buscarRelaciones(nombre, apellido);

        if (relaciones.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron relaciones para el usuario: " + nombre + " "+ apellido);
        }

        List<ObtenerRelacionesporUsuarioDTO> listaDTO = relaciones.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ObtenerRelacionesporUsuarioDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/cantidadUsuariossinFamiliares")
    public ResponseEntity<?> obtenerCantidadUsuariosSinFamiliares() {
        List<CantidadUsuariossinFamiliaresDTO> listaDTO=new ArrayList<>();
        List<String[]> fila = iRelacionesUsuariosService.cantidadUsuariosSinFamiliares();

        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros" );
        }

        for(String[] columna:fila){
            CantidadUsuariossinFamiliaresDTO dto=new CantidadUsuariossinFamiliaresDTO();
            dto.setCondicionMedica(columna[0]);
            dto.setCantidadUsuarios(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/cantidadRelacionesPorMovilidad")
    public ResponseEntity<?> obtenerCantidadRelacionesPorMovilidad() {
        List<CantidadRelacionesporMovilidadDTO> listaDTO=new ArrayList<>();
        List<String[]> fila = iRelacionesUsuariosService.cantidadRelacionesPorMovilidad();

        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros" );
        }

        for(String[] columna:fila){
            CantidadRelacionesporMovilidadDTO dto=new CantidadRelacionesporMovilidadDTO();
            dto.setMovilidadUsuario(columna[0]);
            dto.setCantidadRelaciones(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }

        return ResponseEntity.ok(listaDTO);
    }

}
