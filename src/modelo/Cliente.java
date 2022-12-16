package modelo;

public class Cliente extends Enity {
    private String cpf;
    private String telefone;
    private float saldo;
    private int n_cliente;
    private String observacoes;
    private String placa;

    // -------------------------------------------------------------------------- //
    // Construtores
    // -------------------------------------------------------------------------- //

    public Cliente(String cpf, String telefone, int n_cliente, String observacoes, String placa) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.n_cliente = n_cliente;
        this.observacoes = observacoes;
        this.placa = placa;

    }

    public Cliente() {
    };

    // -------------------------------------------------------------------------- //
    // Getters e setters
    // -------------------------------------------------------------------------- //

    public String getCpf() {
        return cpf;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public int getN_cliente() {
        return n_cliente;
    }

    public void setN_cliente(int n_cliente) {
        this.n_cliente = n_cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}