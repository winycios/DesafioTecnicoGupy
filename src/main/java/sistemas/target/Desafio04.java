package sistemas.target;

import java.util.List;

public class Desafio04 {

/*    4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
            • SP – R$67.836,43
            • RJ – R$36.678,66
            • MG – R$29.229,88
            • ES – R$27.165,48
            • Outros – R$19.849,53

    Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.*/


    public static void main(String[] args) {

        List<Faturamento> faturamentos = List.of(
                new Faturamento("SP", 67_836.43),
                new Faturamento("RJ", 36_678.66),
                new Faturamento("MG", 29_229.88),
                new Faturamento("ES", 27_165.48),
                new Faturamento("Outros", 19849.53)
        );


        calcularPercentual(faturamentos).forEach(System.out::println);

    }

    private static List<Faturamento> calcularPercentual(List<Faturamento> faturamentos) {
        final double totalFaturamento = faturamentos.stream().mapToDouble(Faturamento::getValor).sum();

        System.out.println("Total faturamento: R$ " + totalFaturamento);

        return faturamentos.stream()
                .peek(faturamento -> faturamento.setPercentual(faturamento.getValor() / totalFaturamento * 100)).toList();
    }


    private static class Faturamento {

        private String estado;
        private Double valor;
        private Double percentual;

        public Faturamento(String estado, Double valor) {
            this.estado = estado;
            this.valor = valor;
        }

        public Faturamento() {
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public Double getValor() {
            return valor;
        }

        public void setValor(Double valor) {
            this.valor = valor;
        }

        public Double getPercentual() {
            return percentual;
        }

        public void setPercentual(Double percentual) {
            this.percentual = percentual;
        }


        @Override
        public String toString() {
            return String.format("Estado: %s, Valor: R$ %.2f, Percentual: %.2f%%", estado, valor, percentual);
        }
    }
}
