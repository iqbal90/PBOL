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

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(5678);
            byte[] buffer = new byte[256];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            System.out.println("waiting for server bray");
            while (true) {
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                String a = new String(data, 0, datagramPacket.getLength());
                System.out.println(datagramPacket.getAddress().getHostAddress() + " : " + datagramPacket.getPort() + " : " + a);
                a = "data yang terkirim : " + a;
                DatagramPacket packet = new DatagramPacket(a.getBytes(), a.getBytes().length, datagramPacket.getAddress(), datagramPacket.getPort());
                datagramSocket.send(packet);
            }} catch (IOException e) {
            System.out.println(e);
        }}}
