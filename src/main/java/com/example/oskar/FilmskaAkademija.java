package com.example.oskar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class FilmskaAkademija {
    static final double MN_REJTING = 0;
    private ArrayList<Glumac> muskaNominacija;
    private ArrayList<Glumac> zenskaNominacija;
    private ArrayList<Film> filmNominacija;
    private ArrayList<Reziser> reziserNominacija;

    public FilmskaAkademija() {
        this.muskaNominacija = new ArrayList<>();
        this.zenskaNominacija = new ArrayList<>();
        this.filmNominacija = new ArrayList<>();
        this.reziserNominacija = new ArrayList<>();
    }

    public boolean nominuj(Nominovan nominovan) {
        if (nominovan instanceof Glumac && ((Glumac) nominovan).getPol() == Pol.MUSKI && !muskaNominacija.contains((Glumac) nominovan))
            muskaNominacija.add((Glumac) nominovan);
        else if (nominovan instanceof Glumac && ((Glumac) nominovan).getPol() == Pol.ZENSKI && !zenskaNominacija.contains((Glumac) nominovan))
            zenskaNominacija.add((Glumac) nominovan);
        else if (nominovan instanceof Reziser && !reziserNominacija.contains(nominovan))
            reziserNominacija.add((Reziser) nominovan);
        else if (nominovan instanceof Film && !filmNominacija.contains(nominovan) && ((Film) nominovan).getRejting() >= MN_REJTING && ((Film) nominovan).getTrajanje() > 40) {
            boolean muskiClan = false, zenskiClan = false;
            for (ClanEkipe c : ((Film) nominovan).getClanoviEkipe()) {
                if (c.getPol() == Pol.MUSKI)
                    muskiClan = true;
                else if (c.getPol() == Pol.ZENSKI)
                    zenskiClan = true;
            }
            if (muskiClan && zenskiClan) {
                if (((Film) nominovan).getZanr() == Zanr.DOKUMENTARNI || ((Film) nominovan).getZanr() == Zanr.BIOGRAFSKI) {
                    if (((Film) nominovan).getTrajanje() < 150)
                        filmNominacija.add((Film) nominovan);
                    else return false;
                }
                return filmNominacija.add((Film) nominovan);
            }
        }
        return false;
    }

    public String getNominacijaIzvestaj() {
        String izvestaj = "Izvestaj o svim nominacijama \n";
        for (Glumac g : muskaNominacija)
            izvestaj = izvestaj + g;
        for (Glumac g : zenskaNominacija)
            izvestaj = izvestaj + g;

        for (Reziser r : reziserNominacija)
            izvestaj = izvestaj + r;
        for (Film f : filmNominacija)
            izvestaj = izvestaj + f;
        return izvestaj;
    }

    public void objaviNominacije() {
        File f = new File("nominacije.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.print(getNominacijaIzvestaj());
        pw.close();
    }

    public void odrziDodelu() {
        if (!muskaNominacija.isEmpty() && !zenskaNominacija.isEmpty() && !filmNominacija.isEmpty() && !reziserNominacija.isEmpty()) {
            Random r = new Random();
            System.out.println("oskar za musku ulogu: ");
            muskaNominacija.get(r.nextInt(muskaNominacija.size())).primiOskara();
            System.out.println("Oskar za zebsku ulogu je: ");
            zenskaNominacija.get(r.nextInt(zenskaNominacija.size())).primiOskara();
            System.out.println("za najbolji film ");
            filmNominacija.get(r.nextInt(filmNominacija.size())).primiOskara();
            System.out.println("oskar za rezisera: ");
            reziserNominacija.get(r.nextInt(reziserNominacija.size())).primiOskara();
        }

    }

    public void ispisiStatistikuFilmova() {
        int[] brojaZanrova = new int[12];
        for(Film f : filmNominacija)
            brojaZanrova[f.getZanr().ordinal()]++;
        for (Zanr z : Zanr.values())
            System.out.println(z+" - "+brojaZanrova[z.ordinal()]+" nominovanovih filmova");
    }
}