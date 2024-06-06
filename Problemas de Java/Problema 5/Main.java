// V. Queremos tener una jerarquía de clases que permita manipular figuras geométricas.
// Queremos que siempre sea posible extender la jerarquía derivando nuevas clases, pero
// queremos poder imponer que estas últimas siempre tengan los siguientes métodos:
// void visualiza ()
// void homotecia (double coeficiente)
// void rotación (double angulo)
// Escribe la clase abstracta Figura que se pueda utilizar como clase base para todas estas clases.

abstract class Figura {
    public abstract void visualiza();
    public abstract void homotecia(double coeficiente);
    public abstract void rotacion(double angulo);
}

public class Main {
    public static void main(String[] args) {
        
    }
}
