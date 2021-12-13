package com.reto2;

/**
 * <h1>main </h1>
 * Clase main corre el programa
 *
 * @since 12-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.reto2.interfaces.OrderInterface;
import com.reto2.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import com.reto2.interfaces.InterfaceHairproducts;

@Component
@SpringBootApplication
public class Reto2Application implements CommandLineRunner {

    @Autowired
    private InterfaceHairproducts gadgetInterface;
    @Autowired
    private UserInterface userInterface;
    /**
     * llamado a la interface user
     */
    @Autowired
    private OrderInterface orderInterface;

    public static void main(String[] args) {
        SpringApplication.run(Reto2Application.class, args);
    }

    /**
     *
     * @param args metodo para limpiado de tablas
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        gadgetInterface.deleteAll();
        userInterface.deleteAll();
        orderInterface.deleteAll();
    }
}
