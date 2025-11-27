package pe.edu.upc.domesticgo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.domesticgo.entities.Servicio;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio, Integer> {

    // US02 - Mostrar el número total de servicios pendientes
    @Query("SELECT COUNT(s) FROM Servicio s WHERE s.estadoServicio = 'PENDIENTE'")
    Long contarServiciosPendientes();

    // US03 - Calcular el total de ingresos generados por cada servicio
    @Query("SELECT s.tipoServicio, SUM(p.montoPago) " +
            "FROM Servicio s " +
            "JOIN Pago p ON p.contrato = s.contrato " +
            "GROUP BY s.tipoServicio")
    List<Object[]> calcularIngresosPorTipoServicio();

    // US07 - Mostrar los servicios más solicitados por año, mes y día
    @Query("SELECT r.fechaReserva, s.tipoServicio, COUNT(s) " +
            "FROM Servicio s " +
            "JOIN s.reserva r " +
            "WHERE r.fechaReserva BETWEEN :fechaInicio AND :fechaFin " +
            "GROUP BY r.fechaReserva, s.tipoServicio " +
            "ORDER BY COUNT(s) DESC")
    List<Object[]> mostrarServicioMasSolicitadoPorFecha(@Param("fechaInicio") LocalDate fechaInicio,
                                                        @Param("fechaFin") LocalDate fechaFin);

    // Mostrar los servicios cancelados por cliente dentro de un rango de fechas
    @Query("SELECT s " +
            "FROM Servicio s " +
            "JOIN s.contrato c " +
            "WHERE s.estadoServicio = 'CANCELADO' " +
            "AND s.reserva.fechaReserva BETWEEN :fechaInicio AND :fechaFin " +
            "ORDER BY s.reserva.fechaReserva DESC")
    List<Object[]> mostrarServiciosCanceladosPorCliente(@Param("fechaInicio") LocalDate fechaInicio,
                                                        @Param("fechaFin") LocalDate fechaFin);
}
