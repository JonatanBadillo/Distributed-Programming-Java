import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MyServer {

    public static void main(String[] args) {
        try {
            // Inicia el registro RMI en el puerto 5000
            LocateRegistry.createRegistry(5000);

            // Crea una instancia de la implementación del objeto remoto 'AdderRemote'
            Adder stub = new AdderRemote();

            // Vincula el objeto remoto 'stub' al nombre "sonoo" en el registro RMI
            Naming.rebind("rmi://localhost:5000/sonoo", stub);

            // Indica que el servidor está listo para recibir solicitudes del cliente
            System.out.println("Server is ready.");
        } catch (Exception e) {
            // Maneja cualquier excepción que ocurra durante la creación del registro o la vinculación del objeto remoto
            System.out.println(e);
        }
    }
}
