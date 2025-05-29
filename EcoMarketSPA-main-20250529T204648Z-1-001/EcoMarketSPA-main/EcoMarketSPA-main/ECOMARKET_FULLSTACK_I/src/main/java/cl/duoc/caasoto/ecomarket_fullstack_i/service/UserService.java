package cl.duoc.caasoto.ecomarket_fullstack_i.service;

import cl.duoc.caasoto.ecomarket_fullstack_i.model.User;
import cl.duoc.caasoto.ecomarket_fullstack_i.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    public Optional<User> obtenerUsuario(int id) {
        return userRepository.findById(id);
    }

    public User crearUsuario(User user) {
        return userRepository.save(user);
    }

    public boolean eliminarUsuario(int id) {
        return userRepository.deleteById(id);
    }

    public User actualizarUsuario(int id, User user) {
        return userRepository.update(id, user);
    }
}
