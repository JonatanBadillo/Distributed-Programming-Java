package countdownlatchdemo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    // Define el número de hilos que se crearán, en este caso, 3.
    final static int NTHREADS = 3;

    public static void main(String[] args) {
        // Un CountDownLatch inicializado con 1, que actuará como señal para que los hilos comiencen a trabajar.
        final CountDownLatch startSignal = new CountDownLatch(1);
        // Un CountDownLatch inicializado con el número de hilos, que permite al hilo principal esperar
        // hasta que todos los hilos completen su trabajo.
        final CountDownLatch doneSignal = new CountDownLatch(NTHREADS);

        // método run que cada hilo ejecutará.
        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    // Imprime mensajes para indicar el estado del hilo.
                    report("ingreso a run()");

                    // Hace que el hilo espere hasta que startSignal se reduzca a cero.
                    startSignal.await();  // espera hasta que te digan ...

                    // Imprime mensajes para indicar el estado del hilo.
                    report("trabajando"); // ... procede

                    // hilo durmiendo por un tiempo aleatorio.
                    Thread.sleep((int) (Math.random() * 1000));

                    // Decrementa el contador de doneSignal para indicar que el hilo ha terminado su trabajo.
                    doneSignal.countDown(); // reduce el recuento de
                    // que el hilo principal ...
                }                          // esta esperando
                catch (InterruptedException ie)
                {
                    System.err.println(ie);
                }
            }


            // imprime el nombre del current hilo + su estado
            void report(String s)
            {
                System.out.println(System.currentTimeMillis() +
                        ": " + Thread.currentThread() +
                        ": " + s);
            }
        };// fin runnable


        // Crea un pool de hilos con un tamaño fijo de NTHREADS (3 en este caso).
        ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
        // En cada iteración, el ExecutorService (executor) ejecuta la tarea definida en el Runnable (r).
        // Esto significa que se lanzan 3 hilos en paralelo, cada uno ejecutando el método run del Runnable.
        for (int i = 0; i < NTHREADS; i++)
            executor.execute(r);
        try
        {
            // El hilo principal imprime un mensaje indicando que está haciendo algo.
            System.out.println("hilo principal haciendo algo");
            Thread.sleep(1000); // duerme por 1 segundo

            //  Decrementa el contador de startSignal a cero.
            //  Esto hace que los 3 hilos que están esperando en startSignal.await() puedan continuar su ejecución.
            startSignal.countDown(); // deja que los hilos continuen

            // El hilo principal imprime otro mensaje indicando que está haciendo otra cosa.
            System.out.println("hilo principal haciendo otra cosa");

            // El hilo principal llama a await() en doneSignal. Esto hace que el hilo principal se bloquee y espere hasta que
            // todos los hilos hayan terminado su trabajo. Cada uno de los 3 hilos llamará a doneSignal.countDown()
            // cuando terminen su trabajo, reduciendo el contador. Cuando el contador llegue a cero,
            // el hilo principal continuará su ejecución.
            doneSignal.await(); // espera a que terminen todos los hilos
            executor.shutdownNow();
        }
        catch (InterruptedException ie)
        {
            System.err.println(ie);
        }
    }

}