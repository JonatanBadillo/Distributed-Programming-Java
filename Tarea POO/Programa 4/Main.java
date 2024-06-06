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

// 1. Define la clase Circulo como una clase derivada de Punto.
class Circulo1 extends Punto{
    private double radio;

    // • constructor que recibe como argumentos las coordenadas del centro del
    // círculo y su radio
    public Circulo1(double x, double y, double radio) {
        super(x, y);
        this.radio = radio;
    }

    // • mueveCentro para modificar las coordenadas del centro del círculo,
    public void mueveCentro(double dx, double dy) {
        desplaza(dx, dy);
    }

    // • cambiaRadio para modificar el radio del círculo,
    public void cambiaRadio(double nuevoRadio) {
        this.radio = nuevoRadio;
    }

    // • getCentro que proporciona como resultado un objeto de tipo Punto
    // correspondiente al centro del círculo
    public Punto getCentro() {
        return this;
    }

    // • visualiza que muestra las coordenadas del centro del círculo y su radio.
    public void visualiza() {
        super.visualiza();
        System.out.println(" y su radio: " + radio);
    }
}


// 2. Define la clase Circulo como si tuviera un miembro de tipo Punto.
class Circulo2 {
    private Punto centro;
    private double radio;

    // • constructor que recibe como argumentos las coordenadas del centro del
    // círculo y su radio
    public Circulo2(double x, double y, double radio) {
        this.centro = new Punto(x, y);
        this.radio = radio;
    }

    // • mueveCentro para modificar las coordenadas del centro del círculo,
    public void mueveCentro(double dx, double dy) {
        centro.desplaza(dx, dy);
    }

     // • cambiaRadio para modificar el radio del círculo,
    public void cambiaRadio(double nuevoRadio) {
        this.radio = nuevoRadio;
    }

    // • getCentro que proporciona como resultado un objeto de tipo Punto
    // correspondiente al centro del círculo
    public Punto getCentro() {
        return centro;
    }

    // • visualiza que muestra las coordenadas del centro del círculo y su radio.
    public void visualiza() {
        System.out.println("Coordenadas del centro del círculo: " + centro.getX() + " " + centro.getY() + " y su radio: " + radio);
    }
}


public class Main {
    public static void main(String[] args) {

    }
}
