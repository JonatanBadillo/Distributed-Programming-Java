// Problema
// Quieres crear una aplicación de servidor que escuche las conexiones de un cliente remoto.

// Solución
// Configura una aplicación del lado del servidor que utilice java.net.ServerSocket para
// escuchar solicitudes en un puerto específico. La siguiente clase Java es representativa de una
// que se implementaría en un servidor y escucha las solicitudes entrantes en el puerto 1234.
// Cuando se recibe una solicitud, el mensaje entrante se imprime en la línea de comando y se
// envía una respuesta al cliente.
// package socketservidor;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServidor {
    public static void main(String[] args) {
        // define el puerto, en este caso 1234 localmente
        // El número de puerto no debe entrar en conflicto con ningún otro puerto actualmente en uso
        //en el servidor.
        final int httpd = 1234;
        // define el server socket como null
        ServerSocket ssock = null;
        try {
            // Se crea un server socket escuchando en el puerto definido anteriormente
            ssock = new ServerSocket(httpd);
            // Mensaje que se abrio el puerto localmente, esperando conexion
            System.out.println("have opened port 1234 locally");


            // El servidor espera (bloquea) hasta que un cliente intente conectarse. Cuando un cliente se conecta,
            // se acepta la conexión y se crea un Socket para comunicarse con el cliente.
            // no hace nada hasta que un cliente intenta conectarse al programa
            // del servidor en el puerto que se ha configurado.
            // y luego devuelve el nuevo objeto Socket vinculado al puerto
            // del socket del servidor. Este socket también contiene el puerto remoto y el
            // nombre de host del cliente que intenta la conexión.
            Socket sock = ssock.accept();
            // manda msj que la conexion con el cliente se ha realizado correctamente
            System.out.println("client has made socket connection");

            // Se llama al método communicateWithClient para manejar la comunicación con el cliente.
            communicateWithClient(sock);
            // imprime mensaje que el socket se esta cerrando
            System.out.println("closing socket");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try{
                ssock.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }


    public static void communicateWithClient(Socket socket) {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            // Se crean los objetos BufferedReader para leer los datos que llegan desde el cliente y
            // PrintWriter para enviar datos al cliente.
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(
                    socket.getOutputStream(), true);
            String s = null;

            // Una vez que estos objetos se hayan creado correctamente, el servidor puede comunicarse con
            // el cliente.
            // Se envía un mensaje al cliente indicando que el servidor ha recibido la comunicación.
            out.println("Server received communication!");

            // Utiliza un ciclo para hacerlo, leyendo del objeto BufferedReader (el flujo de
            // entrada del cliente)

            // Se lee una línea de datos del cliente y se imprime en la consola del servidor.
            // El while se rompe después de leer la primera línea.
            while ((s = in.readLine()) != null) {
                System.out.println("received from client: " + s);
                out.flush();
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Finalmente, se cierran los recursos de entrada y salida.
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}