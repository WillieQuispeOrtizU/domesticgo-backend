package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.dtos.*;
import pe.edu.upc.domesticgo.entities.Servicio;
import pe.edu.upc.domesticgo.repositories.IServicioRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IServicioService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class ServicioServiceImplement implements IServicioService {
    @Autowired
    private IServicioRepository serRepository;
    @Autowired
    private IServicioRepository iServicioRepository;

    // Implementacion de Metodos CRUD
    @Override
    public List<Servicio> list() {
        return serRepository.findAll();
    }

    @Override
    public void insert(Servicio serv) {
        serRepository.save(serv);
    }

    @Override
    public void update(Servicio serv) {
        serRepository.save(serv);
    }

    @Override
    public void delete(int id) {
        serRepository.deleteById(id);
    }

    @Override
    public Servicio searchId(int id) {
        return serRepository.findById(id).orElse(new Servicio());
    }

    // Implementación de queries personalizadas
    @Override
    public ServiciosPendientesDTO obtenerServiciosPendientes() {
        Long total = serRepository.contarServiciosPendientes();
        return new ServiciosPendientesDTO(total != null ? total : 0L);
    }

    @Override
    public List<IngresosPorServicioDTO> obtenerIngresosPorServicio() {
        List<Object[]> results = serRepository.calcularIngresosPorTipoServicio();
        List<IngresosPorServicioDTO> dtos = new ArrayList<>();

        for (Object[] result : results) {
            IngresosPorServicioDTO dto = new IngresosPorServicioDTO();
            dto.setTipoServicio((String) result[0]);
            dto.setTotalIngresos((Double) result[1]);
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public List<TotalServiciosSolicitadoDTO> getMostRequestedServiceByDate(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Object[]> results = serRepository.mostrarServicioMasSolicitadoPorFecha(fechaInicio, fechaFin);

        List<TotalServiciosSolicitadoDTO> services = new ArrayList<>();

        for (Object[] result : results) {
            String tipoServicio = (String) result[1];
            Long cantidad = (Long) result[2];

            TotalServiciosSolicitadoDTO serviceDTO = new TotalServiciosSolicitadoDTO(tipoServicio, cantidad);
            services.add(serviceDTO);
        }

        return services;
    }


    @Override
    public List<ServicioCanceladoDTO> getCancelledServicesByClient(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Object[]> results = serRepository.mostrarServiciosCanceladosPorCliente(fechaInicio, fechaFin);

        List<ServicioCanceladoDTO> services = new ArrayList<>();
        for (Object[] result : results) {
            Servicio servicio = (Servicio) result[0];

            if ("CANCELADO".equals(servicio.getEstadoServicio())) {
                ServicioCanceladoDTO serviceDTO = new ServicioCanceladoDTO(
                        servicio.getIdServicio(),
                        servicio.getEstadoServicio(),
                        servicio.getTipoServicio()
                );
                services.add(serviceDTO);
            }
        }

        return services;
    }
}