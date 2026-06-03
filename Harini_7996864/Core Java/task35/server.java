import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5000);
            Socket s = ss.accept();

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msg = "";

            while (!msg.equals("exit")) {
                msg = in.readUTF();
                System.out.println("Client: " + msg);

                String reply = br.readLine();
                out.writeUTF(reply);
            }

            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}