package com.example.oskar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class OskarApplication {

    public static void main(String[] args) {

        SpringApplication.run(OskarApplication.class, args);
        Kriticar k = new Kriticar("marko","manic",200);
        System.out.println(k.getReputacija());
        Glumac g = new Glumac("marko","manic",new Date(1987,12,21),Pol.MUSKI);
        g.odrziGovor();



    }






}
