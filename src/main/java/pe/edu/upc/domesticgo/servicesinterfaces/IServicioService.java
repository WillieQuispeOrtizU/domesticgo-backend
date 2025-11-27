package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.dtos.*;
import pe.edu.upc.domesticgo.entities.Servicio;

import java.time.LocalDate;
import java.util.List;

public interface IServicioService {
    // Metodos de CRUD
    public List<Servicio> list();

    public void insert(Servicio user);

    public void update(Servicio user);

    public void delete(int id);

    public Servicio searchId(int id);

    // Queries personalizadas
    public ServiciosPendientesDTO obtenerServiciosPendientes();

    public List<IngresosPorServicioDTO> obtenerIngresosPorServicio();

    List<TotalServiciosSolicitadoDTO> getMostRequestedServiceByDate(LocalDate fechaInicio, LocalDate fechaFin);

    public List<ServicioCanceladoDTO> getCancelledServicesByClient(LocalDate fechaInicio, LocalDate fechaFin);
}