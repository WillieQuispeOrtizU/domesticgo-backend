package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.dtos.PromedioReseniaDTO;
import pe.edu.upc.domesticgo.dtos.ReseniasPorTrabajadorDTO;
import pe.edu.upc.domesticgo.entities.Resenia;

import java.util.List;

public interface IReseniaService {
    // Metodos de CRUD
    public List<Resenia> list();
    public void insert(Resenia user);
    public void update(Resenia user);
    public void delete(int id);
    public Resenia searchId(int id);

    // Queries personalizadas
    public List<ReseniasPorTrabajadorDTO> obtenerReseniasPorTrabajador();
    List<PromedioReseniaDTO> obtenerPromedioCalificacionesPorUsuario();
}
