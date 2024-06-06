
// public II. Tenemos la siguiente clase:
class Punto {
    public void inicializa(int x, int y) {
        this.x = x;
        this.y = y;
    }

public void desplaza (int dx, int dy) {x += dx; y += dy; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x, y;
}
// Crear una clase PuntoA, derivada de Punto con un método de visualización
// (visualiza) que
// muestre (en la ventana de la consola) las coordenadas de un punto. Escribe un
// pequeño
// programa usando las dos clases Punto y PuntoA.
// ¿Qué pasa si la clase Punto no tiene métodos getX y getY? {}

class PuntoA extends Punto{
    public void visualiza(){
        System.out.println("Coordenadas: (" + getX() + ", " + getY() + ")");
    }

}


class Main{
    public static void main(String[] args) {
        int x = 5;
        int y = 3;

        Punto punto = new Punto();
        punto.inicializa(x, y);
        System.out.println("Coordenadas: (" + punto.getX() + ", " + punto.getY() + ")");


        PuntoA puntoA = new PuntoA();
        puntoA.inicializa(x, y);
        puntoA.visualiza();
    }
}
