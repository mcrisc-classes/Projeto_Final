package modelo;

import java.sql.Date;

public class Tarifa {

    private String placa;
    private float preco_bloco;
    private Date dt_pagamento;
    private float valor_pago;

    public String getPlaca() {
        return placa;
    }

    public Date getDt_pagamento() {
        return dt_pagamento;
    }

    public void setDt_pagamento(Date dt_pagamento) {
        this.dt_pagamento = dt_pagamento;
    }

    public float getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(float valor_pago) {
        this.valor_pago = valor_pago;
    }

    public float getPreco_bloco() {
        return preco_bloco;
    }

    public void setPreco_bloco(float preco_bloco) {
        this.preco_bloco = preco_bloco;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}