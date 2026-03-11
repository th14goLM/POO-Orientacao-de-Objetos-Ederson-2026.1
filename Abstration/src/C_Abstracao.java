// Exemplo de Abstração
// Definição de uma abstração chamada de forma de pagamento
// As classes concretas serão pix, cartão de credito, implementar o como pagar
// O sistema de checkout depende da abstração, não das classes concretas

// Isso vai facilitar novas formas de pagamento sem alterar o checkout

import java.util.Objects;

interface FormaPagamento{
    void pagar(double valor);
}

class Pix implements FormaPagamento{
    @Override
    public void pagar(double valor){
        IO.println("Pagamento via Pix no valor de R$ " + String.format("%.2f", valor));
    }
}

class CartaoCredito implements FormaPagamento{
    private final String ultimosDigitos;

    public CartaoCredito(String ultimosDigitos){
        if (ultimosDigitos == null || ultimosDigitos.length() !=4){
            throw new IllegalArgumentException("Informe os 4 últimos digitos do cartão de Crédito!");
        }
        this.ultimosDigitos = ultimosDigitos;
    }

    @Override
    public void pagar(double valor) {
        IO.println("Pagamento via Cartão (**** " + ultimosDigitos + ") no valor de R$ " + String.format("%.2f", valor));
    }
}

class Checkout{
    private final FormaPagamento formaPagamento; // Depende da abstração, não do concreto
    public Checkout(FormaPagamento formaPagamento){
        this.formaPagamento = Objects.requireNonNull(formaPagamento);
    }
    public void finalizarCompra(Double total){
        if(total<=0) {
            throw new IllegalArgumentException("Valor de compra inválido, otal deve ser positivo!");
        }
            // O checkout não sabe como pagar, só chama o contrato, a classe de abstração
            formaPagamento.pagar(total);
            IO.println("Compra finalizada com sucesso!");
        }
    }

    // Demonstração
public class C_Abstracao{
     static void main(){
        // Exemplo de pagamento com o Pix
        Checkout compraPix = new Checkout(new Pix());
        compraPix.finalizarCompra(199.90);

        IO.println("---------");

        // Exemplo de pagamento com Cartão de Crédito
        Checkout compraCartao = new Checkout(new CartaoCredito("4160"));
        compraCartao.finalizarCompra(349.90);
    }
}