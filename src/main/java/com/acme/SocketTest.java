package com.acme;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *  establish socket connection and write "hello" to the connection
 *
 */
public class SocketTest
{
    public static void main( String[] args ) throws Exception
    {

        //get files
        String host = System.getProperty("HOST","localhost");
        int port = Integer.parseInt(System.getProperty("PORT","10000"));

        PrintWriter out;
        BufferedReader in;

        //create socket
        System.out.println( "SocketTest>> is about to create a socket to host:"+host+" and port:"+port);

        Socket clientSocket = new Socket(host, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println( "SocketTest>> is about to write to the socket");

        out.println("hello");
        String response = in.readLine();


        System.out.println( "SocketTest>> received response" + response );
    }
}
