package cl.duoc.caasoto.ecomarket_fullstack_i.controller;

import cl.duoc.caasoto.ecomarket_fullstack_i.model.Order;
import cl.duoc.caasoto.ecomarket_fullstack_i.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> listar() {
        return ResponseEntity.ok(orderService.listarPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> obtener(@PathVariable int id) {
        return orderService.obtenerPedido(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Order> crear(@RequestBody Order order) {
        return ResponseEntity.status(201).body(orderService.crearPedido(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> actualizar(@PathVariable int id, @RequestBody Order order) {
        Order actualizado = orderService.actualizarPedido(id, order);
        return actualizado != null
                ? ResponseEntity.ok(actualizado)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        return orderService.eliminarPedido(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
