package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeva.entities.Fotos;

import java.util.List;

@Repository
public interface FotosRepository extends JpaRepository<Fotos, Long> {
    @Query(value="SELECT \n" +
            "    u.apellido_usuario AS usuario,\n" +
            "    COUNT(f.id) AS cantidad_fotos\n" +
            "FROM \n" +
            "    Fotos f\n" +
            "JOIN \n" +
            "    usuarios u ON f.id_usuario = u.id_usuario\n" +
            "GROUP BY \n" +
            "    u.apellido_usuario\n" +
            "ORDER BY \n" +
            "    cantidad_fotos DESC;",nativeQuery = true)
    public List<String[]> MasFotos();

    List<Fotos> findByIdUsuario_IdUsuarioOrderByIdAsc(int idUsuario);



}
