import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.MembershipKey;

public class MulticastCliente {
    public MulticastCliente() {
    }

    public static void main(String[] args) {
        // El código busca una interfaz de red que sea compatible con IPv4 y soporte multicast.
        // Utiliza un bucle para revisar todas las interfaces de red disponibles y
        // selecciona la primera que cumpla los criterios.
        try {
            // Obtener la interfaz de red compatible con IPv4 y multicast
            NetworkInterface networkInterface = null;
            java.util.Enumeration<NetworkInterface> enumNI = NetworkInterface.getNetworkInterfaces();
            java.util.Enumeration<InetAddress> enumIA;
            NetworkInterface ni;
            InetAddress ia;
            ILOOP:
            while (enumNI.hasMoreElements()) {
                ni = enumNI.nextElement();
                enumIA = ni.getInetAddresses();
                while (enumIA.hasMoreElements()) {
                    ia = enumIA.nextElement();
                    // Selecciona la primera interfaz que esté activa, soporte multicast,
                    // no sea virtual ni de loopback y sea IPv4.
                    if (ni.isUp() && ni.supportsMulticast()
                            && !ni.isVirtual() && !ni.isLoopback()
                            && ia instanceof java.net.Inet4Address) {
                        networkInterface = ni;
                        break ILOOP; // Sale del bucle una vez que se encuentra la interfaz adecuada.
                    }
                }
            }

            if (networkInterface == null) {
                throw new IOException("No se encontró una interfaz de red adecuada para IPv4 y multicast.");
            }

            // Dirección dentro del rango del grupo multicast al que se unirá el cliente.
            int port = 5239;
            InetAddress group = InetAddress.getByName("226.18.84.25");

            // Abre un DatagramChannel usando IPv4 (StandardProtocolFamily.INET).
            final DatagramChannel client = DatagramChannel.open(StandardProtocolFamily.INET);

            // Configura opciones del socket: reutilización de dirección y la interfaz de red a utilizar.
            client.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            client.bind(new InetSocketAddress(port));
            client.setOption(StandardSocketOptions.IP_MULTICAST_IF, networkInterface);
            System.out.println("Uniéndose al grupo: " + group + " con la interfaz de red " + networkInterface);

            // Se une al grupo multicast especificado usando la interfaz de red seleccionada.
            MembershipKey key = client.join(group, networkInterface);

            // Prepara un buffer directo de 4096 bytes para recibir datos del servidor multicast.
            final ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            buffer.clear();
            System.out.println("Esperando recibir mensaje");

            // Recibe datos del servidor multicast y los almacena en el buffer.
            client.receive(buffer);
            System.out.println("Cliente recibió mensaje:");
            buffer.flip(); // Prepara el buffer para leer los datos recibidos.
            byte[] arr = new byte[buffer.remaining()];
            buffer.get(arr, 0, arr.length);
            System.out.println(new String(arr)); // Convierte los datos recibidos a String y los imprime.

            System.out.println("Desconectando... realizando una única prueba");
            client.disconnect(); // Desconecta el canal de datagramas del grupo multicast.
        } catch (IOException ex) {
            ex.printStackTrace(); // Maneja cualquier excepción de E/S imprimiendo el rastreo de la pila.
        }
    }
}
