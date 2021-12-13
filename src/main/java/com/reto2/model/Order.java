package com.reto2.model;

/**
 * <h1>User </h1>
 * Clase order crea la tabla order con sus variables
 *
 * @since 12-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Document(collection = "orders")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";
    /**
     * Definicion de variables de la tabla hairproducts
     */
    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;
    private Map<String, Hairproducts> products;
    private Map<String, Integer> quantities;

}
