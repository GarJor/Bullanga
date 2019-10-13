package com.example.bullanga;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class initializeListener extends Thread {
    ServerSocket ss;
    Socket s;
    InputStreamReader isr;
    BufferedReader br;
    String message;

    Thread t = new Thread() {
        @Override
        public void run() {
            try {
                ss = new ServerSocket(8888);
                while (true) {
                    System.out.print("Holaserver");
                    ss.accept();
                    isr = new InputStreamReader(s.getInputStream());
                    br = new BufferedReader(isr);
                    message = br.readLine();
                    if (message != "") {
                        aux += "\n" + message;
                        System.out.print(aux);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}

