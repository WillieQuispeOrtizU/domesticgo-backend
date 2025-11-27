package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.Empleo;

import java.util.List;

public interface IEmpleoService {
    // Metodos de CRUD
    public List<Empleo> list();
    public void insert(Empleo user);
    public void update(Empleo user);
    public void delete(int id);
    public Empleo searchId(int id);
    // Metodos de Personalizados
    public List<Empleo> searchName(String tipo);
}
