package concurrente2;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class Concurrente2 {
    //  Define un conjunto para almacenar los hilos que se crearán para actualizar el mapa concurrente.
    Set<Thread> updateThreads = new HashSet<>();
    public static void main(String[] args) {
        Concurrente2 concurrente = new Concurrente2();
        concurrente.startProcess();

    }
    private void startProcess() {
        // Crea un mapa concurrente para almacenar claves y valores.
        ConcurrentMap<Integer,String> concurrentMap = new ConcurrentHashMap<>();

        // Inicia 1000 hilos, cada uno de los cuales actualizará el mapa concurrente.
        for (int i =0;i < 1000;i++) {
            startUpdateThread(i, concurrentMap);
        }
        try {
            // Pausa la ejecución del hilo principal durante 1 segundo para permitir que los hilos de actualización trabajen.
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Itera sobre las entradas del mapa e imprime las claves y valores almacenados.
        concurrentMap.entrySet().stream().forEach((entry) -> {
            System.out.println("Key :"+entry.getKey()+" Value:"+entry.getValue());
        });
        // Interrumpe todos los hilos de actualización para detener su ejecución.
        updateThreads.stream().forEach((thread) -> {
            thread.interrupt();
        });
    }

    // Crea una instancia de Random para generar números aleatorios.
    Random random = new Random();
    // Método que crea e inicia un hilo de actualización.
    private void startUpdateThread(int i, final ConcurrentMap<Integer, String> concurrentMap) {
        // Define un nuevo hilo que ejecuta un bucle infinito mientras no esté interrumpido
        // En cada iteración, genera un número aleatorio entre 0 y 19 (random.nextInt(20)) y actualiza el mapa concurrente
        // con una clave aleatoria .
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                int randomInt = random.nextInt(20);
                concurrentMap.put(randomInt, UUID.randomUUID().toString());
            }
        });
        // Asigna un nombre al hilo para facilitar su identificación.
        thread.setName("Update Thread "+i);
        // Añade el hilo al conjunto updateThreads
        updateThreads.add(thread);
        // Inicia el hilo.
        thread.start();
    }
}