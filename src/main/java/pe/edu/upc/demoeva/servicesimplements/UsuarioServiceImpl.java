package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.demoeva.entities.Rol;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.repositories.UsuarioRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IUsuarioService;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository repo;

    public UsuarioServiceImpl(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;   // uso el bean definido en WebSecurityConfig

    @Override
    public Usuario insertar(Usuario u) {
        // 🔐 Encripto la contraseña si viene en texto plano
        if (u.getPasswordUsuario() != null && !u.getPasswordUsuario().isBlank()) {
            // Evito encriptar dos veces si por alguna razón ya viene en Bcrypt
            if (!u.getPasswordUsuario().startsWith("$2a$")) {
                u.setPasswordUsuario(passwordEncoder.encode(u.getPasswordUsuario()));
            }
        }

        // Seteo el usuario en cada rol para evitar user_id null
        if (u.getRoles() != null) {
            for (Rol r : u.getRoles()) {
                r.setUser(u);
            }
        }

        return repo.save(u);
    }

    @Override
    public List<Usuario> listar() {
        return repo.findAllByOrderByIdUsuarioAsc();
    }

    @Override
    public Usuario ListId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Usuario usuario) {
        // 1. Traigo el usuario existente de BD
        Usuario existing = repo.findById(usuario.getIdUsuario()).orElse(null);

        if (existing != null) {
            // 2. Actualizo campos simples (excepto password, que va aparte)
            existing.setNombreUsuario(usuario.getNombreUsuario());
            existing.setApellidoUsuario(usuario.getApellidoUsuario());
            existing.setEmailUsuario(usuario.getEmailUsuario());
            existing.setFeNacimientoUsuario(usuario.getFeNacimientoUsuario());
            existing.setCondicionmedicaUsuario(usuario.getCondicionmedicaUsuario());
            existing.setMovilidadUsuario(usuario.isMovilidadUsuario());
            existing.setPersonalizadoUsuario(usuario.getPersonalizadoUsuario());
            existing.setVolumenUsuario(usuario.getVolumenUsuario());
            existing.setEnabled(usuario.getEnabled());

            // 🔐 3. Manejo de contraseña
            // Si viene una contraseña nueva (no nula ni vacía), la actualizo encriptada
            if (usuario.getPasswordUsuario() != null &&
                    !usuario.getPasswordUsuario().isBlank()) {

                String nuevaPass = usuario.getPasswordUsuario();

                if (!nuevaPass.startsWith("$2a$")) {
                    // viene en texto plano → encripto
                    existing.setPasswordUsuario(passwordEncoder.encode(nuevaPass));
                } else {
                    // por si ya viene encriptada, la guardo tal cual
                    existing.setPasswordUsuario(nuevaPass);
                }
            }
            // Si viene null o vacía, NO toco la contraseña actual

            // 4. Actualizar rol (asumo 1 rol por usuario)
            if (usuario.getRoles() != null && !usuario.getRoles().isEmpty()) {
                String nuevoRol = usuario.getRoles().get(0).getRol(); // ADMIN / PACIENTE / MEDICO

                if (existing.getRoles() != null && !existing.getRoles().isEmpty()) {
                    // ya tiene un rol → solo le cambio el nombre
                    existing.getRoles().get(0).setRol(nuevoRol);
                } else {
                    // no tenía rol → le creo uno nuevo
                    Rol r = new Rol();
                    r.setRol(nuevoRol);
                    r.setUser(existing); // importante por el nullable = false en user_id
                    existing.getRoles().add(r);
                }
            }

            // 5. Guardo cambios
            repo.save(existing);
        }
    }

    @Override
    public List<Usuario> buscarUsuario(String eUsuario) {
        return repo.buscar(eUsuario);
    }

    @Override
    public List<String[]> cantidadDeRelaciones() {
        return repo.cantidadRelaciones();
    }

    @Override
    public List<String[]> cantidadDeMedicamentos() {
        return repo.cantidadMedicamentos();
    }

    @Override
    public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        return repo.findOneBynombreUsuario(nombreUsuario);
    }
}
