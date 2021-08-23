package br.com.bradesco.coredigital.api.automation.factory.egrees;

import br.com.bradesco.coredigital.api.automation.model.request.egrees.EgreesInvoiceTransactionRequest;
import org.springframework.stereotype.Component;


@Component
public class EgreesInvoiceTransactionFactory {

    public EgreesInvoiceTransactionRequest buildEgreesInvoiceTransactionRequest(String origens, String marca, String numeroCartao,
                                                                             String contaFaturamento, String dataVencimento,
                                                                             String cnpj, String canal, String usuario) {

       return EgreesInvoiceTransactionRequest.builder()
               .origens(origens)
               .marca(marca)
               .numeroCartao(numeroCartao)
               .contaFaturamento(contaFaturamento)
               .dataVencimento(dataVencimento)
               .cnpj(cnpj)
               .canal(canal)
               .usuario(usuario)
               .build();
    }
}
