package escritormutexsync;

public class EscritorM extends Thread {
    private String texto;
    // una referencia a un objeto Impresora que este hilo usará para imprimir el texto.
    private Impresora imprime;

    //  Inicializa los atributos texto e imprime con los valores proporcionados.
    public EscritorM(String t, Impresora i){
        texto=t;
        imprime=i;
    }

    // Este método se ejecuta cuando el hilo comienza.

    public void run(){
        for (int i=0; i<10; i++){
            // Imprime el texto 10 veces utilizando el método imprimir de Impresora.
            imprime.imprimir(texto);
            //  Entre cada impresión, el hilo se duerme por un tiempo aleatorio (hasta 100 milisegundos).
            try{sleep((long)(Math.random()*100));}
            catch(InterruptedException e) {}
        }// //  Después de las 10 iteraciones, imprime un mensaje indicando que ha terminado.
        System.out.println("Escritor de " + texto + " ha concluido");
    }
}
