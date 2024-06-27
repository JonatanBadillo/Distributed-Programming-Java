import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Calculator extends Remote {
    int multiply(int x, int y) throws RemoteException;
}
