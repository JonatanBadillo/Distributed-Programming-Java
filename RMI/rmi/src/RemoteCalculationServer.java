import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteCalculationServer extends UnicastRemoteObject implements Calculator {
    protected RemoteCalculationServer() throws RemoteException {
        super();
    }

    @Override
    public int multiply(int x, int y) throws RemoteException {
        System.out.println("Multiplication operation requested by client.");
        return x * y;
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        System.out.println("Addition operation requested by client.");
        return x + y;
    }

    @Override
    public int subtract(int x, int y) throws RemoteException {
        System.out.println("Subtraction operation requested by client.");
        return x - y;
    }

    @Override
    public double divide(int x, int y) throws RemoteException {
        System.out.println("Division operation requested by client.");
        if (y == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return (double) x / y;
    }

    @Override
    public String sendMessageToServer(String message) throws RemoteException {
        System.out.println("Message from client: " + message);
        return "Server received the message: " + message;
    }

    @Override
    public String sendMessageToClient(String message) throws RemoteException {
        System.out.println("Message to client: " + message);
        return "Client received the message: " + message;
    }
}
