/*
 El siguiente código ilustra el papel de las prioridades entre hilos: 
*/
package infernalrace2;

public class InfernalRace2 {
    public static void main(String[] args) {
        Runner A = new Runner("A"); Runner B = new Runner("B");
        A.setPriority(Thread.MAX_PRIORITY);
        B.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Thread Runner " + A.name + " has priority = "
                + A.getPriority());
        System.out.println("Thread Runner " + B.name + " has priority = "
                + B.getPriority());
        A.start(); B.start();
    }
}

class Runner extends Thread {
    String name
    public Runner(String name) {
        super(name);
        this.name = name;
    }
    public void run() {
        long PedalStroke = 0;
        while (PedalStroke < 5000000) {
            PedalStroke++;
            if ((PedalStroke % 500000) == 0) {
                System.out.println("Runner " + name + " performs " +
                        PedalStroke + " pedal strokes.");
            }
        }
    }
} 