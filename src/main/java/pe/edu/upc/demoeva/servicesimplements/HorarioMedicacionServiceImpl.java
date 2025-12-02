package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeva.entities.HorariosMedicacion;
import pe.edu.upc.demoeva.repositories.HorariosMedicacionRepository;
import pe.edu.upc.demoeva.servicesinterfaces.HorarioMedicacionService;

import java.util.List;

@Service
public class HorarioMedicacionServiceImpl implements HorarioMedicacionService {
    @Autowired
    private HorariosMedicacionRepository hmR;

    @Override
    public void insertar(HorariosMedicacion hm) {
        hmR.save(hm);
    }

    @Override
    public List<HorariosMedicacion> listar() {
        return hmR.findAll();
    }

    @Override
    public void update(HorariosMedicacion f) {
        hmR.save(f);
    }

    @Override
    public void delete(Long id) {
        hmR.deleteById(id);
    }
}
