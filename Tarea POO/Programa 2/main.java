

public class Main {
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
