package com.example.oskar;

import java.util.ArrayList;

public class Film implements Nominovan,Comparable<Film> {
    private String naziv;
    private int trajanje;
    private int godina;
    private double rejting;
    private Zanr zanr;
    private ArrayList<ClanEkipe> clanoviEkipe;
    private ArrayList<Kritika> kritike;

    public Film(String naziv, int trajanje, int godina, Zanr zanr,Reziser reziser) {
        this.naziv = naziv;
        if(trajanje<=0)
            this.trajanje=80;
        else
            this.trajanje=trajanje;
        this.godina = godina;
        this.zanr = zanr;
        clanoviEkipe = new ArrayList<>();
        clanoviEkipe.add(reziser);
        kritike= new ArrayList<>();

    }
    public boolean dodajGlumca(Glumac glumac){
        if(!clanoviEkipe.contains(glumac) && zanr !=Zanr.MJUZIKL && zanr != Zanr.ANIMIRANI)
            return clanoviEkipe.add(glumac);
        if(!clanoviEkipe.contains(glumac)&& glumac.isLepGlas())
            return clanoviEkipe.add(glumac);
        return false;
    }
        public boolean dodajRezisera(Reziser reziser){
        if(!clanoviEkipe.contains(reziser)){
            reziser.setReziranihFilmova(reziser.getReziranihFilmova()+1);
            return clanoviEkipe.add(reziser);
        }
        return false;
        }
    public Reziser getPredstavnik(){
        Reziser najstariji= null;
        for (ClanEkipe c :clanoviEkipe ){
            if(c instanceof Reziser){
                if (najstariji==null)
                    najstariji=(Reziser)c;
                else
                    if(c.getDatumRodjenja().compareTo(najstariji.getDatumRodjenja())==1);
                    najstariji=(Reziser)c; }
        }
        return najstariji;
    }
    public boolean dodajKritiku(Kritika kritika){
        for(Kritika k :kritike){
            if(k.getKriticar().equals(kritika.getKriticar()))
                return false;
        }
        return kritike.add(kritika);
    }
    public void izracunajRejting(){
        double suma=0;
        double tezina=0;
        for(Kritika k : kritike){
            suma=suma+k.getOcena()*k.getKriticar().getReputacija();
            tezina= tezina+k.getKriticar().getReputacija();
        }
        this.rejting=suma/tezina;
    }



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

    public ArrayList<Kritika> getKritike() {
        return kritike;
    }

    @Override
    public String toString() {
        return  naziv + " " +trajanje +" "+ godina +" "+ rejting +" "+ zanr;

    }

    @Override
    public int compareTo(Film o) {


        return o.getRejting()>getRejting() ? 1 : o.getRejting()<getRejting() ? -1 : o.getPredstavnik().getReziranihFilmova()>getPredstavnik().getReziranihFilmova() ? -1 : o.getPredstavnik().getReziranihFilmova()<getPredstavnik().getReziranihFilmova() ? 1 :0;
    }

    @Override
    public void primiOskara() {
        getPredstavnik().primiOskara();

    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public void setRejting(double rejting) {
        this.rejting = rejting;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public void setClanoviEkipe(ArrayList<ClanEkipe> clanoviEkipe) {
        this.clanoviEkipe = clanoviEkipe;
    }

    public void setKritike(ArrayList<Kritika> kritike) {
        this.kritike = kritike;
    }
}