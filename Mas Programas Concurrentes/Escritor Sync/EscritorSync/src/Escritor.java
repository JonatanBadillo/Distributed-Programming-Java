package escritorsync;

import static java.lang.Thread.sleep;

public class Escritor extends Thread{
    private String texto;
    public Escritor(String t){
        texto=t;
    }
    public void run(){
        for (int i=0; i<10; i++){
            int j=0;
            for (; j<texto.length()-1; j++){
                System.out.print(texto.substring(j, j+1));
                try{sleep((long)(Math.random()*100));}
                catch(InterruptedException e) {}
            } System.out.println(texto.substring(j, j+1));
        }
        System.out.println("Escritor de " + texto + " ha concluido");
    }
}