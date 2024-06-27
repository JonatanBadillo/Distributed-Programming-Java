import java.rmi.Remote;
import java.rmi.RemoteException;

// La interfaz 'Adder' extiende 'Remote' y declara los métodos remotos que pueden ser invocados por el cliente
public interface Adder extends Remote {
    // Método remoto 'add' que toma dos enteros como argumentos y devuelve un entero
    int add(int x, int y) throws RemoteException;
}
