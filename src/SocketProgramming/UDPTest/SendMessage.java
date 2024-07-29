package SocketProgramming.UDPTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class SendMessage {

    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        System.out.println("Enter the message: ");
        String message = new Scanner(System.in).nextLine();
        DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), new InetSocketAddress("localhost", 24444));
        ds.send(dp);
    }
}
