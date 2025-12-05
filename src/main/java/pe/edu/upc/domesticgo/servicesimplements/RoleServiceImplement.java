package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Role;
import pe.edu.upc.domesticgo.repositories.IRoleRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void insert(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role searchId(Long id) {
        return roleRepository.findById(id).orElse(new Role());
    }
}