package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeva.entities.RelacionesUsuarios;

import java.util.List;

@Repository
public interface RelacionesUsuariosRepository extends JpaRepository<RelacionesUsuarios,Integer> {
    @Query(value = "select s.*\n" +
            " from relaciones_usuarios s inner join usuarios l\n" +
            " on l.id_usuario=s.usuario_id\n" +
            " where l.nombre_usuario=:nombre and l.apellido_usuario=:apellido",nativeQuery = true)
    public List<RelacionesUsuarios> buscar(@Param("nombre") String nombre,@Param("apellido") String apellido  );

    @Query(value = "SELECT u.condicionmedica_usuario, COUNT(u.id_usuario) AS usuariosSinFamiliares " +
            "FROM usuarios u " +
            "LEFT JOIN relaciones_usuarios r " +
            "ON u.id_usuario = r.usuario_id AND r.tipo_relacion = 'Parentesco directo' " +
            "WHERE r.id_relacion IS NULL and u.condicionmedica_usuario<>'Ninguna' " +
            "GROUP BY u.condicionmedica_usuario", nativeQuery = true)
    public List<String[]> cantidadUsuariosSinFamiliares();

    @Query(value = "SELECT u.movilidad_usuario, COUNT(r.id_relacion) AS cantidadRelaciones " +
            "FROM usuarios u " +
            "LEFT JOIN relaciones_usuarios r ON u.id_usuario = r.usuario_id " +
            "GROUP BY u.movilidad_usuario", nativeQuery = true)
    public List<String[]> cantidadRelacionesPorMovilidad();


}
