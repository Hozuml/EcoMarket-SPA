package cl.duoc.caasoto.ecomarket_fullstack_i.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private String rol;
}
