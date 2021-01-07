package net.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer extends Thread{

    private ServerSocket serverSocket;


    public MyServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port, 5, InetAddress.getByName("localhost"));
        this.serverSocket.setSoTimeout(20000);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("SERVER SOCKET DETAILS");
                System.out.println("Local Port: " + serverSocket.getLocalPort());
                System.out.println("CanonicalHostName: " + serverSocket.getInetAddress().getCanonicalHostName());
                System.out.println("Host Address  " + serverSocket.getInetAddress().getHostAddress());
                System.out.println("Local Socket Address:  " + serverSocket.getLocalSocketAddress().toString());

                try {
                    System.out.println("TimeOut  " + serverSocket.getSoTimeout());
                } catch (IOException e) {
                    System.out.println(e);
                }
                System.out.println("NEW BLOCK OF CODE ===============>");
                System.out.println("Waiting for client on port " +
                        serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();

                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());

                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Konrad, Ty stary sukin&%$u " + server.getLocalSocketAddress()
                        + "\nGoodbye!");
                server.close();

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}





