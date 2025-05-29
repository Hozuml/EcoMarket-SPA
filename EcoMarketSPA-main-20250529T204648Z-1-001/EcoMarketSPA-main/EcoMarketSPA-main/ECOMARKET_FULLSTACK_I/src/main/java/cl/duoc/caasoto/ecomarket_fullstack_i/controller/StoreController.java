package cl.duoc.caasoto.ecomarket_fullstack_i.controller;

import cl.duoc.caasoto.ecomarket_fullstack_i.model.Store;
import cl.duoc.caasoto.ecomarket_fullstack_i.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiendas")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public ResponseEntity<List<Store>> listar() {
        return ResponseEntity.ok(storeService.listarTiendas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> obtener(@PathVariable int id) {
        return storeService.obtenerTienda(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Store> crear(@RequestBody Store store) {
        return ResponseEntity.status(201).body(storeService.crearTienda(store));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> actualizar(@PathVariable int id, @RequestBody Store store) {
        Store actualizado = storeService.actualizarTienda(id, store);
        return actualizado != null
                ? ResponseEntity.ok(actualizado)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        return storeService.eliminarTienda(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
