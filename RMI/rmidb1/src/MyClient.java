import java.rmi.Naming;

public class MyClient {

    public static void main(String[] args) {
        try {
            // Busca el objeto remoto en el registro RMI
            Adder stub = (Adder) Naming.lookup("rmi://localhost:5000/sonoo");

            // Invoca el método remoto y muestra el resultado
            System.out.println("Result: " + stub.add(34, 4));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
