import java.util.Date;

// hemos implementado una clase principal para probar el algoritmo del multiplicador
// en serie llamado clase SerialMain. En el método main(), generamos dos matrices aleatorias
// con 2000 filas y 2000 columnas y calculamos la multiplicación de ambas matrices usando la
// clase SerialMultiplier. Medimos el tiempo de ejecución del algoritmo en milisegundos, de la
// siguiente manera:

public class SerialMain {
    public static void main(String[] args) {
        double matrix1[][] = MatrixGenerator.generate(500, 500);
        double matrix2[][] = MatrixGenerator.generate(500, 500);
        double resultSerial[][]= new double[matrix1.length]
                [matrix2[0].length];
        Date start=new Date();
        SerialMultiplier.multiply(matrix1, matrix2, resultSerial);
        Date end=new Date();
        // tiempo usando una implementación serial (es decir, sin paralelismo)
        System.out.printf("Serial: %d%n",end.getTime()-start.getTime());
    }
}