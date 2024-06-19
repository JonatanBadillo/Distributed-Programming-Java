import java.util.concurrent.Semaphore;

public class Dine2 {
    public static void main(String[] args) {
        int rounds = 10;

        Log.msg(String.valueOf(rounds));

        Semaphore[] chopsticks = new Semaphore[5];

        // Inicializar los semáforos (chopsticks)
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[5];
        philosophers[0] = new Philosopher("P: 0 - ", chopsticks[0], chopsticks[1], rounds);
        philosophers[1] = new Philosopher("P: 1 - ", chopsticks[1], chopsticks[2], rounds);
        philosophers[2] = new Philosopher("P: 2 - ", chopsticks[2], chopsticks[3], rounds);
        philosophers[3] = new Philosopher("P: 3 - ", chopsticks[3], chopsticks[4], rounds);
        philosophers[4] = new Philosopher("P: 4 - ", chopsticks[4], chopsticks[0], rounds);

        for (int i = 0; i < philosophers.length; i++) {
            Log.msg("Thread " + i + " has started");
            Thread t = new Thread(philosophers[i]);
            t.start();
        }
    }
}

class Philosopher extends Thread {
    private Semaphore leftChopstick;
    private Semaphore rightChopstick;
    private String name;
    private int rounds;

    public Philosopher(String name, Semaphore left, Semaphore right, int rounds) {
        this.name = name;
        this.leftChopstick = left;
        this.rightChopstick = right;
        this.rounds = rounds;
    }

    public void eat() {
        try {
            leftChopstick.acquire();
            Log.msg(name + " took left chopstick");
            rightChopstick.acquire();
            Log.msg(name + " took right chopstick");

            Log.msg(name + " : Eat");
            Log.Delay(1000);

            rightChopstick.release();
            Log.msg(name + " released right chopstick");
            leftChopstick.release();
            Log.msg(name + " released left chopstick");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        think();
    }

    public void think() {
        Log.msg(name + " : Think");
        Log.Delay(1000);
    }

    public void run() {
        for (int i = 0; i < rounds; i++) {
            eat();
        }
    }
}

class Log {
    public static void msg(String msg) {
        System.out.println(msg);
    }

    public static void Delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
