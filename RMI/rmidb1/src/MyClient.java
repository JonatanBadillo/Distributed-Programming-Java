import java.rmi.Naming;

public class MyClient {

    public static void main(String[] args) {
        try {
            // Busca el objeto remoto registrado con el nombre "sonoo" en el registro RMI en localhost y puerto 5000
            Adder stub = (Adder) Naming.lookup("rmi://localhost:5000/sonoo");

            // Invoca el método remoto 'add' en el objeto remoto 'stub' con los argumentos 34 y 4
            int result = stub.add(34, 4);

            // Imprime el resultado de la operación remota
            System.out.println("Result: " + result);
        } catch (Exception e) {
            // Maneja cualquier excepción que ocurra durante la búsqueda o invocación del objeto remoto
            System.out.println(e);
        }
    }
}
