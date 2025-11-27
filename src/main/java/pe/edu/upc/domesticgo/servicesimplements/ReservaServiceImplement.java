package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Reserva;
import pe.edu.upc.domesticgo.repositories.IReservaRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IReservaService;

import java.util.List;

@Service
public class ReservaServiceImplement implements IReservaService {
    @Autowired
    private IReservaRepository resRepository;


    // Implementacion de Metodos CRUD
    @Override
    public List<Reserva> list() {
        return resRepository.findAll();
    }

    @Override
    public void insert(Reserva rese) {
        resRepository.save(rese);
    }

    @Override
    public void update(Reserva rese) {
        resRepository.save(rese);
    }

    @Override
    public void delete(int id) {
        resRepository.deleteById(id);
    }

    @Override
    public Reserva searchId(int id) {
        return resRepository.findById(id).orElse(new Reserva());
    }
}
