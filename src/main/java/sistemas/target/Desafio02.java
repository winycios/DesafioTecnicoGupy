package sistemas.target;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Desafio02 {


/*
    2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...),
    escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
    IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;
*/

    public static void main(String[] args) {

       try {
           Scanner scanner = new Scanner(System.in);
           System.out.print("Digite um número: ");
           int num = scanner.nextInt();
           scanner.close();

           if (eFibonacci(num)) {
               System.out.println(num + " pertence à sequência de Fibonacci.");
           } else {
               System.out.println(num + " não pertence à sequência de Fibonacci.");
           }
       } catch (InputMismatchException e) {
           System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
       }
    }

    private static boolean eFibonacci(int n) {
        if (n < 0) return false;
        return quadradoPerfeito(5 * n * n + 4) || quadradoPerfeito(5 * n * n - 4);
    }

    private static boolean quadradoPerfeito(int x) {
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }
}
