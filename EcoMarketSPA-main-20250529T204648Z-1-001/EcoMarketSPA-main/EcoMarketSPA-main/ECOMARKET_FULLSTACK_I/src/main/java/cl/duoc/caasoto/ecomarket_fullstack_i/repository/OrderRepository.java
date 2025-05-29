package cl.duoc.caasoto.ecomarket_fullstack_i.repository;

import cl.duoc.caasoto.ecomarket_fullstack_i.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();
    private int idActual = 1;

    public List<Order> findAll() {
        return orders;
    }

    public Optional<Order> findById(int id) {
        return orders.stream().filter(o -> o.getId() == id).findFirst();
    }

    public Order save(Order order) {
        order.setId(idActual++);
        orders.add(order);
        return order;
    }

    public boolean deleteById(int id) {
        return orders.removeIf(o -> o.getId() == id);
    }

    public Order update(int id, Order data) {
        return findById(id).map(order -> {
            order.setUserId(data.getUserId());
            order.setProductIds(data.getProductIds());
            order.setEstado(data.getEstado());
            order.setDireccionEnvio(data.getDireccionEnvio());
            return order;
        }).orElse(null);
    }
}
