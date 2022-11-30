package tich;

import java.io.*;
import java.net.*;
import java.util.*;

public class client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Đang kết nối");
            Socket socket = new Socket("localhost", 8888);
            System.out.println("Đã kết nối");
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());
            while (true) {
                System.out.println("Nhập số a: ");
                output.writeDouble(sc.nextDouble());
                output.flush();
                System.out.println("Nhập số b: ");
                output.writeDouble(sc.nextDouble());
                output.flush();
//Nhận data
                double a = input.readDouble();
                double b = input.readDouble();
                double sum = input.readDouble();
                System.out.println("Tích 2 số là " + a +" * "+ b + " = " +sum);
                System.out.println("Bạn có muốn tiếp tục y/N");
                String rep = sc.next();
                if(rep.equalsIgnoreCase("N")){
                        break;
                }
            }
        } catch (Exception e) {
        }
    }
}
