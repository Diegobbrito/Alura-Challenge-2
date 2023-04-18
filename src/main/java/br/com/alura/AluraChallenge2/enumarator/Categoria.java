package br.com.alura.AluraChallenge2.enumarator;

public enum Categoria {
    ALIMENTACAO("Alimentação"),
    SAUDE("Saúde"),
    MORADIA("Moradia"),
    TRANSPORTE("Transporte"),
    EDUCACAO("Educação"),
    LAZER("Lazer"),
    IMPREVISTOS("Imprevistos"),
    OUTRAS("Outras");

    private final String categoria;

    Categoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}
