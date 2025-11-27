package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.dtos.TotalPagosDTO;
import pe.edu.upc.domesticgo.entities.Pago;

import java.time.LocalDate;
import java.util.List;

public interface IPagoService {
    // Metodos de CRUD
    public List<Pago> list();
    public void insert(Pago user);
    public void update(Pago user);
    public void delete(int id);
    public Pago searchId(int id);

    // Queries personalizadas
    public TotalPagosDTO obtenerTotalPagos(LocalDate fechaInicio, LocalDate fechaFin);
}
