import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class SocketCliente {
    public static Socket socket = null;
    public static PrintWriter out;
    public static BufferedReader in;


    public static void main(String[] args) {
        // establece una conexión con el servidor ubicado en 127.0.0.1 (localhost) en el puerto 1234.
        createConnection("127.0.0.1", 1234);
    }

    public static void createConnection(String host, int port) {
        try {
            // Crea la conexión del socket, con el puerto y host establecido
            socket = new Socket(host, port);
            // Se obtiene un PrintWriter para enviar datos al servidor.
            out = new PrintWriter(socket.getOutputStream(),
                    true);
            // Se obtiene un BufferedReader para leer datos del servidor.
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            // Se llama al método testConnection para realizar una prueba de comunicación con el servidor.
            testConnection();

            // Finalmente, se cierran los recursos de entrada y salida.
            System.out.println("Closing the connection...");
            out.close();
            in.close();
            socket.close();
            System.exit(1);
        } catch (UnknownHostException e) {
            System.out.println(e);
            System.exit(1);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
    }



    public static void testConnection() {
        String serverResponse = null;
        if (socket != null && in != null && out != null) {
            // manda msj que todo bien
            System.out.println("Successfully connected, now testing...");
            try {
                // Se envía una cadena de texto al servidor.
                out.println("Here is a test.");
                // Se lee la respuesta del servidor y se imprime en la consola.
                while((serverResponse = in.readLine()) != null)
                    System.out.println(serverResponse);
            } catch (IOException e) {
                System.out.println(e);
                System.exit(1);
            }
        }
    }
}