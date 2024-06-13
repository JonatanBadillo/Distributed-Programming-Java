/*
 El uso de "synchronized" es indispensable para resolver este problema, como 
 se muestra en el siguiente cÃģdigo:
*/
package escritormutexsync;

public class EscritorMutexSync {
    public static void main(String[] args) {
        EscritorM escritorA, escritorB;
        Impresora impresora = new Impresora();
        escritorA = new EscritorM("ABC", impresora);
        escritorB = new EscritorM("XYZ", impresora);
        escritorA.start();
        escritorB.start();
    }

}