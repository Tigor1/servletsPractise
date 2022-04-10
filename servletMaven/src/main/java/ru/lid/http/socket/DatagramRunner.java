package ru.lid.http.socket;

import java.io.IOException;
import java.net.*;


//UDP протокол не проверяет вообще ничего(отвечает, принимает ли сервер или нет)
//UDP сервер может одновременно слушать на том же порту, что и TCP
public class DatagramRunner {



    public static void main(String[] args) throws IOException {
        var inetAddress = InetAddress.getByName("localhost");

        try (var datagramSocket = new DatagramSocket()) {
//            буффер это массив, в который кто-то записывает информацию и кто-то читает
//            -----------> [buffer] <------------
            var bytes = "hello, from UDP client".getBytes();
            var packet = new DatagramPacket(bytes, bytes.length, inetAddress, 7777);
            datagramSocket.send(packet);
        }
    }
}
