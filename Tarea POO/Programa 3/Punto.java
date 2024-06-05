class Punto {
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void visualiza() {
        System.out.println("Coordenadas : " + x + " " + y);
    }

    private int x, y;
}