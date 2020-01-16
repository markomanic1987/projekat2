package com.example.oskar;

import java.util.Date;
import java.util.Random;

public class Glumac extends ClanEkipe {
    private boolean lepGlas;

    public Glumac(String ime, String prezime, Date datumRodjenja, Pol pol) {
        super(ime, prezime, datumRodjenja, pol);
        Random r = new Random();
        this.lepGlas=r.nextBoolean();
    }

    @Override
    public void odrziGovor() {
        System.out.println("Ja sam "+ this+" odrzavam govor");

    }

    @Override
    public void primiOskara() {
        Random r= new Random();
        if(r.nextInt(10)==10){
            System.out.println("Obijam da drzim govor");
        } else
            odrziGovor();
    }

    @Override
    public String toString() {
        return super.toString() + " " + lepGlas;
    }

    public boolean isLepGlas() {
        return lepGlas;
    }
}
