// 4) Disponemos de la siguiente clase:
class Punto {
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void desplaza(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void visualiza() {
        System.out.println("Coordenadas del Punto " + x + " " + y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private double x, y;
}

// Queremos crear una clase Circulo con los siguientes metodos:
    
    
    // • cambiaRadio para modificar el radio del círculo,
    // • getCentro que proporciona como resultado un objeto de tipo Punto correspondiente
    // al centro del círculo,
    // • visualiza que muestra las coordenadas del centro del círculo y su radio.
    // 1. Define la clase Circulo como una clase derivada de Punto.
    // 2. Define la clase Circulo como si tuviera un miembro de tipo Punto.
// En ambos casos escribiremos un pequeño programa poniendo en juego las diferentes
// funcionalidades de la clase Circulo.

class Circulo{
    private Punto centro;
    private double radio;

//  • constructor que recibe como argumentos las coordenadas del centro del círculo y su
//  radio
    public Circulo(double x, double y, double radio){
        this.centro = new Punto(x, y);
        this.radio = radio;
    }
// • mueveCentro para modificar las coordenadas del centro del círculo,
    public void mueveCentro(double dx, double dy){
        centro.desplaza(dx, dy);
    }

    
}





public class Main {
    public static void main(String[] args) {

    }
}
