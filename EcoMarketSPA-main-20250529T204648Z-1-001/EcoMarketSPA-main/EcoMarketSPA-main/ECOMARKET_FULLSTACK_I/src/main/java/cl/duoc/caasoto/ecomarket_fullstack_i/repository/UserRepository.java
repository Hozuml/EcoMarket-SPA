package cl.duoc.caasoto.ecomarket_fullstack_i.repository;

import cl.duoc.caasoto.ecomarket_fullstack_i.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();
    private int idActual = 1; // int, no Integer

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst(); // ← comparación con ==
    }

    public User save(User user) {
        user.setId(idActual++);
        users.add(user);
        return user;
    }

    public boolean deleteById(int id) {
        return users.removeIf(u -> u.getId() == id); // ← comparación con ==
    }

    public User update(int id, User datos) {
        return findById(id).map(user -> {
            user.setNombre(datos.getNombre());
            user.setApellido(datos.getApellido());
            user.setEmail(datos.getEmail());
            user.setTelefono(datos.getTelefono());
            user.setDireccion(datos.getDireccion());
            user.setRol(datos.getRol());
            return user;
        }).orElse(null);
    }
}
