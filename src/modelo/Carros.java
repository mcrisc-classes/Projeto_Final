package modelo;

import java.sql.Date;

public class Carros extends Enity {
    private String placa;
    private String descricao;
    private String tipo_cliente;
    private int duracao;
    private int quantidade_blocos;
    private String hora_entrada;
    private String hora_saida;

    // -------------------------------------------------------------------------- //
    // Construtores
    // -------------------------------------------------------------------------- //

    public Carros(String placa, String descricao, String tipo_cliente, int duracao, int quantidade_blocos,
            String hora_entrada, String hora_sainda) {
        this.placa = placa;
        this.descricao = descricao;
        this.tipo_cliente = tipo_cliente;
        this.duracao = duracao;
        this.quantidade_blocos = quantidade_blocos;
        this.hora_entrada = hora_entrada;
        this.hora_saida = hora_sainda;
    }

    public Carros() {
    };

    // -------------------------------------------------------------------------- //
    // Getters e setters
    // -------------------------------------------------------------------------- //

    public String getPlaca() {
        return placa;
    }

    public String getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(String hora_saida) {
        this.hora_saida = hora_saida;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
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