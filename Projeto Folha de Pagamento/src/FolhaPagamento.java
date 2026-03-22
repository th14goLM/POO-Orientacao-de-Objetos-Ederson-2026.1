public class FolhaPagamento {

    public Holerite calcularSalario(ContratoTrabalho contrato, int horasNormais, int horasExtras) {

        double valorHoraNormal = contrato.getValorHoraNormal();
        double valorHoraExtra = contrato.getValorHoraExtra();

        double valorTotalNormal = horasNormais * valorHoraNormal;
        double valorTotalExtra = horasExtras * valorHoraExtra;

        double adicionalFilhos = 0.0;

        if (contrato.temAdicional()){
            adicionalFilhos = (valorTotalNormal + valorTotalExtra) * 0.10;
        }

        Holerite holeriteGerado = new Holerite(contrato.getFuncionario(),valorTotalNormal,valorTotalExtra,adicionalFilhos);

        return holeriteGerado;
    }
}
