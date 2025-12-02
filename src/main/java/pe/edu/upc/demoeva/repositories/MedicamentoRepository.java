package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeva.entities.Medicamento;

import java.util.List;
@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    @Query(value="SELECT\n" +
            "    u.id_usuario,\n" +
            "    u.apellido_usuario,\n" +
            "    COUNT(m.id) AS num_medicamentos_activos\n" +
            "FROM\n" +
            "    Medicamentos m\n" +
            "JOIN\n" +
            "    Usuarios u ON m.usuario_id = u.id_usuario\n" +
            "WHERE\n" +
            "    m.activo = TRUE\n" +
            "GROUP BY\n" +
            "    u.id_usuario, u.apellido_usuario\n" +
            "HAVING\n" +
            "    COUNT(m.id) > 3\n" +
            "ORDER BY\n" +
            "    num_medicamentos_activos DESC;", nativeQuery = true)
    public List<String[]> TratamientoCompleto();

}
