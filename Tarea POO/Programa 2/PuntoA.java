// Proponer una clase PuntoA, derivada de Punto con un método visualiza que muestra (en la
// ventana de la consola) las coordenadas de un punto. Escribe un pequeño programa utilizando
// las dos clases Punto y PuntoA.

public class PuntoA extends Punto{
    public void visualiza(){
        System.out.println("Coordenadas: (" + getX() + ", " + getY() + ")");
    }
}
