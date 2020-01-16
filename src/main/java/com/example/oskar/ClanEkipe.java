package com.example.oskar;

import java.util.Date;

public abstract class ClanEkipe implements Nominovan{
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private Pol pol;

    public abstract void odrziGovor();

    public ClanEkipe(String ime, String prezime, Date datumRodjenja, Pol pol) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public Pol getPol() {
        return pol;
    }
}
