package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeva.entities.TipoAlerta;
@Repository
public interface TipoAlertaRepository extends JpaRepository<TipoAlerta, Long> { }