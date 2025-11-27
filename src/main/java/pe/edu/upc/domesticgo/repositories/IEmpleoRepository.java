package pe.edu.upc.domesticgo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.domesticgo.entities.Empleo;

import java.util.List;

@Repository
public interface IEmpleoRepository extends JpaRepository<Empleo, Integer> {

    @Query("Select e from Empleo e where e.nombreEmpleo like %:na%")
    public List<Empleo> buscarNombre(@Param("na") String na);
}
