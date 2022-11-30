package tong_1_chia_n;

import java.net.*;
import java.io.*;
import java.util.*;

public class client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Đang kết nối...");
            Socket soket = new Socket("localhost", 8888);
            System.out.println("Client đã kết nối...");
            DataOutputStream output = new DataOutputStream(soket.getOutputStream());
            DataInputStream input = new DataInputStream(soket.getInputStream());
            while (true) {
                System.out.println("Nhập số 1/n: ");
                output.writeInt(sc.nextInt());
                Float sum = input.readFloat();
                System.out.println("Kết quả là " + sum);
                break;
            }
        } catch (Exception e) {
        }
    }
}
