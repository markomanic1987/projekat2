package com.example.oskar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClanEkipeController {
    @Autowired
    private ClanEkipeService clanEkipeServicer;

    @RequestMapping("/clanovi")
    public List<ClanEkipe> vidiClanove() {
        return clanEkipeServicer.vidiSveClanove();
    }

    @RequestMapping("/clanovi/{ime}")
    public ClanEkipe vidiJednogClana(@PathVariable String ime) {
        return clanEkipeServicer.vidiClana(ime);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/clanovi")
    public void dodajClana(@RequestBody ClanEkipe clanEkipe) {
        clanEkipeServicer.dodajClana(clanEkipe);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/clanovi/{ime}")
    public void izmeniClana(@RequestBody ClanEkipe clanEkipe, @PathVariable String ime) {
        clanEkipeServicer.izmeniClana(clanEkipe, ime);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/clanovi/{ime}")
    public void izbrisiClana(@RequestBody String ime) {
        clanEkipeServicer.izbrisiClana(ime);

    }
}
