package tim_so_nguyen_to;

import java.io.*;
import java.net.*;
import java.util.*;

public class server {

    public static void main(String[] args) {
        try {
            ServerSocket sv = new ServerSocket(8000);
            System.out.println("Chờ kết nối");
            Socket socket = sv.accept();
            System.out.println("Đã kết nối");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            while (true) {
                    int a = input.readInt();
                    System.out.println("Kiểm tra số "+a);
                    output.writeInt(a);
                    output.flush();
                    if (a < 2) {
                        String ketqua = "Không phải là số nguyên tố";
                        output.writeUTF(ketqua);
                        output.flush();
                    }
                    for (int i = 2; i <= Math.sqrt(a); i++) {
                        if (a % i == 0) {
                            String ketqua = "Là số nguyên tố";
                            output.writeUTF(ketqua);
                            output.flush();
                        } else {
                          String  ketqua = "Là số nguyên tố";
                            output.writeUTF(ketqua);
                            output.flush();
                        }
                    }
            }
        } catch (Exception e) {
        }
    }
}
