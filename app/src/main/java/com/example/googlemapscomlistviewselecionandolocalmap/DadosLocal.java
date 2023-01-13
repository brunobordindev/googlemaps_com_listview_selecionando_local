package com.example.googlemapscomlistviewselecionandolocalmap;

public class DadosLocal {

    private String titulo;
    private String endereco;
    private double latitude;
    private double longitude;

    public DadosLocal() {
    }

    public DadosLocal(String titulo, String endereco, double latitude, double longitude) {
        this.titulo = titulo;
        this.endereco = endereco;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public DadosLocal(DadosLocal dl) {
        this.titulo = dl.titulo;
        this.endereco = dl.endereco;
        this.latitude = dl.latitude;
        this.longitude = dl.longitude;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
