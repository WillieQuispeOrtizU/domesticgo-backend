package pe.edu.upc.domesticgo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.domesticgo.entities.Contrato;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IContratoRepository extends JpaRepository<Contrato, Integer> {

    // US01 - Calcular el total de servicios contratados por mes
    @Query("SELECT MONTH(c.fechaInicio) as mes, YEAR(c.fechaInicio) as anio, COUNT(c) as total " +
            "FROM Contrato c " +
            "WHERE MONTH(c.fechaInicio) = :mes AND YEAR(c.fechaInicio) = :anio " +
            "GROUP BY MONTH(c.fechaInicio), YEAR(c.fechaInicio)")
    List<Object[]> contarServiciosPorMes(@Param("mes") int mes, @Param("anio") int anio);

    // US06 - Clientes que han solicitado más de un servicio
    @Query("SELECT COUNT(DISTINCT c.contratante) " +
            "FROM Contrato c " +
            "GROUP BY c.contratante " +
            "HAVING COUNT(c) > 1")
    Long contarClientesRecurrentes();
}
