package calculare;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalcularE {
    // Define la última iteración de la serie (en este caso, 17).
    final static int LASTITER = 17;

    public static void main(String[] args) {
        // Crea un pool de un solo hilo
        ExecutorService executor = Executors.newFixedThreadPool(1);
        // El Callable es una tarea que devuelve un resultado (BigDecimal en este caso).
        Callable<BigDecimal> callable;
        callable = new Callable<BigDecimal>()
        {
            @Override
            public BigDecimal call()
            {
                // Dentro del método call, se crea un MathContext con una precisión de 100 dígitos y
                // modo de redondeo HALF_UP. Luego, se calcula el valor de
                // e sumando los términos de la serie hasta LASTITER.
                MathContext mc =
                        new MathContext(100, RoundingMode.HALF_UP);
                BigDecimal result = BigDecimal.ZERO;
                for (int i = 0; i <= LASTITER; i++)
                {
                    BigDecimal factorial =
                            factorial(new BigDecimal(i));
                    BigDecimal res = BigDecimal.ONE.divide(factorial,
                            mc);
                    result = result.add(res);
                }
                return result;
            }

            // Calcula el factorial de un número BigDecimal
            public BigDecimal factorial(BigDecimal n)
            {
                if (n.equals(BigDecimal.ZERO))
                    return BigDecimal.ONE;
                else
                    return n.multiply(factorial(n.
                            subtract(BigDecimal.ONE)));
            }
        };

        // Se envía el Callable al ExecutorService y se obtiene un Future para esperar el resultado.
        Future<BigDecimal> taskFuture = executor.submit(callable);

        // Se espera hasta que la tarea se complete, imprimiendo "esperando" mientras tanto.
        try
        {
            while (!taskFuture.isDone())
                System.out.println("esperando");
            System.out.println(taskFuture.get());
        }
        catch(ExecutionException ee)
        {
            System.err.println("la tarea arrojo una excepcion");
            System.err.println(ee);
        }
        catch(InterruptedException ie)
        {
            System.err.println("interrumpido mientras esperaba");
        }
        // se apaga el ejecutor
        executor.shutdownNow();
    }
}