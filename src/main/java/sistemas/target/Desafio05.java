package sistemas.target;

import java.util.Arrays;
import java.util.Scanner;

public class Desafio05 {

 /*   5) Escreva um programa que inverta os caracteres de um string.

    IMPORTANTE:
    a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
    b) Evite usar funções prontas, como, por exemplo, reverse;*/

    public static void main(String[] args) {

        try {
            Scanner ler = new Scanner(System.in);
            System.out.println("Digite uma palavra: ");
            String palavra = ler.nextLine();

            System.out.println(inverter(palavra));

        } catch (Exception e) {
            System.out.println("Erro: " + e.getCause().getCause().getMessage());
        }
    }

    private static String inverter(String palavra) {
        StringBuilder palavraInversa = new StringBuilder();

        for (int i = palavra.length(); i > 0; i--) {
            palavraInversa.append(palavra.charAt(i - 1));
        }

        return palavraInversa.toString();
    }

}
