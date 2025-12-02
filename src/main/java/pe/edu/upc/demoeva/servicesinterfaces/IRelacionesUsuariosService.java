package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.RelacionesUsuarios;
import pe.edu.upc.demoeva.entities.Usuario;

import java.util.List;

public interface IRelacionesUsuariosService {
    RelacionesUsuarios insert(RelacionesUsuarios relacionesUsuarios);
    List<RelacionesUsuarios> list();
    public RelacionesUsuarios ListId(int id);
    public void delete(int id);
    public void update(RelacionesUsuarios relacionesUsuarios);
    public List<RelacionesUsuarios> buscarRelaciones(String nombre, String apellido);
    public List<String[]> cantidadUsuariosSinFamiliares();
    public List<String[]> cantidadRelacionesPorMovilidad();

}
