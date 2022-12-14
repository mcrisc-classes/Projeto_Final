public class Estacionamento {

    private int id;
    private int vagas_ocupadas;
    private int vagas_livres;
    private String tipo_bloco;

    public String getTipo_bloco() {
        return tipo_bloco;
    }

    public int getVagas_ocupadas() {
        return vagas_ocupadas;
    }

    public int getVagas_livres() {
        return vagas_livres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVagas_livres(int vagas_livres) {
        this.vagas_livres = vagas_livres;
    }

    public void setTipo_bloco(String tipo_bloco) {
        this.tipo_bloco = tipo_bloco;
    }

    public void setVagas_ocupadas(int vagas_ocupadas) {
        this.vagas_ocupadas = vagas_ocupadas;
    }
}
