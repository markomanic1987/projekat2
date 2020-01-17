package com.example.oskar;

import java.util.Random;

public class Kriticar {
    private String ime;
    private String prezime;
    private int reputacija;

    public Kriticar(String ime, String prezime, int reputacija) {
        this.ime = ime;
        this.prezime = prezime;
        if (reputacija < 100) {
            this.reputacija = reputacija;
        } else
            this.reputacija = 100;
    }
    public void  oceniFilm(Film film){
        Random r = new Random();
        film.dodajKritiku(new Kritika(r.nextInt(10)+1,this));
    }
    public void pohvali(Kriticar pohvaljeni){
        pohvaljeni.reputacija = (int) (pohvaljeni.reputacija + this.reputacija * 0.1);
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getReputacija() {
        return reputacija;
    }

    @Override
    public String toString() {
        return ime+" "+  prezime+" " +reputacija;
    }
}
