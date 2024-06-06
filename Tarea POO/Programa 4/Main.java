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
        return this;// "this" se refiere al centro del círculo, ya que la clase Circulo se ha definido como una extensión de Punto. un objeto Circulo es en sí mismo un Punto que representa el centro del círculo.
    }

    // • visualiza que muestra las coordenadas del centro del círculo y su radio.
    public void visualiza() {
        super.visualiza();
        System.out.println("Radio: " + radio);
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
        Circulo1 c1 = new Circulo1(1.0, 2.0, 3.0);
        c1.visualiza();
        c1.mueveCentro(2.0, 3.0);
        c1.cambiaRadio(4.0);
        c1.visualiza();

        System.out.println("-------------------");

        Circulo1 c2 = new Circulo1(2.0, 3.0, 4.0);
        c2.visualiza();
        c2.mueveCentro(2.0, 3.0);
        c2.cambiaRadio(5.0);
        c2.visualiza();
    }
}




// Herencia (Circulo como una clase derivada de Punto):
// Ventajas:
// Código más corto: No necesito escribir métodos para acceder o modificar las coordenadas del círculo, ya que puedo usar los métodos de la clase Punto.
// Desventajas:
// Acoplamiento: La clase Circulo está fuertemente acoplada a la clase Punto. Si cambio la implementación de Punto, también podría tener que cambiar la implementación de Circulo.


// Composición (Circulo con un miembro de tipo Punto):
// Ventajas:
// Flexibilidad: La composición es más flexible que la herencia porque puedes cambiar el comportamiento de tu objeto .
// Menor acoplamiento: La clase Circulo no está tan fuertemente acoplada a la clase Punto. Si cambiao la implementación de Punto, es menos probable que tenga que cambiar la implementación de Circulo.
// Desventajas:
// Más código: Necesito escribir métodos para acceder o modificar las coordenadas del círculo.


// En general, la composición se considera una opción más flexible y robusta. La regla general es "preferir la composición sobre la herencia" 
// a menos que haya una razón específica para usar la herencia.