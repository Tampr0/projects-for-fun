package net.socket;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;

@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        try {
            Thread t = new MyServer(59480);

            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
