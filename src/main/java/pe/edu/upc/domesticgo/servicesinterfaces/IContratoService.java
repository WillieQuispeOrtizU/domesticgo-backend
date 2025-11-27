package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.dtos.ServiciosContratadosDTO;
import pe.edu.upc.domesticgo.dtos.ClientesRecurrentesDTO;
import pe.edu.upc.domesticgo.entities.Contrato;

import java.util.List;

public interface IContratoService {
    // Metodos de CRUD
    public List<Contrato> list();
    public void insert(Contrato user);
    public void update(Contrato user);
    public void delete(int id);
    public Contrato searchId(int id);

    // Queries personalizadas
    public List<ServiciosContratadosDTO> obtenerServiciosPorMes(int mes, int anio);
    public ClientesRecurrentesDTO obtenerClientesRecurrentes();
}
