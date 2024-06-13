// Para implementar este ejemplo, hemos utilizado una clase llamada MatrixGenerator.
// La usamos para generar matrices aleatorias para multiplicar. Esta clase tiene un método llamado
// generate() que recibe el número de filas y columnas que deseas en tu matriz como parámetros
// y genera una matriz con esas dimensiones con números aleatorios double. Este es el código
// fuente de la clase:
import java.util.Random;

public class MatrixGenerator {
    public static double[][] generate (int rows, int columns) {
        double[][] ret=new double[rows][columns];
        Random random=new Random();
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                ret[i][j]=random.nextDouble()*10;
            }
        }
        return ret;
    }
}