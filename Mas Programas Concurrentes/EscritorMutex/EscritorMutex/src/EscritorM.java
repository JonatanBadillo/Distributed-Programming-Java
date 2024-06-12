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
            //
            imprime.imprimir(texto);
            try{sleep((long)(Math.random()*100));}
            catch(InterruptedException e) {}
        }
        System.out.println("Escritor de " + texto + " ha concluido");
    }
}