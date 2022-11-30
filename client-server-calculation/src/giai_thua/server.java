package giai_thua;

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
//          Phương thức accept() trả về một tham chiếu tới một socket mới trên Server mà được kết nối với socket của Client
//          Phương pháp này đợi cho đến khi một máy khách kết nối đến máy chủ trên cổng đã cho
            System.out.println("Da ket noi");
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//          Gọi để nhận các luồng vào ra để truyền tin với client.
            DataInputStream input = new DataInputStream(socket.getInputStream());
//          Mỗi Socket có cả một OutputStream và InputStream. OutputStream của Client được kết nối với InputStream của Server, và InputStream của Client được kết nối với OutputStream của Server.
            int ketqua = 1;
            while (true) {
                int a = input.readInt();
                System.out.println("Số cần tính " + a);
                if (a == 0 || a == 1) {
                    ketqua = 1;
                    output.writeInt(ketqua);
                    output.flush();
//          Phương thức flush() xả dữ liệu của một stream và gửi nó vào một stream khác. Nó được yêu cầu sử dụng nếu bạn đã kết nối một stream với một stream khác
                }
                for (int i = 1; i <= a; i++) {
                    ketqua = ketqua*i;
                }
                System.out.println("Kết quả: " + ketqua);                                    
                output.writeInt(ketqua);
                output.flush();

            }
        } catch (Exception e) {
        }
    }
}
