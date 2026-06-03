import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 5000);

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msg = "";

            while (!msg.equals("exit")) {
                String send = br.readLine();
                out.writeUTF(send);

                msg = in.readUTF();
                System.out.println("Server: " + msg);
            }

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}