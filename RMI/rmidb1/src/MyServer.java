import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MyServer {

    public static void main(String[] args) {
        try {
            // Inicia el registro RMI en el puerto 5000
            LocateRegistry.createRegistry(5000);

            // Crea una instancia de AdderRemote
            Adder stub = new AdderRemote();

            // Registra el objeto remoto con el nombre "sonoo"
            Naming.rebind("rmi://localhost:5000/sonoo", stub);

            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
