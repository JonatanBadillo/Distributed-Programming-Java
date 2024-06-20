/*
 * Este programa demuestra cómo resolver un nombre de host (dominio) a su correspondiente dirección IP.
 * Actualmente solo muestra ejemplos para "localhost" y "www.facebook.com".
 */
package resolvename;

import java.net.*;

public class ResolveName {

    public static void main(String[] args) {
        // Declarar una variable de tipo InetAddress para almacenar la dirección IP resuelta
        InetAddress address;

        try {
            // Intentar resolver el nombre de host "localhost" y almacenar la dirección IP
            address = InetAddress.getByName("localhost");
            System.out.println("La dirección IP de 'localhost' es: " + address.getHostAddress());

            // Intentar resolver el nombre de host "www.facebook.com" y almacenar la dirección IP
            address = InetAddress.getByName("www.facebook.com");
            System.out.println("La dirección IP de 'www.facebook.com' es: " + address.getHostAddress());

            // Imprimir información adicional sobre el objeto InetAddress (podría incluir más que la IP)
            System.out.println(address);
        } catch (UnknownHostException e) {
            // Manejar la excepción si el nombre de host no se puede resolver
            System.err.println("Error: No se pudo resolver el nombre de host. " + e.getMessage());
        }
    }
}
