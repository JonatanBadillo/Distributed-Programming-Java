import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {
    public static final String UNIQUE_BINDING_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, NotBoundException {
        final Registry registry = LocateRegistry.getRegistry(2732);
        Calculator calculator = (Calculator) registry.lookup(UNIQUE_BINDING_NAME);

        // Test multiplication
        int multiplyResult = calculator.multiply(20, 30);
        System.out.println("Multiplication result: " + multiplyResult);

        // Test addition
        int addResult = calculator.add(10, 5);
        System.out.println("Addition result: " + addResult);

        // Test subtraction
        int subtractResult = calculator.subtract(10, 5);
        System.out.println("Subtraction result: " + subtractResult);

        // Test division
        try {
            double divideResult = calculator.divide(10, 2);
            System.out.println("Division result: " + divideResult);
        } catch (ArithmeticException e) {
            System.err.println("Division error: " + e.getMessage());
        }

        // Send message to server
        String serverResponse = calculator.sendMessageToServer("Hello Server!");
        System.out.println(serverResponse);

        // Send message to client (from the server side)
        String clientResponse = calculator.sendMessageToClient("Hello Client!");
        System.out.println(clientResponse);
    }
}
