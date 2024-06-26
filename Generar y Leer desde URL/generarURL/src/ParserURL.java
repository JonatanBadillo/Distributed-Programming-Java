import java.io.IOException;
import java.net.URL;

public class ParserURL {
    public static void main(String[] args) {
        URL url1 = null; // Declaración de la variable URL

        try {
            // Generar una URL absoluta
            url1 = new URL("https://link.springer.com/search?query=Musch+Design Patterns with Java");

            // Obtener y almacenar diferentes partes de la URL
            String host = url1.getHost(); // Obtener el host (dominio)
            String path = url1.getPath(); // Obtener el camino (path)
            String query = url1.getQuery(); // Obtener la consulta (query)
            String protocol = url1.getProtocol(); // Obtener el protocolo (http, https, etc.)
            String authority = url1.getAuthority(); // Obtener la autoridad (usuario, host, puerto)
            String ref = url1.getRef(); // Obtener la referencia (fragmento)

            // Imprimir la URL completa y sus componentes
            System.out.println("The URL " + url1.toString() + " parses to the following:\n");
            System.out.println("Host: " + host + "\n");
            System.out.println("Path: " + path + "\n");
            System.out.println("Query: " + query + "\n");
            System.out.println("Protocol: " + protocol + "\n");
            System.out.println("Authority: " + authority + "\n");
            System.out.println("Reference: " + ref + "\n");
        } catch (IOException ex) {
            // Capturar y manejar cualquier excepción de entrada/salida
            ex.printStackTrace();
        }
    }
}
