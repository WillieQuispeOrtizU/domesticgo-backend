package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Empleo;
import pe.edu.upc.domesticgo.repositories.IEmpleoRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IEmpleoService;

import java.util.List;

@Service
public class EmpleoServiceImplement implements IEmpleoService {
    @Autowired
    private IEmpleoRepository empRepository;


    // Implementacion de Metodos CRUD
    @Override
    public List<Empleo> list() {
        return empRepository.findAll();
    }

    @Override
    public void insert(Empleo empl) {
        empRepository.save(empl);
    }

    @Override
    public void update(Empleo empl) {
        empRepository.save(empl);
    }

    @Override
    public void delete(int id) {
        empRepository.deleteById(id);
    }

    @Override
    public Empleo searchId(int id) {
        return empRepository.findById(id).orElse(new Empleo());
    }

    // Metodos personalizados

    @Override
    public List<Empleo> searchName(String na) {
        return empRepository.buscarNombre(na);
    }
}
