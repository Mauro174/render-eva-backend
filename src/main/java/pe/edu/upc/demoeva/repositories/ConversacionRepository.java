package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeva.entities.Conversacion;
@Repository
public interface ConversacionRepository extends JpaRepository<Conversacion, Long> { }
