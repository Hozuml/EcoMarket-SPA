package cl.duoc.caasoto.ecomarket_fullstack_i.repository;

import cl.duoc.caasoto.ecomarket_fullstack_i.model.Store;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StoreRepository {

    private final List<Store> stores = new ArrayList<>();
    private int idActual = 1;

    public List<Store> findAll() {
        return stores;
    }

    public Optional<Store> findById(int id) {
        return stores.stream().filter(s -> s.getId() == id).findFirst();
    }

    public Store save(Store store) {
        store.setId(idActual++);
        stores.add(store);
        return store;
    }

    public boolean deleteById(int id) {
        return stores.removeIf(s -> s.getId() == id);
    }

    public Store update(int id, Store data) {
        return findById(id).map(store -> {
            store.setNombre(data.getNombre());
            store.setDireccion(data.getDireccion());
            store.setCiudad(data.getCiudad());
            store.setTelefono(data.getTelefono());
            return store;
        }).orElse(null);
    }
}
