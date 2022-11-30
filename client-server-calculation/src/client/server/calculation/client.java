package client.server.calculation;

import java.net.*;
import java.io.*;
import java.util.*;

public class client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Đang kết nối...");
            Socket soket = new Socket("localhost", 8888);
            System.out.println("Client đã kết nối...");
            DataOutputStream output = new DataOutputStream(soket.getOutputStream());
            DataInputStream input = new DataInputStream(soket.getInputStream());
            while (true) {                
                System.out.println("Nhập số a: ");
                output.writeDouble(sc.nextDouble());
                output.flush();
                System.out.println("Nhập số b: ");
                output.writeDouble(sc.nextDouble());
                output.flush();
                double sum = input.readDouble();
                System.out.println("Kết quả là: "+sum);
                System.out.println("Tiếp tục Y/n");
                String rep = sc.next();
                if(rep.equalsIgnoreCase("N")){
                    break;
                }
            }
        }
        catch(Exception e){
        }
    }
}
