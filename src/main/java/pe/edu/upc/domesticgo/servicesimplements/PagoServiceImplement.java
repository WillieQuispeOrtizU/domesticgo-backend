package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.dtos.TotalPagosDTO;
import pe.edu.upc.domesticgo.entities.Pago;
import pe.edu.upc.domesticgo.repositories.IPagoRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IPagoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class PagoServiceImplement implements IPagoService {
    @Autowired
    private IPagoRepository pagRepository;

    // Implementacion de Metodos CRUD
    @Override
    public List<Pago> list() {
        return pagRepository.findAll();
    }

    @Override
    public void insert(Pago pago) {
        pagRepository.save(pago);
    }

    @Override
    public void update(Pago pago) {
        pagRepository.save(pago);
    }

    @Override
    public void delete(int id) {
        pagRepository.deleteById(id);
    }

    @Override
    public Pago searchId(int id) {
        return pagRepository.findById(id).orElse(new Pago());
    }

    // Implementación de queries personalizadas
    @Override
    public TotalPagosDTO obtenerTotalPagos(LocalDate fechaInicio, LocalDate fechaFin) {
        Long total = pagRepository.contarPagosPorPeriodo(fechaInicio, fechaFin);
        return new TotalPagosDTO(total != null ? total : 0L, fechaInicio, fechaFin);
    }
}
