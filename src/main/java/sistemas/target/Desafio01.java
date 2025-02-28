package sistemas.target;

public class Desafio01 {

    public static void main(String[] args) {

        System.out.println(desafio01(13, 0, 0));
    }

    private static int desafio01(int indice, int soma, int k) {

        while (k < indice) {
            soma += ++k;
        }

        return soma;
    }
}
