import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GenerarYLeerURL {
    public static void main(String[] args) {
        try {
            // Generar URL absoluta
            URL url1 = new URL("https://openjdk.java.net");
            System.out.println(url1.toString()); // Imprimir la URL absoluta

            // Generar URL para páginas con una base común
            URL url2 = new URL(url1, "projects/jdk/17");
            System.out.println(url2.toString()); // Imprimir la URL basada en url1

            // Generar URL a partir de diferentes partes de datos
            URL url3 = new URL("http", "openjdk.java.net", "projects/jdk/17");
            System.out.println(url3.toString()); // Imprimir la URL creada con datos separados

            // Leer y mostrar el contenido de la URL url1
            readFromUrl(url1);
        } catch (MalformedURLException ex) {
            // Capturar y manejar excepción de URL malformada
            ex.printStackTrace();
        }
    }

    /**
     * Abre el flujo de entrada de la URL y imprime el contenido en la consola.
     *
     * @param url La URL desde la cual se va a leer.
     */
    public static void readFromUrl(URL url) {
        try {
            // Crear un BufferedReader para leer el contenido de la URL
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            url.openStream()));
            String inputLine;

            // Leer cada línea del contenido de la URL y mostrarla en la consola
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close(); // Cerrar el BufferedReader
        } catch (IOException ex) {
            // Capturar y manejar excepción de entrada/salida
            ex.printStackTrace();
        }
    }
}
