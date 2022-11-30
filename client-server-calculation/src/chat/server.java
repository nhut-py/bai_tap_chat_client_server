package chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class server {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            ServerSocket sv = new ServerSocket(8888);
            System.out.println("Cho ket noi");
            Socket socket = sv.accept();
            System.out.println("Da ket noi");
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());
            while (true) {
                String a = input.readUTF();
                System.out.println("Nội dung nhận là: "+a);
                System.out.println("Trả lời Y/n");
                String rep = sc.next();
                if (rep.equalsIgnoreCase("N")) {
                    break;
                } else {
                    System.out.println("Nội dung trả lời");
                    String s = sc.next();
                    output.writeUTF(s);
                    output.flush();
                }
            }
        } catch (Exception e) {
        }
    }
}
