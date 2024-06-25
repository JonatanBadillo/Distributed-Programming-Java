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
                    if (ni.isUp() && ni.supportsMulticast()
                            && !ni.isVirtual() && !ni.isLoopback()
                            && ia instanceof java.net.Inet4Address) {
                        networkInterface = ni;
                        break ILOOP;
                    }
                }
            }

            if (networkInterface == null) {
                throw new IOException("No se encontró una interfaz de red adecuada para IPv4 y multicast.");
            }

            // Dirección dentro del rango
            int port = 5239;
            InetAddress group = InetAddress.getByName("226.18.84.25");
            final DatagramChannel client = DatagramChannel.open(StandardProtocolFamily.INET);
            client.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            client.bind(new InetSocketAddress(port));
            client.setOption(StandardSocketOptions.IP_MULTICAST_IF, networkInterface);
            System.out.println("Uniéndose al grupo: " + group + " con la interfaz de red " + networkInterface);

            // Unión al grupo multicast
            MembershipKey key = client.join(group, networkInterface);

            // Recibir mensaje como cliente
            final ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            buffer.clear();
            System.out.println("Esperando recibir mensaje");

            // Configurar el cliente para ser pasivo y no bloqueante (opcional)
            // client.configureBlocking(false);

            client.receive(buffer);
            System.out.println("Cliente recibió mensaje:");
            buffer.flip();
            byte[] arr = new byte[buffer.remaining()];
            buffer.get(arr, 0, arr.length);
            System.out.println(new String(arr));

            System.out.println("Desconectando... realizando una única prueba");
            client.disconnect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
