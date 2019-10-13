package com.example.bullanga;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
        private ServerSocket serverSocket;
        private TextView textView;
        private String incomingMsg;
        private String outgoingMsg;

        public Server(TextView textView) {
            this.textView = textView;
        }

        public void closeServer() {
            try {
                serverSocket.close();
            } catch (IOException e) {
                Log.d("Server", "Closung the server caused a problem");
                e.printStackTrace();
            }
        }


        //@Override
        protected Socket run(Integer port) {

            try {
                serverSocket = new ServerSocket(port);

                //accept connections
                Socket socket = serverSocket.accept();

                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                incomingMsg = in.readLine() + System.getProperty("line.separator");

                //send a message
                outgoingMsg = "You are connected to the Server" + System.getProperty("line.separator");
                out.write(outgoingMsg);
                out.flush();

                return socket;


            } catch (InterruptedIOException e) {
                //if timeout occurs
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();

            }
//      finally {
//          if (serverSocket != null) {
//              try {
//                  serverSocket.close();
//              } catch (IOException e) {
//                  e.printStackTrace();
//              }
//          }
//      }

            return null;
        }


        protected void onPostExecute(Socket socket) {

            if(socket != null) {
                try {

                    Log.i("Server", "Server received: " + incomingMsg);
                    textView.setText("Server received: " + incomingMsg + "\n");

                    textView.append("Server sent: " + outgoingMsg + "\n");
                    Log.i("Server", "Server sent: " + outgoingMsg);

                    socket.close();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else {
                Log.d("Server", "Can't communicate with the client!");
            }
        }
}
