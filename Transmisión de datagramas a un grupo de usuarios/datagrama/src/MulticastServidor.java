import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
public class MulticastServidor extends Thread {
    protected ByteBuffer message = null;
    public MulticastServidor() {
    }
    public static void main(String[] args) {
        MulticastServidor server = new MulticastServidor();
        server.start();
    }
    @Override
    public void run() {
        try {
// send the response to the client at "address" and "port"
            InetAddress address = InetAddress.getByName("226.18.84.25");
            int port = 5239;
            DatagramChannel server = DatagramChannel.open().bind(null);
            System.out.println("Sending datagram packet to group " + address + " on port " + port);
            message = ByteBuffer.wrap("Hello to all listeners".getBytes());
            server.send(message, new InetSocketAddress(address, port));
            server.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}