package sistemas.target;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Desafio02 {

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

    public static boolean eFibonacci(int n) {
        if (n < 0) return false;
        return quadradoPerfeito(5 * n * n + 4) || quadradoPerfeito(5 * n * n - 4);
    }

    private static boolean quadradoPerfeito(int x) {
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }
}
