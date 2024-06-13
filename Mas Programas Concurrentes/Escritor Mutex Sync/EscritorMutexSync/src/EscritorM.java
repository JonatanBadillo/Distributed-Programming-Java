package escritormutexsync;

public class EscritorM extends Thread {
    private String texto;
    private Impresora imprime;
    public EscritorM(String t, Impresora i){
        texto=t;
        imprime=i;
    }
    public void run(){
        for (int i=0; i<10; i++){
            imprime.imprimir(texto);
            try{sleep((long)(Math.random()*100));}
            catch(InterruptedException e) {}
        }
        System.out.println("Escritor de " + texto + " ha concluido");
    }
}
