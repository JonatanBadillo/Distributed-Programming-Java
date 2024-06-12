/*
  Para visualizar la asignación de tiempo entre dos hilos, 
  tendremos que aumentar el número de iteraciones a 5 millones 
  examinando qué hilo se ejecuta en múltiplos de 500 mil.
*/
package infernalrace1;

public class InfernalRace1 {
    public static void main(String[] args) {
        Runner A = new Runner("A");
        Runner B = new Runner("B");
        A.start();
        B.start();
    }
}

// clase Runner que extiende de Thread
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
                System.out.println("Runner " + name + " performs " + PedalStroke + " pedal strokes.");
            } // end if
        } // end while
    }// end run
}// end class Runner