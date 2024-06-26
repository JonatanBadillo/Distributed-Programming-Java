import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SyncResp {

    public static void main(String[] args) {
        try {
            // Crear un cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear una solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://www.apress.com/us/"))
                    .GET()
                    .build();

            // Enviar la solicitud y recibir la respuesta de manera sincrónica
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            // Obtener el código de estado y el cuerpo de la respuesta
            int statusCode = response.statusCode();
            String body = response.body();

            // Imprimir el código de estado y el cuerpo de la respuesta
            System.out.println("Status Code: " + statusCode);
            System.out.println("Body: " + body);

            // Do something with body text (Hacer algo con el texto del cuerpo)

        } catch (Exception ex) {
            Logger.getLogger(SyncResp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fetchResponse(String uri) throws Exception {
        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Crear una solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        // Enviar la solicitud y recibir la respuesta de manera sincrónica
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        // Imprimir el cuerpo de la respuesta
        System.out.println(response.body());
    }
}
