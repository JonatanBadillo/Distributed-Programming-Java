package inetaddresstest;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressTest {

    public static void main(String[] args) {
        // Imprime los detalles de la dirección de "www.yahoo.com"
        printAddressDetails("www.yahoo.com");

        // Imprime los detalles de la dirección loopback (localhost)
        printAddressDetails(null);

        // Imprime los detalles de la dirección loopback usando formato IPv6
        printAddressDetails("::1");
    }

    public static void printAddressDetails(String host) {
        System.out.println("Nombre de host: " + host);

        try {
            // Obtiene la dirección IP del host usando InetAddress.getByName()
            InetAddress addr = InetAddress.getByName(host);

            // Imprime la dirección IP del host
            System.out.println("Dirección IP del host: " + addr.getHostAddress());

            // Imprime el nombre canónico del host (nombre completo)
            System.out.println("Nombre canónico del host: " + addr.getCanonicalHostName());

            // Verifica si el host es accesible con un tiempo de espera de 10 segundos
            int timeOutinMillis = 10000;
            System.out.println("isReachable(): " + addr.isReachable(timeOutinMillis));

            // Verifica si el host es la dirección loopback (localhost)
            System.out.println("isLoopbackAddress(): " + addr.isLoopbackAddress());

        } catch (IOException e) {
            // Imprime detalles de la excepción en caso de error
            e.printStackTrace();
        } finally {
            // Imprime una línea separadora para una mejor visualización
            System.out.println("-------------------------------\n");
        }
    }
}
