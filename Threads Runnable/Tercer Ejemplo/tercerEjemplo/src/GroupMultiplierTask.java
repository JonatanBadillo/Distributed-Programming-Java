public class GroupMultiplierTask implements Runnable {
    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;
    private final int startIndex;
    private final int endIndex;
    public GroupMultiplierTask(double[][] result, double[][] matrix1, double[][] matrix2, int
            startIndex, int endIndex) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    // El método run() utilizará tres ciclos para implementar sus cálculos. El primero repasará las
    // filas de la matriz de resultados que esta tarea va a calcular, el segundo procesará todos los
    /// elementos de cada fila y el último calculará el valor de cada elemento:
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < matrix1[i].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }


            }
        }
    }
}