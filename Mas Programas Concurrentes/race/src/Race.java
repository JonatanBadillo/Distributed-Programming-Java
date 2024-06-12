/*
El siguiente ejemplo simula una carrera usando hilos. 
La idea es simular una carrera de 1000 m entre dos personas 
llamadas Jean y Paul. Dado que es necesario que se ejecute 
simultáneamente, cada uno de ellos será tomado por un hilo.
*/
package race;
// extiende de la clase Thread
class Runner extends Thread {
    // constructor que recibe como parametros un String del nombre del competidor
    public Runner (String str) {
        super(str);
    }
    // accion a realizar cuando el hilo es lanzado
    public void run() {
        // Value i is incremented at the passage of the nth hundred meters
        for (int i =1; i<=10; i++) {
            System.out.println(i*100 + " m : " + getName());
            try {
                sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {}
        } // end for
        System.out.println( getName()+ " concluye ! ");
    }// end run
} // end class

public class Race {

    public static void main(String[] args) {
        System.out.println("Paso: ");
        Runner Jean = new Runner ("Jean");
        Runner Paul = new Runner ("Paul");
        Jean.start();
        Paul.start();
    }

}