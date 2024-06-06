// 1) Escribir un método estático de una clase estática Util calculando el valor de la “función de
// Ackermann” definida para m ≥ 0 y n ≥ 0 por:

// • A(0, n) = n+1 para n > 0,   -------> Para cualquier n mayor a 0, si m=0, la función simplemente devuelve n+1.

// • A(m, 0) = A(m-1, 1) para m > 0.  -------> Cuando m>0 y n=0, la función se llama a sí misma con m-1 y n=1.

// • A(m, n) = A(m-1, A(m, n-1)) para m > 0 y n > 0 ----------> Para cualquier m y n mayores a 0, la función se llama a sí misma con m-1 y n-1.



public class Util {
    public static int ackermann(int m, int n) {
        // • A(0, n) = n+1 para n > 0,   -------> Para cualquier n mayor a 0, si m=0, la función simplemente devuelve n+1.
        if (m == 0 && n > 0) {
            return n + 1;
        // • A(m, 0) = A(m-1, 1) para m > 0.  -------> Cuando m>0 y n=0, la función se llama a sí misma con m-1 y n=1.
        } else if (m > 0 && n == 0) {
            return ackermann(m - 1, 1);
        // • A(m, n) = A(m-1, A(m, n-1)) para m > 0 y n > 0 ----------> Para cualquier m y n mayores a 0, la función se llama a sí misma con m-1 y n-1.
        } else if (m > 0 && n > 0) {
            return ackermann(m - 1, ackermann(m, n - 1));
        } else {
            // Esta condición no se debería alcanzar con las restricciones m >= 0 y n >= 0
            // se utiliza para lanzar una excepción de tipo IllegalArgumentException, que indica que se ha producido un valor inapropiado en el programa.
            throw new IllegalArgumentException("Los argumentos m y n deben ser mayores o iguales a 0");
        }
    }



    // Método main para probar la función de Ackermann
    public static void main(String[] args) {
        // Ejemplo de uso
        int m = 2;
        int n = 3;
        int result = ackermann(m, n);
        System.out.println("Ackermann(" + m + ", " + n + ") = " + result);
    }
}

