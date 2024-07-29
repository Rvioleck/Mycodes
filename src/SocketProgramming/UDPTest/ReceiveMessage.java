package SocketProgramming.UDPTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMessage {


    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(24444);
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

        while (true) {
            socket.receive(packet);
            String info = new String(packet.getData(), 0, packet.getLength());
            if ("886".equals(info)) {
                break;
            }
            InetAddress address = packet.getAddress();
            System.out.println(info + " " + address.getHostAddress());
        }

    }

}
