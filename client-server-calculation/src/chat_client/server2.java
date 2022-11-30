package chat_client;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class server2 extends Thread {
    private Socket socket;
    private ArrayList<server2> threadList;
    private PrintWriter output;
    public server2(Socket socket, ArrayList<server2> threads) {
        this.socket = socket;
        this.threadList = threads;
    }
    @Override
    public void run() {
        try {
            // Đọc đầu vào từ Client
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // trả lại đầu ra cho máy khách: câu lệnh true là xóa bộ đệm nếu không phải làm thủ công
            output = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                String outputString = input.readLine();
                if (outputString.equals("thoat")) {
                    break;
                }
                printToALlClients(outputString);
                System.out.println("Người dùng " + outputString );
            }
        } catch (Exception e) {
        //      System.out.println("Xuất hiện lỗi" + e.getStackTrace());
        }
    }
    private void printToALlClients(String outputString) {
        for (server2 sT : threadList) {
            sT.output.println(outputString);
        }
    }
}
