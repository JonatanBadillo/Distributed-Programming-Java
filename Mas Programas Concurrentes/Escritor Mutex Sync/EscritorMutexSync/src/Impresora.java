package escritormutexsync;

public class Impresora{
    private String texto;
    // Inicializa texto como una cadena vacía.
    public Impresora(){texto="";}

    // La palabra synchronized asegura que solo un hilo puede ejecutar este método en una instancia de Impresora a la vez
    // Esto previene la interferencia de hilos, asegurando que los caracteres de ABC y XYZ no se mezclen al imprimir.
    public synchronized void imprimir(String t){
        texto=t;
        // lo imprime carácter por carácter.
        for(int j=0; j<texto.length()-1; j++){
            System.out.print(texto.substring(j, j+1));
            // Pausa el hilo por un tiempo aleatorio entre 0 y 100 milisegundos
            try{Thread.sleep(100);}
            // cacha alguna excepcion si hubo algun error en la ejecucion de algun hilo
            catch(InterruptedException e) {};
        }
        System.out.println(texto.substring(texto.length()-1, texto.length()));
    }

}