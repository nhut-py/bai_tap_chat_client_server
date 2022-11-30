package chat_client;
import java.io.*;
import java.net.*;
import java.util.*;

public class client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)){
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            // trả lại giá trị đầu ra cho máy chủ: gias trị true là xóa bộ đệm nếu không
            // chúng ta phải làm thủ công
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            Scanner scanner = new Scanner(System.in);
            String userInput;
            String response;
            String clientName = "";
            client2 clientRun = new client2(socket);
            new Thread(clientRun).start();        
           while(true) {             
               if (clientName.equals("")) {
                    System.out.println("Tên của bạn ");
                    userInput = scanner.nextLine();
                    clientName = userInput;
                    output.println(userInput);
                    if (userInput.equals("thoat")) {
                        break;
                    }
               } 
               else {
                    String message = ( "(" + clientName + ")" + " : " );
                    System.out.println(message);
                    userInput = scanner.nextLine();
                    output.println(message + " " + userInput);
                    if (userInput.equals("thoat")) {
                        break;
                    }
                }
           }
//           } while (!userInput.equals("thoat"));
        } catch (Exception e) {
    }
    }
}