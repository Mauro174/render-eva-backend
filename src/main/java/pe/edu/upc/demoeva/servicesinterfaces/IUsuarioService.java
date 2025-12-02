package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.Usuario;

import java.time.LocalDate;
import java.util.List;

public interface IUsuarioService {
    Usuario insertar(Usuario u);
    List<Usuario> listar();
    public Usuario ListId(int id);
    public void delete(int id);
    public void update(Usuario usuario);
    public List<Usuario> buscarUsuario(String eUsuario);
    public List<String[]> cantidadDeRelaciones();
    public List<String[]> cantidadDeMedicamentos();
    Usuario buscarPorNombreUsuario(String nombreUsuario);

}
