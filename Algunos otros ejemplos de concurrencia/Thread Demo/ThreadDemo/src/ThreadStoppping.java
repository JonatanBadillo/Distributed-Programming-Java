/*
  Intentar detener un hilo mediante la palabra clave synchronized
*/
package threadstoppping;

public class ThreadStoppping {
    public static void main(String[] args) {
        // esta clase extiende de Hilo
        class StoppableThread extends Thread
        {
            private boolean stopped; // defaults to false

            @Override
            public void run()
            // El método run() usa synchronized(this) para asegurarse de que el acceso a stopped esté sincronizado.
            // Esto es innecesario , ya que la sincronización también impone exclusión mutua, lo cual no es necesario en este caso.
            // Bloqueo del Hilo:
            // El método run() adquiere el bloqueo del objeto StoppableThread al usar synchronized(this).
            {
                synchronized(this)
                {
                    while(!stopped)
                        System.out.println("running");
                }
            }

            // El método stopThread() también requiere este bloqueo.
            // Si run() está ejecutando el bucle while, nunca liberará el bloqueo, causando que stopThread() se bloquee al intentar adquirir el mismo bloqueo.
            synchronized void stopThread()
            {
                stopped = true;
            }
        }


        // creon nuevo hilo thd
        StoppableThread thd = new StoppableThread();
        // se lanza thd
        thd.start();
        try
        {
            Thread.sleep(1000); // sleep for 1 second
        }
        catch (InterruptedException ie)
        {
        }
        thd.stopThread();
    }
}

/*
 El programa es una mala idea por dos razones. Primero, aunque solo necesitas 
 resolver el problema de visibilidad, la sincronización también resuelve el 
 problema de exclusión mutua (que no es un problema en esta aplicación).
  Más
 importante aún, has introducido un problema grave en la aplicación.
 Has sincronizado correctamente el acceso a stopped, pero observa más de cerca 
 el bloque sincronizado en el método run(). Observa el ciclo while. Este ciclo 
 es interminable porque el hilo que lo ejecuta ha adquirido el bloqueo del 
 objeto StoppableThread actual (a través de sincronizado(this)), y cualquier 
 intento del hilo principal predeterminado de llamar a stopThread() en este 
 objeto hará que el hilo principal predeterminado ejecute bloquear porque el 
 hilo principal predeterminado necesita adquirir el mismo bloqueo.
*/