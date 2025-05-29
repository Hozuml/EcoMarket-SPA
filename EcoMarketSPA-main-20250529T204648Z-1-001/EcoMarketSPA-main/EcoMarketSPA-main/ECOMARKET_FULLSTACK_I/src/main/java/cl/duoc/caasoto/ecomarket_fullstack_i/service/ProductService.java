package cl.duoc.caasoto.ecomarket_fullstack_i.service;

import cl.duoc.caasoto.ecomarket_fullstack_i.model.Product;
import cl.duoc.caasoto.ecomarket_fullstack_i.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listarProductos() {
        return productRepository.findAll();
    }

    public Optional<Product> obtenerProducto(int id) {
        return productRepository.findById(id);
    }

    public Product crearProducto(Product product) {
        return productRepository.save(product);
    }

    public boolean eliminarProducto(int id) {
        return productRepository.deleteById(id);
    }

    public Product actualizarProducto(int id, Product product) {
        return productRepository.update(id, product);
    }
}
