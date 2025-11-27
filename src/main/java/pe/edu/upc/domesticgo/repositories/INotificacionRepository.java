package pe.edu.upc.domesticgo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.domesticgo.entities.Notificacion;

import java.util.List;

@Repository
public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {

    // Consulta para contar las notificaciones de cada usuario
    @Query("SELECT n.usuario.idUsuario AS idUsuario, COUNT(n) AS cantidadNotificaciones " +
            "FROM Notificacion n " +
            "GROUP BY n.usuario.idUsuario")
    List<Object[]> countNotificationsByUser();
}
