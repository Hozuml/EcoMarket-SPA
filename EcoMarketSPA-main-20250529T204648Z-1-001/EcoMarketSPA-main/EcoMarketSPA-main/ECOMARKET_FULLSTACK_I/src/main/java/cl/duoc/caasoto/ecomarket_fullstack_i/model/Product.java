package cl.duoc.caasoto.ecomarket_fullstack_i.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String categoria;
}
