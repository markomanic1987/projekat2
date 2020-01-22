package com.example.oskar;

public class Kritika {
    private double ocena;
    private Kriticar kriticar;

    public Kritika(double ocena, Kriticar kriticar) {
        this.ocena = ocena;
        this.kriticar = kriticar;
    }

    @Override
    public String toString() {
        return  ocena +" "+ kriticar  ;
    }

    public double getOcena() {
        return ocena;
    }

    public Kriticar getKriticar() {
        return kriticar;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public void setKriticar(Kriticar kriticar) {
        this.kriticar = kriticar;
    }
}
