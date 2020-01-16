package com.example.oskar;

import java.util.ArrayList;

public class Film implements Nominovan,Comparable<Film> {
    private String naziv;
    private int trajanje;
    private int godina;
    private double rejting;
    private Zanr zanr;
    private ArrayList<ClanEkipe> clanoviEkipe;




    public String getNaziv() {
        return naziv;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public int getGodina() {
        return godina;
    }

    public double getRejting() {
        return rejting;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public ArrayList<ClanEkipe> getClanoviEkipe() {
        return clanoviEkipe;
    }

    @Override
    public String toString() {
        return  naziv + " " +trajanje +" "+ godina +" "+ rejting +" "+ zanr;

    }

    @Override
    public int compareTo(Film o) {
        return 0;
    }

    @Override
    public void primiOskara() {

    }
}