package cl.duoc.caasoto.ecomarket_fullstack_i.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private int userId;
    private List<Integer> productIds;
    private String estado;
    private String direccionEnvio;
}
