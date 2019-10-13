package com.example.bullanga;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {



        private Socket socket;
        private ServerSocket serverSocket;


        @Override
        public void run() {
            try {
                serverSocket=new ServerSocket(8888);
                socket=serverSocket.accept();
                System.out.println(socket.toString());
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}

