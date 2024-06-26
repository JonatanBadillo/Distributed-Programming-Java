/*
 El siguiente código ilustra el papel de las prioridades entre hilos: 
*/
package infernalrace2;

public class InfernalRace2 {
    public static void main(String[] args) {
        // Crea dos instancias de la clase Runner con los nombres "A" y "B".
        Runner A = new Runner("A"); Runner B = new Runner("B");

        // Asigna la máxima prioridad (Thread.MAX_PRIORITY) al hilo A y la mínima prioridad (Thread.MIN_PRIORITY) al hilo B.
        A.setPriority(Thread.MAX_PRIORITY);
        B.setPriority(Thread.MIN_PRIORITY);

        // Imprime las prioridades de ambos hilos.
        System.out.println("Thread Runner " + A.name + " has priority = "
                + A.getPriority());
        System.out.println("Thread Runner " + B.name + " has priority = "
                + B.getPriority());

        // Inicia ambos hilos.
        A.start(); B.start();
    }
}

class Runner extends Thread {
    String name;
    // El constructor Runner asigna un nombre al hilo.
    public Runner(String name) {
        super(name);
        this.name = name;
    }
    // El método run contiene un bucle que incrementa la variable PedalStroke hasta llegar a 5 millones.
    public void run() {
        long PedalStroke = 0;
        while (PedalStroke < 5000000) {
            PedalStroke++;
            // Cada 500,000 iteraciones, imprime el número de pedaladas realizadas por el corredor.
            if ((PedalStroke % 500000) == 0) {
                System.out.println("Runner " + name + " performs " +
                        PedalStroke + " pedal strokes.");
            }
        }
    }
} 