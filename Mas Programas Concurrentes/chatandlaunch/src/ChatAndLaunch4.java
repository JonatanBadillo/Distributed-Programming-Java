/*
 En el siguiente segmento, lanzaremos dos hilos sin usar el sleep,
 el programa primario y otro hilo.
*/
package chatandlaunch4;

public class ChatAndLaunch4 {
    public static void main(String[] args) {
        // Se crea nuestro objeto Parrot , con string coco y un entero de 10
        Parrot4 parrot = new Parrot4("coco",10);
        // Se lanza nuestro hilo
        parrot.start();
        // en nuestro hilo principal se manda a llamar 10 veces nuestra funcion blabla
        for (int n=0; n<10; n++) blabla();
    }
    private static void blabla() { System.out.println("blabla"); }
}

// en nuestra clase Parrot4 extiende de Thread
class Parrot4 extends Thread {
    // como argumentos tenemos un String y un entero
    // que refleja nuestro mensaje a repetir y el numero de veces
    private String cri = null;
    private int fois = 0;

    // nuestro constructor asigna a los valores de cri y fois los que recibimos como parametros
    public Parrot4(String s, int i) {
        cri = s;
        fois = i;
    }
    // nuestra funcion repeter, imprime el mensaje que recibimos como parametro
    // en nuestro constructor
    public void repeter() { System.out.println(cri); }
    public void run() {
        for (int n=0; n<fois; n++) repeter();
    }
} 