package giai_thua;

import java.io.*;
import java.net.*;
import java.util.*;

public class client {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Dang ket noi");
            Socket socket = new Socket("localhost", 8888);
            System.out.println("Da ket noi");
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());
            while (true) {
                System.out.println("Nhập số cần tính:");
                output.writeInt(sc.nextInt());
                output.flush();
                int ketqua = input.readInt();
                System.out.println("Kết quả là " +ketqua);
                System.out.println("Tiếp tục Y/n");
                String rep = sc.next();
                if(rep.equalsIgnoreCase("N")){
                    break;
                }
            }
        } catch (Exception a) {
        }
    }
}
