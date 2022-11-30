package client.server.calculation;

import java.io.*;
import java.net.*;
import java.util.*;
public class server {


    public static void main(String[] args) {
    try{
        ServerSocket  sv = new ServerSocket (8888);
        System.out.println("Đang kết  nối... ");
        Socket socket = sv.accept();
        System.out.println("Đã kết nối");
//        Nhận data từ client
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        while (true) {            
           double a = input.readDouble();
           double b = input.readDouble();
            System.out.println("Số a là: " +a);
            System.out.println("Số b là: " +b);
            double sum = a + b;
//            Truyền kết quả sang client
            output.writeDouble(sum);
            output.flush();
        }
    }
    catch(Exception e){
    }
    }
    
}
