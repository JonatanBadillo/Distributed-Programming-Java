import java.util.concurrent.Semaphore;

public class Dine2 {
    public static void main(String[] args) {
        int rounds = 10; // Número de rondas que cada filósofo intentará comer

        Log.msg(String.valueOf(rounds)); // Imprime el número de rondas

        Semaphore[] chopsticks = new Semaphore[5]; // Array de semáforos representando los palillos

        // Inicializar los semáforos (chopsticks) con un permiso cada uno
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[5]; // Array de filósofos
        // Inicializar filósofos asignando los semáforos correspondientes a los palillos izquierdo y derecho
        philosophers[0] = new Philosopher("P: 0 - ", chopsticks[0], chopsticks[1], rounds);
        philosophers[1] = new Philosopher("P: 1 - ", chopsticks[1], chopsticks[2], rounds);
        philosophers[2] = new Philosopher("P: 2 - ", chopsticks[2], chopsticks[3], rounds);
        philosophers[3] = new Philosopher("P: 3 - ", chopsticks[3], chopsticks[4], rounds);
        philosophers[4] = new Philosopher("P: 4 - ", chopsticks[4], chopsticks[0], rounds);

        // Crear e iniciar un hilo para cada filósofo
        for (int i = 0; i < philosophers.length; i++) {
            Log.msg("Thread " + i + " has started");
            Thread t = new Thread(philosophers[i]);
            t.start();
        }
    }
}

class Philosopher extends Thread {
    private Semaphore leftChopstick; // Semáforo para el palillo izquierdo
    private Semaphore rightChopstick; // Semáforo para el palillo derecho
    private String name; // Nombre del filósofo
    private int rounds; // Número de rondas para comer

    public Philosopher(String name, Semaphore left, Semaphore right, int rounds) {
        this.name = name;
        this.leftChopstick = left;
        this.rightChopstick = right;
        this.rounds = rounds;
    }

    public void eat() {
        try {
            leftChopstick.acquire(); // Intenta adquirir el palillo izquierdo
            Log.msg(name + " took left chopstick");
            rightChopstick.acquire(); // Intenta adquirir el palillo derecho
            Log.msg(name + " took right chopstick");

            // Simula el acto de comer
            Log.msg(name + " : Eat");
            Log.Delay(1000); // Espera para simular el tiempo comiendo

            // Libera los palillos
            rightChopstick.release();
            Log.msg(name + " released right chopstick");
            leftChopstick.release();
            Log.msg(name + " released left chopstick");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        think(); // El filósofo piensa después de comer
    }

    public void think() {
        // Simula el acto de pensar
        Log.msg(name + " : Think");
        Log.Delay(1000); // Espera para simular el tiempo pensando
    }

    public void run() {
        // Ciclo para comer y pensar el número especificado de rondas
        for (int i = 0; i < rounds; i++) {
            eat();
        }
    }
}

class Log {
    // Método para imprimir mensajes
    public static void msg(String msg) {
        System.out.println(msg);
    }

    // Método para simular retrasos
    public static void Delay(int ms) {
        try {
            Thread.sleep(ms); // Pausa el hilo actual por el número especificado de milisegundos
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}