package escritorsync;

import static java.lang.Thread.sleep;

// Extiende la clase Thread
public class Escritor extends Thread{
    private String texto;
    // Inicializa el atributo texto con el valor proporcionado.
    public Escritor(String t){
        texto=t;
    }


    public void run(){
        // Un bucle exterior que se repite 10 veces (for (int i = 0; i < 10; i++)).
        for (int i=0; i<10; i++){
            int j=0;
            // Un bucle interior que recorre cada carácter de la cadena texto
            for (; j<texto.length()-1; j++){
                System.out.print(texto.substring(j, j+1));
                // Pausa el hilo por un tiempo aleatorio entre 0 y 100 milisegundos
                try{sleep((long)(Math.random()*100));}
                // Captura cualquier excepción de interrupción
                catch(InterruptedException e) {}
                // Imprime el último carácter de la cadena
            } System.out.println(texto.substring(j, j+1));
        }
        System.out.println("Escritor de " + texto + " ha concluido");
    }
}