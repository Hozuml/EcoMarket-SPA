package cl.duoc.caasoto.ecomarket_fullstack_i.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private int id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;
}
