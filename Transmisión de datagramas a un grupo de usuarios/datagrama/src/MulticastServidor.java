import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class MulticastServidor extends Thread {
    protected ByteBuffer message = null;

    public MulticastServidor() {
        // Constructor vacío por defecto
    }

    public static void main(String[] args) {
        // Crear una instancia del servidor y comenzar su ejecución en un nuevo hilo
        MulticastServidor server = new MulticastServidor();
        server.start();
    }

    @Override
    public void run() {
        try {
            // Dirección IP del grupo multicast al que se enviará el mensaje
            InetAddress address = InetAddress.getByName("226.18.84.25");
            int port = 5239;

            // Abrir un DatagramChannel y enlazarlo a cualquier dirección disponible
            DatagramChannel server = DatagramChannel.open().bind(null);

            // Imprimir mensaje informativo sobre el envío del paquete datagrama
            System.out.println("Sending datagram packet to group " + address + " on port " + port);

            // Preparar el mensaje a enviar convirtiéndolo en un ByteBuffer
            message = ByteBuffer.wrap("Hello to all listeners".getBytes());

            // Enviar el mensaje a la dirección y puerto especificados
            server.send(message, new InetSocketAddress(address, port));

            // Desconectar el canal de datagramas después de enviar el mensaje
            server.disconnect();
        } catch (IOException e) {
            // Capturar y manejar cualquier excepción de E/S imprimiendo el rastreo de la pila
            e.printStackTrace();
        }
    }
}
