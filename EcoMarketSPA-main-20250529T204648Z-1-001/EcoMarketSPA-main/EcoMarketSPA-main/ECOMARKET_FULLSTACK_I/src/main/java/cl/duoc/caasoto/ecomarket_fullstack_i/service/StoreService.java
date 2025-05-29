package cl.duoc.caasoto.ecomarket_fullstack_i.service;

import cl.duoc.caasoto.ecomarket_fullstack_i.model.Store;
import cl.duoc.caasoto.ecomarket_fullstack_i.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> listarTiendas() {
        return storeRepository.findAll();
    }

    public Optional<Store> obtenerTienda(int id) {
        return storeRepository.findById(id);
    }

    public Store crearTienda(Store store) {
        return storeRepository.save(store);
    }

    public boolean eliminarTienda(int id) {
        return storeRepository.deleteById(id);
    }

    public Store actualizarTienda(int id, Store store) {
        return storeRepository.update(id, store);
    }
}
