package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.ConversacionDTOInsert;
import pe.edu.upc.demoeva.dtos.MedicamentoDTOInsert;
import pe.edu.upc.demoeva.dtos.MedicamentoDTOList;
import pe.edu.upc.demoeva.dtos.TratamientoCompletoDTO;
import pe.edu.upc.demoeva.entities.Conversacion;
import pe.edu.upc.demoeva.entities.Medicamento;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.repositories.UsuarioRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IMedicamentoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private IMedicamentoService service;

    @Autowired
    private UsuarioRepository usuarioRepo; // para resolver FK

    @GetMapping
    public List<MedicamentoDTOList> listar(){
        return service.listar().stream().map(ent -> {
            ModelMapper m = new ModelMapper();
            MedicamentoDTOList dto = m.map(ent, MedicamentoDTOList.class);
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertar(@RequestBody MedicamentoDTOInsert dto){
        ModelMapper m = new ModelMapper();
        Medicamento ent = m.map(dto, Medicamento.class);
        service.guardar(ent);
    }

    @PutMapping
    public void modificar(@RequestBody MedicamentoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Medicamento med = m.map(dto, Medicamento.class);
        service.update(med);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        service.delete(id);
    }


    @GetMapping("/tratamientocomplejo")
    public List<TratamientoCompletoDTO> tratamientoComplejo(){
        List<TratamientoCompletoDTO> dtoList = new ArrayList<>();
        List<String[]> filaList = service.TratamientoCompleto();
        for(String[] columna:filaList){
            TratamientoCompletoDTO dto2 = new TratamientoCompletoDTO();
            dto2.setIdusario(Integer.parseInt(columna[0]));
            dto2.setNombreusuario(columna[1]);
            dto2.setCantidadmedicamentos(Integer.parseInt(columna[2]));
            dtoList.add(dto2);
        }

        return dtoList;
    }
}
