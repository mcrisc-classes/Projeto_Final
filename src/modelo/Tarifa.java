package modelo;

import java.sql.Date;

public class Tarifa {

    private String placa;
    private float preco_bloco;
    private String dt_pagamento;
    private float valor_pago;

    // -------------------------------------------------------------------------- //
    // Construtores
    // -------------------------------------------------------------------------- //

    public Tarifa(String placa, float preco_bloco, String dt_pagamento, float valor_pago) {
        this.placa = placa;
        this.preco_bloco = preco_bloco;
        this.dt_pagamento = dt_pagamento;
        this.valor_pago = valor_pago;
    }

    public Tarifa() {
    }

    // -------------------------------------------------------------------------- //
    // Getters e setters
    // -------------------------------------------------------------------------- //

    public String getPlaca() {
        return placa;
    }

    public String getDt_pagamento() {
        return dt_pagamento;
    }

    public void setDt_pagamento(String dt_pagamento) {
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