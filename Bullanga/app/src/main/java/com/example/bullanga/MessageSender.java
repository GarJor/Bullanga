package com.example.bullanga;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender extends AsyncTask<String,Void,Void> {
    Socket s;
    DataOutputStream dos;
    String host;
    PrintWriter pw;

    public MessageSender(String hosst) {
        host = hosst;
        System.out.print(hosst);
    }

    @Override
    protected Void doInBackground(String... voids) {

        String message = voids[0];
        try {
            System.out.print("EntraMessageSender");
            s = new Socket(host, 8888);
            pw = new PrintWriter(s.getOutputStream());
            pw.write(message);
            pw.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}