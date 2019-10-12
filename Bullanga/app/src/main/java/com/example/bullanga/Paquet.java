package com.example.bullanga;


import com.google.gson.Gson;

import java.util.Date;

public class Paquet {  //classe del fucking paquet

    private class header{
        public String emisor;
        public String nom_e;
        public String nome_r;
        public String receptor;
        public Date timestamp;
        private int salts;
    }
    public String payload;
    private header header;

    public Paquet(String emisor, String nom_e, String nom_r, String receptor, String missatge, Date timestamp){

        this.payload = missatge;
        this.header.receptor = receptor;
        this.header.emisor = emisor;
        this.header.salts = 20;
        this.header.timestamp = timestamp;
        this.header.nom_e = nom_e;
        this.header.nome_r = nom_r;

    }


    public int getSalts(){
        return this.header.salts;
    }
    public int dec_salts(){
        this.header.salts -= 1;
        return this.header.salts;
    }
    public Date getTimestamp(){
        return this.header.timestamp;
    }
    public String getNomEmissor(){
        return this.header.nom_e;
    }

    public String getNomReceptor(){
        return this.header.nome_r;
    }
    public String getMacEmissor(){
        return this.header.emisor;
    }
    public String getMacReceptor(){
        return this.header.receptor;
    }
    public String Parse(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
