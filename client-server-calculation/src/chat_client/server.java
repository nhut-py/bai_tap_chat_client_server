package chat_client;
import java.net.*;
import java.util.ArrayList;

public class server {

    public static void main(String[] args) {
        // sử dụng serverocket làm đối số để tự động đóng socket
        // số cổng là duy nhất cho mỗi máy chủ
        // danh sách để thêm tất cả các clients thread
        ArrayList<server2> threadList = new ArrayList<>();
        try (ServerSocket serversocket = new ServerSocket(5000)){
            while(true) {
                Socket socket = serversocket.accept();
                server2 serverThread = new server2(socket, threadList);
                threadList.add(serverThread); 
                serverThread.start();
            }
        } catch (Exception e) {
        }
    }
}