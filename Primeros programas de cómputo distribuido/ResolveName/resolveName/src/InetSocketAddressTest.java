package inetsocketaddresstest;

import java.net.InetSocketAddress;

public class InetSocketAddressTest {

    public static void main(String[] args) {
        // Crea una dirección de socket con la dirección loopback IPv6 (::1) y puerto 12889
        InetSocketAddress addr1 = new InetSocketAddress("::1", 12889);
        System.out.println("Detalles de la dirección de socket 1:");
        printSocketAddress(addr1);

        // Crea una dirección de socket no resuelta con la dirección loopback IPv6 (::1) y puerto 12881
        InetSocketAddress addr2 = InetSocketAddress.createUnresolved("::1", 12881);
        System.out.println("Detalles de la dirección de socket 2:");
        printSocketAddress(addr2);
    }

    public static void printSocketAddress(InetSocketAddress sAddr) {
        // Imprime la dirección IP del socket
        System.out.println("Dirección IP del socket: " + sAddr.getAddress());

        // Imprime el nombre de host del socket (puede ser nulo si no está resuelto)
        System.out.println("Nombre de host del socket: " + sAddr.getHostName());

        // Imprime el puerto del socket
        System.out.println("Puerto del socket: " + sAddr.getPort());

        // Verifica si la dirección de socket está no resuelta
        System.out.println("isUnresolved(): " + sAddr.isUnresolved());

        // Línea en blanco para mejor separación
        System.out.println();
    }
}
