package cl.duoc.caasoto.ecomarket_fullstack_i.service;

import cl.duoc.caasoto.ecomarket_fullstack_i.model.Order;
import cl.duoc.caasoto.ecomarket_fullstack_i.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> listarPedidos() {
        return orderRepository.findAll();
    }

    public Optional<Order> obtenerPedido(int id) {
        return orderRepository.findById(id);
    }

    public Order crearPedido(Order order) {
        return orderRepository.save(order);
    }

    public boolean eliminarPedido(int id) {
        return orderRepository.deleteById(id);
    }

    public Order actualizarPedido(int id, Order order) {
        return orderRepository.update(id, order);
    }
}
