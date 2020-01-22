package com.example.oskar;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ClanEkipeService {


    private List<ClanEkipe> clanoviEkipe =new ArrayList<>(Arrays.asList(
            new Glumac("MArko","Manic",new Date(1987,12,12),Pol.MUSKI),
            new Reziser("Ivan","ivanovic",new Date(1990,10,30),Pol.MUSKI,6),
            new Glumac("Jelena","Manic",new Date(1980,1,1),Pol.ZENSKI),
            new Reziser("Ivana","Peric",new Date(1982,6,6),Pol.ZENSKI,1)
    ));
    public List<ClanEkipe> vidiSveClanove(){
        return clanoviEkipe;
    }
    public ClanEkipe vidiClana(String ime){
       return clanoviEkipe.stream().filter(t->t.getIme().equals(ime)).findFirst().get();
    }

    public void dodajClana(ClanEkipe clanEkipe) {
        clanoviEkipe.add(clanEkipe);
    }

    public void izmeniClana(ClanEkipe clanEkipe,String ime) {
        for(int i=0; i<clanoviEkipe.size();i++){
            ClanEkipe c = clanoviEkipe.get(i);
            if(c.getIme().equals(ime)){
                clanoviEkipe.set(i,clanEkipe);
                return;
            }
        }
    }

    public void izbrisiClana(String ime) {
        clanoviEkipe.removeIf(t->t.getIme().equals(ime));
    }
}
