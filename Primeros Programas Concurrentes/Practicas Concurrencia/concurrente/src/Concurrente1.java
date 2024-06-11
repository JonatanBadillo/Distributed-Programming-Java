package concurrente1;

public class Concurrente1 {
    public static void main(String[] args) {
        // crea una instancia de Concurrente1 y llama a su método startProcess().
        Concurrente1 concurrente = new Concurrente1();
        concurrente.startProcess();
    }

    // Se crea un hilo llamado "Background Thread" implementando Runnable que ejecuta el método doSomethingInBackground()
    private void startProcess() {
        // Crea un nuevo hilo (Thread) con un objeto Runnable que define el método run()
        // para ejecutar en ese hilo. El hilo se llama "Background Thread".
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                doSomethingInBackground();
            }
        }, "Background Thread");


        // Usando una expresión lambda (comentado):
        // Imprime "Start" y se inicia el hilo backgroundThread.
        System.out.println("Start");
        backgroundThread.start(); // lanza el hilo backgroundThread
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": is counting " + i);
        }
        // Después del bucle, se imprime "Done".
        System.out.println("Done");


    }

    // Imprime el nombre del hilo actual (Thread.currentThread().getName()) y un mensaje indicando que está ejecutándose en el fondo.
    private void doSomethingInBackground() {
        System.out.println(Thread.currentThread().getName() + ": is Running in the background");
    }

}