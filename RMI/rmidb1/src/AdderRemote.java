import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// La clase 'AdderRemote' implementa la interfaz 'Adder' y extiende 'UnicastRemoteObject' para ser exportada como objeto remoto
public class AdderRemote extends UnicastRemoteObject implements Adder {

    // Constructor protegido que lanza RemoteException y llama al constructor de la superclase
    protected AdderRemote() throws RemoteException {
        super();
    }

    // Implementación del método remoto 'add' que realiza la suma de dos enteros y devuelve el resultado
    @Override
    public int add(int x, int y) {
        return x + y;
    }
}
