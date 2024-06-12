package escritormutex;

public class Impresora{
    private String texto;
    public Impresora(){texto="";}
    public void imprimir(String t){
        texto=t;
        for(int j=0; j<texto.length()-1; j++){
            System.out.print(texto.substring(j, j+1));
            try{Thread.sleep(100);}
            catch(InterruptedException e) {};
        }
        System.out.println(texto.substring(texto.length()-1, texto.length()));
    }
}