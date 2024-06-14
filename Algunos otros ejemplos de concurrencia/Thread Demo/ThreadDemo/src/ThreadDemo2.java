/*
  Demostrando la interrupción del hilo 
*/
package threaddemo2;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                // obtienes el nombre del hilo
                String name = Thread.currentThread().getName();
                // estableces el contador en 0
                int count = 0;
                // mientras el hilo no sea interrumpido, se imprimira el hilo con su respectivo contador
                while (!Thread.interrupted())
                    System.out.println(name + ": " + count++);
            }
        };
        // creamos nuestros dos hilos
        Thread thdA = new Thread(r);
        Thread thdB = new Thread(r);
        // lanzamos nuestros dos hilos
        thdA.start();
        thdB.start();

        // entra en un bucle infinito que genera un número aleatorio n utilizando Math.random().
        // Si el número n cae dentro del rango extremadamente estrecho entre 0.49999999 y 0.50000001, el bucle se rompe.
        // Después de romper el bucle, se llaman a los métodos interrupt() de thdA y thdB para interrumpir ambos hilos.
        while (true)
        {
            double n = Math.random();
            if (n >= 0.49999999 && n <= 0.50000001)
                break;
        }
        // interrumpes los dos hilos
        thdA.interrupt();
        thdB.interrupt();
    }
}