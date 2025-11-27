package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.dtos.ServiciosContratadosDTO;
import pe.edu.upc.domesticgo.dtos.ClientesRecurrentesDTO;
import pe.edu.upc.domesticgo.entities.Contrato;
import pe.edu.upc.domesticgo.repositories.IContratoRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IContratoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContratoServiceImplement implements IContratoService {
    @Autowired
    private IContratoRepository conRepository;

    // Implementacion de Metodos CRUD
    @Override
    public List<Contrato> list() {
        return conRepository.findAll();
    }

    @Override
    public void insert(Contrato cont) {
        conRepository.save(cont);
    }

    @Override
    public void update(Contrato cont) {
        conRepository.save(cont);
    }

    @Override
    public void delete(int id) {
        conRepository.deleteById(id);
    }

    @Override
    public Contrato searchId(int id) {
        return conRepository.findById(id).orElse(new Contrato());
    }

    // Implementación de queries personalizadas
    @Override
    public List<ServiciosContratadosDTO> obtenerServiciosPorMes(int mes, int anio) {
        List<Object[]> results = conRepository.contarServiciosPorMes(mes, anio);
        List<ServiciosContratadosDTO> dtos = new ArrayList<>();

        for (Object[] result : results) {
            ServiciosContratadosDTO dto = new ServiciosContratadosDTO();
            dto.setMes((Integer) result[0]);
            dto.setAnio((Integer) result[1]);
            dto.setTotalServicios((Long) result[2]);
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public ClientesRecurrentesDTO obtenerClientesRecurrentes() {
        Long total = conRepository.contarClientesRecurrentes();
        return new ClientesRecurrentesDTO(total != null ? total : 0L);
    }
}
