package ru.lid.http.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlExample {

    public static void main(String[] args) throws IOException {

        readFile("file:/Users/18445419/Documents/useFullProgerStuff/java/servlet/src/main/java/ru/lid/http/socket/DatagramRunner.java");
    }

//        с помощью класса URL можно обратиться к файлу на нашем жестком диске
    public static void readFile(String s) throws IOException {
        var url = new URL(s);
        var urlconnection = url.openConnection();

        System.out.println(new String(urlconnection.getInputStream().readAllBytes()));
    }

    private static void checkGoogle() throws IOException {
        var url = new URL("https://www.google.com");
        var urlConnection = url.openConnection();

//        Для Post запросов
//        urlConnection.setDoOutput(true);

//        Вот так неудобно можно записывать данные в тело запроса
//        try (var outputStream = new DataOutputStream(urlConnection.getOutputStream())) {
//            outputStream.writeUTF("Hello, world");
//        }

//      Получение body
//        urlConnection.getInputStream();
//        urlConnection.getContent();
        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }
}
