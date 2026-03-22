public class FolhaPagamento {

    /** Método para o calculo do salário dos funcionários  **/
    public Holerite calcularSalario(ContratoTrabalho contrato, int horasNormais, int horasExtras) {

        double valorHoraNormal = contrato.getValorHoraNormal();
        double valorHoraExtra = contrato.getValorHoraExtra();

        double valorTotalNormal = horasNormais * valorHoraNormal;
        double valorTotalExtra = horasExtras * valorHoraExtra;

        double adicionalFilhos = 0.0;

        /** Adicional de pagamento para Pais e Mães  **/
        if (contrato.temAdicional()){
            adicionalFilhos = (valorTotalNormal + valorTotalExtra) * 0.10;
        }

        return new Holerite(contrato.getFuncionario(),valorTotalNormal,valorTotalExtra,adicionalFilhos);
    }
}
