/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tich;

import java.io.*;
import java.net.*;
import java.util.*;
public class server {
    public static void main(String[] args) {
        try{
                ServerSocket sv = new ServerSocket(8888);
                System.out.println("Chờ kết nối....");
                Socket socket = sv.accept();
                System.out.println("Đã kết nối !");
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                while (true) {                
                double a = input.readDouble();
                double b = input.readDouble();
                    System.out.println("Số a là: " +a);
                    output.writeDouble(a);
                    output.flush();
                    System.out.println("Số b là: " +b);
                    output.writeDouble(b);
                    output.flush();
                    double sum = a * b;
                    output.writeDouble(sum);
                    output.flush();
                }
        }
        catch(Exception e){
        }
    }
}