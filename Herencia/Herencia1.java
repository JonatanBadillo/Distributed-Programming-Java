class O1 {
    private HijaO2 vinculoHijaO2;

    public O1(HijaO2 vinculoHijaO2) {
        this.vinculoHijaO2 = vinculoHijaO2;
    }

    public void trabajoParaO1() {
        vinculoHijaO2.trabajoParaO2();
        vinculoHijaO2.trabajoParaLaHijaO2();
    }

    // en los resultados mostrados, este método está primero activo, luego comentado
    public void trabajoTambienParaO1(HijaO2 vinculoHijaO2) {
        vinculoHijaO2.trabajoParaO2();
        vinculoHijaO2.trabajoParaLaHijaO2();
    }

    public void trabajoTambienParaO1(O2 vinculoO2) {
        vinculoO2.trabajoParaO2();
    }
}

class O2 {
    public O2() {
    }

    public void trabajoParaO2() {
        System.out.println("Soy un servicio proporcionado por la clase O2");
    }
}

class HijaO2 extends O2 { // Esta es la sintaxis de herencia en java
    public HijaO2() {
    }

    public void trabajoParaLaHijaO2() {
        System.out.println("Soy un servicio proporcionado por la clase HijaO2");

    }
}

public class Herencia1 {
    public static void main(String[] args) {
        O2 unObjetoO2 = new O2();
        HijaO2 unaHijaO2 = new HijaO2();
        O1 unObjetoO1 = new O1(unaHijaO2);
        unObjetoO1.trabajoParaO1();
        unObjetoO1.trabajoTambienParaO1(unObjetoO2);
        unObjetoO1.trabajoTambienParaO1(unaHijaO2);
    }
}