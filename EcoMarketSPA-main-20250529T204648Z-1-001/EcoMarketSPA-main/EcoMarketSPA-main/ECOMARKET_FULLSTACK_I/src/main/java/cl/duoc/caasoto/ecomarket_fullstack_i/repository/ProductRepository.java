package cl.duoc.caasoto.ecomarket_fullstack_i.repository;

import cl.duoc.caasoto.ecomarket_fullstack_i.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();
    private int idActual = 1;

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }

    public Product save(Product product) {
        product.setId(idActual++);
        products.add(product);
        return product;
    }

    public boolean deleteById(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    public Product update(int id, Product datos) {
        return findById(id).map(product -> {
            product.setNombre(datos.getNombre());
            product.setDescripcion(datos.getDescripcion());
            product.setPrecio(datos.getPrecio());
            product.setStock(datos.getStock());
            product.setCategoria(datos.getCategoria());
            return product;
        }).orElse(null);
    }
}
