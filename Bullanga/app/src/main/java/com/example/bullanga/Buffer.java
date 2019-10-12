package com.example.bullanga;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
private Queue<String>  cua;

    public Buffer(){
        cua = new LinkedList<>();
    }

    public void push(Paquet p){
        String aux = p.parse();
        cua.add(aux);
    }

    public Paquet pop(){   //Retorna un bon paquet
        String head = cua.peek();
        cua.remove();
        Gson gson = new Gson();
         return gson.fromJson(head, Paquet.class);
    }

}
