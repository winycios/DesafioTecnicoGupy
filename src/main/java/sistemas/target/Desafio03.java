package sistemas.target;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Desafio03 {

/*    3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
            • O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

            IMPORTANTE:
    a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
    b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;
    */

    public static void main(String[] args) {

        Faturamento[] faturamentos = carregarFaturamentos();

        System.out.printf("Menor valor de faturamento: R$ %.2f \n", menorValorFaturamento(faturamentos));
        System.out.printf("Maior valor de faturamento: R$ %.2f \n", maiorValorFaturamento(faturamentos));
        System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia(faturamentos));
    }


    private static double menorValorFaturamento(Faturamento[] faturamentos) {
        return Arrays.stream(faturamentos).min(Comparator.comparingDouble(Faturamento::getValor)).get().getValor();
    }

    private static double maiorValorFaturamento(Faturamento[] faturamentos) {
        return Arrays.stream(faturamentos).max(Comparator.comparingDouble(Faturamento::getValor)).get().getValor();
    }

    private static int diasAcimaDaMedia(Faturamento[] faturamentos) {
        double media = Arrays.stream(faturamentos)
                .mapToDouble(faturamento -> faturamento.getValor() > 0 ? faturamento.getValor() : 0)
                .average()
                .orElse(0);

        return (int) Arrays.stream(faturamentos)
                .filter(faturamento -> faturamento.getValor() > media)
                .count();
    }


    private static Faturamento[] carregarFaturamentos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File arquivo = new File("files/dados.json");
            return objectMapper.readValue(arquivo, Faturamento[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static class Faturamento {
        private int dia;
        private double valor;

        public Faturamento(int dia, double valor) {
            this.dia = dia;
            this.valor = valor;
        }

        public Faturamento() {
        }

        public int getDia() {
            return dia;
        }

        public void setDia(int dia) {
            this.dia = dia;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "Faturamento{" + "dia=" + dia + ", valor=" + valor + '}';
        }
    }
}
