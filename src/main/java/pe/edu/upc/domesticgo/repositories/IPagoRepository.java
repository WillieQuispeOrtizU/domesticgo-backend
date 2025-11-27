package pe.edu.upc.domesticgo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.domesticgo.entities.Pago;

import java.time.LocalDate;

@Repository
public interface IPagoRepository extends JpaRepository<Pago, Integer> {

    // US04 - Obtener el número total de pagos realizados
    @Query("SELECT COUNT(p) FROM Pago p WHERE p.fechaPago BETWEEN :fechaInicio AND :fechaFin")
    Long contarPagosPorPeriodo(@Param("fechaInicio") LocalDate fechaInicio,
                               @Param("fechaFin") LocalDate fechaFin);
}
