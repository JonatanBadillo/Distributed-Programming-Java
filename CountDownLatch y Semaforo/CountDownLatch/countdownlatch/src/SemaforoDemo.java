/*
  Uso de un semáforo de conteo para controlar el acceso a un grupo de elementos
*/
package semaforodemo;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class SemaforoDemo {

    public static void main(String[] args) {
        // Crea una instancia a Pool
        final Pool pool = new Pool();
        // Nuestro metodo Run
        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                String name = Thread.currentThread().getName();
                try
                {
                    // bucle infinito donde muestra el estado del pool del hilo y su accion actual
                    while (true)
                    {
                        String item;
                        System.out.println(name + " acquiring " +
                                (item = pool.getItem()));
                        Thread.sleep(200 +
                                (int) (Math.random() * 100));
                        System.out.println(name + " putting back " +
                                item);
                        pool.putItem(item);
                    }
                }
                catch (InterruptedException ie)
                {
                    System.out.println(name + "interrupted");
                }
            }
        };
        // Se crea un array de ExecutorService con un tamaño de Pool.MAX_AVAILABLE + 1,
        // lo que significa que habrá un hilo adicional más allá del número máximo de recursos disponibles en el pool.
        ExecutorService[] executors = new ExecutorService[Pool.MAX_AVAILABLE + 1];
        for (int i = 0; i < executors.length; i++)
        {
            executors[i] = Executors.newSingleThreadExecutor();
            executors[i].execute(r);
        }
    }
}

final class Pool
{
    // Define un grupo de MAX_AVAILABLE elementos (10 por defecto).
    public static final int MAX_AVAILABLE = 10;

    // Utiliza un Semaphore llamado available con un recuento inicial de MAX_AVAILABLE.
    // Este semáforo, permite que solo un cierto número de hilos accedan al grupo simultáneamente.
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    // Almacena elementos en un array de String (items).
    private final String[] items;

    // Mantiene un array de boolean (used) para ver qué elementos están en uso actualmente.
    private final boolean[] used = new boolean[MAX_AVAILABLE];

    Pool()
    {
        items = new String[MAX_AVAILABLE];
        for (int i = 0; i < items.length; i++)
            items[i] = "I" + i;
    }


    // Proporciona métodos getItem() y putItem() para un acceso seguro para hilos al grupo.
    // Llama a available.acquire(), lo que decrementa el contador del semáforo y bloquea si no hay recursos disponibles.
    String getItem() throws InterruptedException
    {
        // acquire() decrementa el contador y bloquea el hilo que llama si el contador llega a cero (no hay permisos disponibles).
        available.acquire();
        // Llama a getNextAvailableItem() para obtener el siguiente recurso disponible.
        return getNextAvailableItem();
    }



    void putItem(String item)
    {
        // Llama a markAsUnused(item), lo que marca el recurso como no utilizado.
        if (markAsUnused(item))
        // Llama a available.release() para incrementar el contador del semáforo.
            available.release();
    }

    private synchronized String getNextAvailableItem()
    {
        for (int i = 0; i < MAX_AVAILABLE; ++i)
        {
            if (!used[i])
            {
                used[i] = true;
                return items[i];
            }
        }
        return null; // not reached
    }

    private synchronized boolean markAsUnused(String item)
    {
        for (int i = 0; i < MAX_AVAILABLE; ++i)
        {
            if (item == items[i])
            {
                if (used[i])
                {
                    used[i] = false;
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }
}