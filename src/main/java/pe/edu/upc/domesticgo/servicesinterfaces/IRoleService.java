package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role role);
    public List<Role> list();
    public void delete(Long id);
    public Role searchId(Long id);
}