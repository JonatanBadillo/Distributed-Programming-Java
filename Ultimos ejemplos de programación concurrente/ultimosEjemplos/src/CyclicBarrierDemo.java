// Usar una barrera cíclica para descomponer una tarea en subtareas
package cyclicbarrierdemo;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        // Se define matriz de 3x3 en float
        float[][] matrix = new float[3][3];
        // contador en 0
        int counter = 0;
        // Inicializa una matriz de float de 3x3 y la llena con valores consecutivos del 0 al 8.
        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[0].length; col++)
                matrix[row][col] = counter++;

        // Llama al método dump para imprimir la matriz.
        dump(matrix);
        // Salto de linea
        System.out.println();

        // Crea una instancia de la clase Solver, pasando la matriz como argumento.
        Solver solver = new Solver(matrix);
        // Salto de linea
        System.out.println();
        // Llama al método dump para imprimir la matriz.
        dump(matrix);
    }

    // Imprime la matriz
    static void dump(float[][] matrix)
    {
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix[0].length; col++)
                System.out.print(matrix[row][col] + " ");
            System.out.println();
        }
    }
}

class Solver
{
    final int N;
    final float[][] data;
    // barrier: La CyclicBarrier usada para sincronizar las tareas.
    final CyclicBarrier barrier;


    // Implementa Runnable para procesar una fila de la matriz.
    class Worker implements Runnable
    {
        int myRow;
        boolean done = false;


        Worker(int row)
        {
            myRow = row;
        }

        boolean done()
        {
            return done;
        }

        // Multiplica cada elemento de una fila por 10.
        void processRow(int myRow)
        {
            System.out.println("Processing row: " + myRow);
            for (int i = 0; i < N; i++)
                data[myRow][i] *= 10;
            done = true;
        }

        // // Procesa la fila y espera en la barrera.
        @Override
        public void run()
        {
            while (!done())
            {
                processRow(myRow);

                try
                {
                    barrier.await();
                }
                catch (InterruptedException ie)
                {
                    return;
                }
                catch (BrokenBarrierException bbe)
                {
                    return;
                }
            }
        }
    }


    public Solver(float[][] matrix)
    {
        // Define data como la matrix y n como el tamaño de la matriz
        data = matrix;
        N = matrix.length;
        // Configura la CyclicBarrier con N y una tarea de finalización que llama a mergeRows.
        barrier = new CyclicBarrier(N,
                new Runnable()
                {
                    @Override
                    public void run()
                    {

                        mergeRows();
                    }
                });
        for (int i = 0; i < N; ++i)
            // Crea y empieza un hilo Worker para cada fila de la matriz.
            new Thread(new Worker(i)).start();

        //Llama a waitUntilDone para esperar a que las tareas se completen.
        waitUntilDone();
    }

    void mergeRows()
    {
        System.out.println("merging");
        synchronized("abc")
        {
            "abc".notify();
        }
    }

    void waitUntilDone()
    {
        synchronized("abc")
        {
            try
            {
                System.out.println("main thread waiting");
                "abc".wait();
                System.out.println("main thread notified");
            }
            catch (InterruptedException ie)
            {
                System.out.println("main thread interrupted");
            }
        }
    }
}