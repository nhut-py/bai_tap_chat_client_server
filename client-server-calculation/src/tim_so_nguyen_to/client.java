package tim_so_nguyen_to;

import java.io.*;
import java.net.*;
import java.util.*;

public class client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Đang kết nối");
            Socket socket = new Socket("localhost", 8000);
            System.out.println("Đã kết nối");
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());
            while (true) {
                System.out.println("Nhập số cần kiểm tra: ");
                output.writeInt(sc.nextInt());
                output.flush();
                int a = input.readInt();
                String ketqua = input.readUTF();
                System.out.println("Số: "+a+" " + ketqua);
                System.out.println("Tiếp tục Y/n");
                String rep = sc.next();
                if(rep.equalsIgnoreCase("N")){
                    break;
                }
            }
        } catch (Exception e) {
        }
    }
}
