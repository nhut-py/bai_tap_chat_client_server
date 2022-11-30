package chat_client;

import java.io.*;
import java.net.*;
public class client2 implements Runnable {
    private Socket socket;
    private BufferedReader input;
    // private PrintWriter output;
    public client2(Socket s) throws IOException {
        this.socket = s;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    @Override
    public void run() {
        try {
            while (true) {
                String response = input.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
