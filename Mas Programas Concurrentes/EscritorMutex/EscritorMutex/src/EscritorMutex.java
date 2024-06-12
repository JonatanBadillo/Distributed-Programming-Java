/*
  Checa el siguiente cÃģdigo: el mÃĐtodo de impresiÃģn muestra una letra de
  palabra por letra con un descanso de linea al final de la Ãšltima letra.
  Los escritores pasan por una impresora para escribir.
  Ambos escritores ahora se dirigen a una impresora comÃšn. Ellos "aplastan"
  la variable de texto de la impresora.
  Todo el asunto sigue siendo ilegible.
 */
package escritormutex;

public class EscritorMutex {
    public static void main(String[] args) {
        // Creo los objetos escritorA y escritorB  de la clase EscritorM
        EscritorM escritorA, escritorB;
        Impresora impresora = new Impresora();
        escritorA = new EscritorM("ABC", impresora);
        escritorB = new EscritorM("XYZ", impresora);
        escritorA.start();
        escritorB.start();
    }
}
