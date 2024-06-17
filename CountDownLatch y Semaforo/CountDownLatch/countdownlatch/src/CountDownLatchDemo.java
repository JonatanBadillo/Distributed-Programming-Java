package countdownlatchdemo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    
    final static int NTHREADS = 3;

    public static void main(String[] args) {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch doneSignal = new CountDownLatch(NTHREADS);
        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    report("ingreso a run()");
                    startSignal.await();  // espera hasta que te digan ...
                    report("trabajando"); // ... procede
                    Thread.sleep((int) (Math.random() * 1000));
                    doneSignal.countDown(); // reduce el recuento de
                    // que el hilo principal ...
                }                          // esta esperando
                catch (InterruptedException ie)
                {
                    System.err.println(ie);
                }
            }

            void report(String s)
            {
                System.out.println(System.currentTimeMillis() +
                        ": " + Thread.currentThread() +
                        ": " + s);
            }
        };
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