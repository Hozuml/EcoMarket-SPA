package cl.duoc.caasoto.ecomarket_fullstack_i.controller;

import cl.duoc.caasoto.ecomarket_fullstack_i.model.User;
import cl.duoc.caasoto.ecomarket_fullstack_i.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listar() {
        return ResponseEntity.ok(userService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> obtener(@PathVariable int id) {
        return userService.obtenerUsuario(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> crear(@RequestBody User user) {
        return ResponseEntity.status(201).body(userService.crearUsuario(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> actualizar(@PathVariable int id, @RequestBody User user) {
        User actualizado = userService.actualizarUsuario(id, user);
        return actualizado != null
                ? ResponseEntity.ok(actualizado)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        return userService.eliminarUsuario(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
