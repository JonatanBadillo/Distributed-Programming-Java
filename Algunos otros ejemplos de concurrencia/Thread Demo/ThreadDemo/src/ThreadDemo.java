/*
 Demostración de los fundamentos de los hilos
 El programa demuestra cómo crear hilos, cómo configurarlos como daemon o no daemon,
 y cómo imprimir su estado en tiempo real.
*/
package threaddemo;

public class ThreadDemo {
    public static void main(String[] args) {
        // se establece en true si hay argumentos pasados al programa, y en false si no hay argumentos.
        // Sirve para determinar si los hilos creados serán hilos daemon.
        boolean isDaemon = args.length != 0;
        Runnable r = new Runnable()
        {
            // Dentro del run(), se obtiene el hilo actual (Thread.currentThread())
            // y se entra en un bucle infinito que imprime el nombre del hilo, su estado de vida (isAlive()) y su estado (getState()).
            @Override
            public void run()
            {
                Thread thd = Thread.currentThread();
                while (true)
                    System.out.printf("%s is %salive and in %s " +
                                    "state%n",
                            thd.getName(),
                            thd.isAlive() ? "" : "not ",
                            thd.getState());
            }
        };



        Thread t1 = new Thread(r, "thd1");
        // Si isDaemon es true, se establece t1 como un hilo daemon.
        if (isDaemon)
            t1.setDaemon(true);
        // Se imprime el estado del hilo t1 antes de iniciarlo.
        System.out.printf("%s is %salive and in %s state%n",
                t1.getName(),
                t1.isAlive() ? "" : "not ",
                t1.getState());

        // Si isDaemon es true, se establece t2 como un hilo daemon.
        Thread t2 = new Thread(r);
        t2.setName("thd2");
        if (isDaemon)
            t2.setDaemon(true);
        // Impresión del Estado de t2: Se imprime el estado del hilo t2 antes de iniciarlo.
        System.out.printf("%s is %salive and in %s state%n",
                t2.getName(),
                t2.isAlive() ? "" : "not ",
                t2.getState());
        t1.start();
        t2.start();
    }
}