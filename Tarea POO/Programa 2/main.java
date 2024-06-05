// Escribe un pequeño programa utilizando
// las dos clases Punto y PuntoA.
class Main {
    public static void main(String[] args) {
        int x = 5;
        int y = 3;


        PuntoA puntoA = new PuntoA();
        puntoA.inicializa(x, y);
        puntoA.visualiza();


        Punto punto = new Punto();
        punto.inicializa(x, y);
        System.out.println("Coordenadas: (" + punto.getX() + ", " + punto.getY() + ")");
        
    }
}

// ¿Qué pasaría si la clase Punto no tuviera métodos GetX y Gety?
// No podría acceder directamente a los valores de X y Y fuera de la clase, ya que estas variables son privadas (private int x, y;).
// Para acceder a estos valores deberia cambiar la visibilidad de X y Y a public, lo cual rompería el principio de encapsulación:
// Las variables de instancia, X y Y, se declaran como privadas para ocultarlas directamente del código externo a la clase.