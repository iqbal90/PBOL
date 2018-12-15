/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author burha
 */
import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        DatagramSocket datagramSocket = null;
        String a;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            datagramSocket = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getByName("localhost");
            while (true) {
                System.out.print("Message : ");
                a = bufferedReader.readLine();
                byte[] b = a.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(b, b.length, inetAddress, 5678);
                datagramSocket.send(datagramPacket);
                byte[] buffer = new byte[256];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(packet);
                byte[] data = packet.getData();
                a = new String(data, 0, packet.getLength());
                System.out.println(packet.getAddress().getHostName() + " : " + packet.getPort() + " : " + a);
            }} catch (IOException e) {
            System.out.println(e);
        }}}