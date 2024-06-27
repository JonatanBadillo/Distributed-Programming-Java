import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdderRemote extends UnicastRemoteObject implements Adder {

    protected AdderRemote() throws RemoteException {
        super();
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }
}
