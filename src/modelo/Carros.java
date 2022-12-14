package modelo;

import javax.xml.crypto.Data;

public class Carros {
    private String placa;
    private String descricao;
    private String tipo_cliente;
    private int duracao;
    private int quantidade_blocos;
    private Data hora_entrada;
    private Data hora_sainda;

    public String getPlaca() {
        return placa;
    }

    public Data getHora_sainda() {
        return hora_sainda;
    }

    public void setHora_sainda(Data hora_sainda) {
        this.hora_sainda = hora_sainda;
    }

    public Data getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Data hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public int getQuantidade_blocos() {
        return quantidade_blocos;
    }

    public void setQuantidade_blocos(int quantidade_blocos) {
        this.quantidade_blocos = quantidade_blocos;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}