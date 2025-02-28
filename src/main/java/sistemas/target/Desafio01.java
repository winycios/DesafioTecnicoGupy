package sistemas.target;


public class Desafio01 {
/*
        1) Observe o trecho de código abaixo: int INDICE = 13, SOMA = 0, K = 0;
        Enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; }
        Imprimir(SOMA);
        Ao final do processamento, qual será o valor da variável SOMA?

        R: SOMA = 91
*/


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
