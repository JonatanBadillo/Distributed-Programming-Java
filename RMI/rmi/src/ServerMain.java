import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static final String UNIQUE_BINDING_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {
        final RemoteCalculationServer server = new RemoteCalculationServer();
        final Registry registry = LocateRegistry.createRegistry(2732);
        registry.bind(UNIQUE_BINDING_NAME, server);
        System.out.println("Server started and waiting for client requests.");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
