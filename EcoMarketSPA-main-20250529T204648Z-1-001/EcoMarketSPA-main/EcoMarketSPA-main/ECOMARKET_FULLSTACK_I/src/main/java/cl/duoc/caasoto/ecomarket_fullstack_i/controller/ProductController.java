package cl.duoc.caasoto.ecomarket_fullstack_i.controller;

import cl.duoc.caasoto.ecomarket_fullstack_i.model.Product;
import cl.duoc.caasoto.ecomarket_fullstack_i.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listar() {
        return ResponseEntity.ok(productService.listarProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> obtener(@PathVariable int id) {
        return productService.obtenerProducto(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> crear(@RequestBody Product product) {
        return ResponseEntity.status(201).body(productService.crearProducto(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> actualizar(@PathVariable int id, @RequestBody Product product) {
        Product actualizado = productService.actualizarProducto(id, product);
        return actualizado != null
                ? ResponseEntity.ok(actualizado)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        return productService.eliminarProducto(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
