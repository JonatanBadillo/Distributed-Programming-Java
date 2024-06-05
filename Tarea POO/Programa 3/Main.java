// Sea la siguiente clase:
class Punto {
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void visualiza() {
        System.out.println("Coordenadas : " + x + " " + y);
    }

    private int x, y;
}

// Propone una clase PuntoName, derivada de Punto, que te permita manipular puntos definidos
// por sus coordenadas y un nombre (carácter). Se proporcionarán los siguientes métodos:
//         • constructor para definir las coordenadas y el nombre de un objeto de tipo PuntoName
//         • visualiza para mostrar las coordenadas y el nombre de un objeto de tipo PuntoName.


class PuntoName extends Punto{
    private String name;
    // Constructor para definir las coordenadas y el nombre 
    public PuntoName(int x, int y, String name){
        super(x, y);// Llamada al constructor de la clase padre
        this.name = name;
    }

    // Método visualiza que muestra las coordenadas del punto y su nombre
    @Override// -> Método que está sobrescribiendo un método de la superclase
    public void visualiza(){
        super.visualiza();  // Llamar al método visualiza() de la clase padre
        System.out.println("Nombre : " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        int x = 5;
        int y = 3;
        String name = "Punto 1";
        // Crear un objeto PuntoName
        PuntoName puntoConNombre = new PuntoName(x,y,name);
        // Mostrar las coordenadas y el nombre
        puntoConNombre.visualiza();
    }
}
