package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.demoeva.entities.Usuario;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findOneBynombreUsuario(String nombreUsuario);

    @Query("select s from Usuario s where s.emailUsuario =:eUsuario")
    public List<Usuario> buscar(@Param("eUsuario") String eUsuario );

    @Query(value = "select s.nombre_usuario, l.tipo_relacion,count(l.id_relacion)\n" +
            " from usuarios s inner join relaciones_usuarios l\n" +
            " on s.id_usuario=l.usuario_id\n" +
            " group by s.nombre_usuario,l.tipo_relacion order by s.nombre_usuario",nativeQuery = true)
    public List<String[]> cantidadRelaciones();

    @Query(value = "select s.nombre_usuario, SUM(CASE WHEN l.activo THEN 1 ELSE 0 END) AS activos,\n" +
            "SUM(CASE WHEN NOT l.activo THEN 1 ELSE 0 END) AS inactivos,\n"+
            "COUNT(*) AS total\n"+
            " from usuarios s inner join medicamentos l\n" +
            " on s.id_usuario=l.usuario_id\n" +
            " group by s.nombre_usuario",nativeQuery = true)
    public List<String[]> cantidadMedicamentos();

    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    List<Usuario> findAllByOrderByIdUsuarioAsc();

}
