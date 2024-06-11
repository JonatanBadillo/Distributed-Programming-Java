package com.mycompany.lambda1;

interface FuncInterface
{
    // An abstract function
    void abstractFun(int x);


    // A non-abstract (or default) function
    default void normalFun()
    {
        System.out.println("Hello");
    }
}

public class Lambda1 {

    public static void main(String[] args) {
        // expresión lambda para implementar la interfaz funcional anterior.

        // Se crea una instancia de FuncInterface .

        // Esta interfaz por defecto implementa abstractFun()
        FuncInterface fobj = (int x)->System.out.println(2*x);



        // Esto llama a la expresión lambda anterior y imprime 10.
        fobj.abstractFun(5);

    }
}