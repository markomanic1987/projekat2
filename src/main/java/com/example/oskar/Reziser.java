package com.example.oskar;

import java.util.Date;

public class Reziser extends ClanEkipe implements Comparable<Reziser> {
    private int reziranihFilmova;

    public Reziser(String ime, String prezime, Date datumRodjenja, Pol pol, int reziranihFilmova) {
        super(ime, prezime, datumRodjenja, pol);
        this.reziranihFilmova = reziranihFilmova;
    }

    @Override
    public String toString() {
        return super.toString()+" i imam "+reziranihFilmova;
    }

    @Override
    public void odrziGovor() {
        System.out.println("ja sam "+this+" i sada drzim govor");
    }

    @Override
    public void primiOskara() {
        System.out.println("ja sam "+this+" i primio sam oskara");
    }

    public int getReziranihFilmova() {
        return reziranihFilmova;
    }

    public void setReziranihFilmova(int reziranihFilmova) {
        this.reziranihFilmova = reziranihFilmova;
    }

    @Override
    public int compareTo(Reziser o) {
        return o.reziranihFilmova>reziranihFilmova ? 1 : o.reziranihFilmova<reziranihFilmova ? -1:0;
    }

}
