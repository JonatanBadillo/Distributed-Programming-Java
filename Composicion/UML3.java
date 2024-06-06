class O1 {
    private int unAtributo;
    private int otroAtributo;
    private O2 vinculoO2; // Este enlace no debe aparecer en un "return"
    private O3 vinculoO3;

    public O1(O3 vinculoO3) {
        vinculoO2 = new O2(); // se crea un vinculo de composición
        this.vinculoO3 = vinculoO3; // se crea un vinculo de agregación
    }

    public void trabajoParaO1() {
        vinculoO2.trabajoParaO2(); // un mensaje a O2
        vinculoO3.trabajoParaO3(); // un mensaje a O3
    }

    public int otroMetodo(int a) {
        return a;
    }

    protected void finaliza() { // llamar a este método cuando el objeto se borra de la memoria
        System.out.println("aaahhhh... un Objeto O1 esta muriendo...");
    }
}

class O2 {
    private int unAtributo;
    private double otroAtributo;

    public O2() {
    }

    public void trabajoParaO2() {
        System.out.println("Soy una instancia de O2 " + " al servicio de todas las clases");
    }

    protected void finaliza() {
        System.out.println("aaahhhh... un objeto O2 esta muriendo...");
    }
}

class O3 {
    public void trabajoParaO3() {
        System.out.println("Soy una instancia de O3 " + " sirviendo a todas las clases");
    }

    protected void finaliza() {
        System.out.println("aaahhhh... un Objeto O3 esta muriendo...");
    }
}

public class UML3 {
    public static void main(String[] args) {
        O3[] losObjetos3 = new O3[10000];
        for (int i = 0; i < 10000; i++) {
            losObjetos3[i] = new O3();
            O1 unObjeto1 = new O1(losObjetos3[i]);
            // Pasamos aquí el referente del objeto O3 al objeto O1
            unObjeto1.trabajoParaO1();
            unObjeto1 = null;
            // Con esta instrucción, intentamos deshacernos del objeto unObjeto1, pero no es
            // no es necesario
        }
    }
}