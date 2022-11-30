package tong_1_chia_n;

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
            float sum = 0;
            while (true) {    
                int n = input.readInt();
                for (int i = 1; i <= n; i++) {
                    sum += 1.0 / i;
                }
                System.out.println("Tổng 1/n là "+sum);
                output.writeFloat(sum);
                output.flush();
            }
           
        } catch (Exception e) {
        }
    }
}
