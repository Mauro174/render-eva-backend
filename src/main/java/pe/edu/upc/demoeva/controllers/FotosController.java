package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;          // 🔹 IMPORTANTE
import pe.edu.upc.demoeva.dtos.CantidadFotosDTO;
import pe.edu.upc.demoeva.dtos.FotosDTO;
import pe.edu.upc.demoeva.entities.Fotos;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.servicesinterfaces.FotoService;
import pe.edu.upc.demoeva.servicesinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/fotos")
public class FotosController {

    @Autowired
    private FotoService fS;

    @Autowired
    private IUsuarioService uS;

    // ===== LISTAR TODAS / O SOLO LAS DEL USUARIO SEGÚN ROL =====
    @GetMapping
    public List<FotosDTO> listar(Authentication auth) {
        // 1) username que viene del token (normalmente nombreUsuario)
        String username = auth.getName();

        // 2) buscamos por nombreUsuario, NO por email
        Usuario u = uS.buscarPorNombreUsuario(username);

        if (u == null) {
            return new ArrayList<>(); // por si acaso
        }

        // 3) verificar si es ADMIN (ajusta el nombre del rol según tu BD)
        boolean esAdmin = u.getRoles().stream()
                .anyMatch(r ->
                        "ADMIN".equalsIgnoreCase(r.getRol()) ||
                                "ROLE_ADMIN".equalsIgnoreCase(r.getRol())
                );

        List<Fotos> lista;

        if (esAdmin) {
            // ADMIN → ve todas las fotos
            lista = fS.listar();
        } else {
            // NO ADMIN → solo sus fotos
            lista = fS.listarPorUsuario(u.getIdUsuario());
        }

        ModelMapper m = new ModelMapper();
        return lista.stream()
                .map(f -> m.map(f, FotosDTO.class))
                .collect(Collectors.toList());
    }

    // ===== BUSCAR POR ID =====
    @GetMapping("/{id}")
    public FotosDTO listarPorId(@PathVariable("id") Long id) {
        Fotos entidad = fS.listarPorId(id);
        if (entidad == null) {
            return null;
        }
        ModelMapper m = new ModelMapper();
        return m.map(entidad, FotosDTO.class);
    }

    // ===== INSERTAR =====
    @PostMapping
    public void insertar(@RequestBody FotosDTO dto, Authentication auth) {

        Fotos f = new Fotos();
        f.setUrl(dto.getUrl());
        f.setTitulo(dto.getTitulo());
        f.setDescripcion(dto.getDescripcion());
        f.setFecha_Creacion(dto.getFecha_Creacion());

        // ✅ SIEMPRE tomamos el usuario desde el token
        String username = auth.getName();                      // nombreUsuario del JWT
        Usuario u = uS.buscarPorNombreUsuario(username);       // método que ya creamos

        // por seguridad, si no lo encuentra, no seguimos
        if (u == null) {
            throw new RuntimeException("Usuario no encontrado para insertar foto");
        }

        f.setIdUsuario(u);   // 🔴 AQUÍ YA NUNCA ES NULL

        fS.insertar(f);
    }


    // ===== MODIFICAR =====
    @PutMapping("/{id}")
    public void modificar(@PathVariable("id") Long id, @RequestBody FotosDTO dto) {

        // Traemos la foto EXISTENTE
        Fotos f = fS.listarPorId(id);

        f.setUrl(dto.getUrl());
        f.setTitulo(dto.getTitulo());
        f.setDescripcion(dto.getDescripcion());
        f.setFecha_Creacion(dto.getFecha_Creacion());

        // Solo reasigna usuario si viene uno válido
        if (dto.getIdUsuario() != null
                && dto.getIdUsuario().getIdUsuario() > 0) {
            Usuario u = uS.ListId(dto.getIdUsuario().getIdUsuario());
            f.setIdUsuario(u);
        }

        fS.update(f);
    }

    // ===== ELIMINAR =====
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        fS.delete(id);
    }

    // ===== REPORTE: USUARIO CON MÁS FOTOS =====
    @GetMapping("/mayorfotos")
    public List<CantidadFotosDTO> mayorfotos() {
        List<CantidadFotosDTO> dtoList = new ArrayList<>();
        List<String[]> filaList = fS.MasFotos();

        for (String[] columna : filaList) {
            CantidadFotosDTO dto2 = new CantidadFotosDTO();
            dto2.setUsuario(columna[0]);
            dto2.setCantidad(Integer.parseInt(columna[1]));
            dtoList.add(dto2);
        }

        return dtoList;
    }
}
