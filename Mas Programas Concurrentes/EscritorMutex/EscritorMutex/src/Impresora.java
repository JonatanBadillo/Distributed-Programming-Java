package escritormutex;

public class Impresora{
    private String texto;

    // Constructor de la clase Impresora, inicializa texto como una cadena vacía.
    public Impresora(){texto="";}
    // Método imprimir, que toma un String como argumento
    public void imprimir(String t){
        texto=t;
        // lo imprime carácter por carácter.
        for(int j=0; j<texto.length()-1; j++){
            System.out.print(texto.substring(j, j+1));
            // Pausa de 100 milisegundos.
            try{Thread.sleep(100);}
            // Captura la excepción si el hilo es interrumpido durante la pausa.
            catch(InterruptedException e) {};
        }
        // Imprime el último carácter y añade una nueva línea.
        System.out.println(texto.substring(texto.length()-1, texto.length()));
    }
}