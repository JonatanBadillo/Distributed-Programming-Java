class O1 {
    private int unAtributo;
    private int otroAtributo;
    private O2 vinculoO2; // realiza la asociación con la clase O2

    public O1(O2 vinculoO2) {// El constructor planea recibir una referencia a un objeto de clase 02
        this.vinculoO2 = vinculoO2;
    }

    public void trabajoParaO1() {// Funcion del objeto de la clase O2
        vinculoO2.trabajoParaO2(); // Aquí está el envío del mensaje
    }

    public int otroMetodo(int a) {
        return a;
    }
}

class O2 {
    private int unAtributo;
    private double otroAtributo;

    public O2() {
    }

    public void trabajoParaO2() {
        System.out.println("Estoy al servicio de todas las clases");
    }
}

public class UML2 {
    public static void main(String[] args) {
        O2 unObjeto2 = new O2();
        O1 unObjeto1 = new O1(unObjeto2);
        // se pasa en el constructor del objeto O1 el referente del objeto O2
        unObjeto1.trabajoParaO1();
        // un primer mensaje enviado a mano al objeto de la clase O1 disparará otro a un
        // objeto de la
        // clase O2
    }
}