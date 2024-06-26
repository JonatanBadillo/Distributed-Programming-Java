import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncResp {
    public static void main(String[] args) {
        try {
            // Crear un cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear una solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://www.apress.com/us/"))
                    .GET()
                    .build();

            // Enviar la solicitud de manera asíncrona
            CompletableFuture<HttpResponse<String>> cf = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Request made...");
            System.out.println("Check if done...");

            // Esperar hasta que la respuesta esté lista
            while (!cf.isDone()) {
                System.out.println("Perform some other tasks while waiting...");
                // Periodically check CompletableFuture.isDone()
                Thread.sleep(500); // Añadir un pequeño retraso para evitar un bucle ocupado
            }

            System.out.println("Response Received:");

            // Obtener la respuesta
            HttpResponse<String> response = cf.get();
            int statusCode = response.statusCode();
            System.out.println("Status Code: " + statusCode);

            // Obtener el cuerpo de la respuesta
            String body = response.body();
            System.out.println("Body: " + body);
            // Do something with body text

        } catch (URISyntaxException | InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}
