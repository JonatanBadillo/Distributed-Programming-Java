package com.mycompany.simpleexecutor;
import java.util.concurrent.*;

public class SimpleExecutor {
    // Main driver method
    public static void main(String[] args)
    {
        // Creating objects of CountDownLatch class
        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);
        CountDownLatch cd3 = new CountDownLatch(5);
        CountDownLatch cd4 = new CountDownLatch(5);

        // Creating objects of ExecutorService class
        ExecutorService es
                = Executors.newFixedThreadPool(2);

        // Display message only for better readability
        System.out.println("Starting");

        // Executing the tasks
        es.execute(new MyThread(cd1, "A"));
        es.execute(new MyThread(cd2, "B"));
        es.execute(new MyThread(cd3, "C"));
        es.execute(new MyThread(cd4, "D"));

        // Try block to check for exceptions
        try {

            // Waiting for tasks to complete
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        }

        // Catch block to handle exceptions
        catch (InterruptedException e) {

            System.out.println(e);
        }

        // Making all current executing threads to terminate
        es.shutdown();

        // Display message only for better readability
        System.out.println("Done");
    }
}

// Class 2
// Helper class
class MyThread implements Runnable {

    // Class data members
    String name;
    CountDownLatch latch;

    // Constructor
    MyThread(CountDownLatch latch, String name)
    {

        // this keyword refers to current instance itself
        this.name = name;
        this.latch = latch;

        new Thread(this);
    }

    // Method
    // Called automatically when thread is started
    public void run()
    {

        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}