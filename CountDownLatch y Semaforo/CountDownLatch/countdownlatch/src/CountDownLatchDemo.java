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


        
        ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
        for (int i = 0; i < NTHREADS; i++)
            executor.execute(r);
        try
        {
            System.out.println("hilo principal haciendo algo");
            Thread.sleep(1000); // duerme por 1 segundo
            startSignal.countDown(); // deja que los hilos continuen
            System.out.println("hilo principal haciendo otra cosa");
            doneSignal.await(); // espera a que terminen todos los hilos
            executor.shutdownNow();
        }
        catch (InterruptedException ie)
        {
            System.err.println(ie);
        }
    }

}