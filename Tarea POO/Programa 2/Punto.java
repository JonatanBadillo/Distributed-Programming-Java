// Sea la siguiente clase Punto:

class Punto {

    // Establecer los valores de las coordenadas x e y
    public void inicializa(int x, int y) {
        // this.x y this.y son las variables de instancia x e y de la clase Punto.
        this.x = x;
        this.y = y;
    }


     //Desplaza el punto en las coordenadas x e y.
    public void desplaza(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x, y;
}


// Proponer una clase PuntoA, derivada de Punto con un método visualiza que muestra (en la
// ventana de la consola) las coordenadas de un punto. Escribe un pequeño programa utilizando
// las dos clases Punto y PuntoA.