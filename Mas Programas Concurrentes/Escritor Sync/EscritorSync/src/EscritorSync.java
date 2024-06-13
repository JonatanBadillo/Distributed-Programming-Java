/*
  En el siguiente ejemplo, hay dos escritores (EscritorA y EscritorB): 
  uno escribirá ABC 10 veces y el otro escribirá XYZ 10 veces. Cada palabra 
  (ABC o XYZ) se escribirá letra por letra con una devolución después de 
  la última letra de cada palabra.
 */
package escritorsync;

public class EscritorSync {
    public static void main(String[] args) {
        Escritor escritorA, escritorB;
        escritorA = new Escritor("ABC");
        escritorB = new Escritor("XYZ");
        escritorA.start();
        escritorB.start();
    }
}