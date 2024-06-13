package escritormutex;

public class EscritorM extends Thread {
    private String texto;
    private Impresora imprime;
    // constructor que recibe como parametro un String y un objeto Impresora
    public EscritorM(String t, Impresora i){
        texto=t;
        imprime=i;
    }
    public void run(){
        for (int i=0; i<10; i++){
            // Imprime el texto 10 veces utilizando el método imprimir de la clase Impresora
            imprime.imprimir(texto);
            // Entre cada impresión, el hilo se duerme por un período aleatorio de tiempo (hasta 100 milisegundos).
            try{sleep((long)(Math.random()*100));}
            catch(InterruptedException e) {}
        }
        // Después de las 10 iteraciones, imprime un mensaje indicando que ha terminado.
        System.out.println("Escritor de " + texto + " ha concluido");
    }
}