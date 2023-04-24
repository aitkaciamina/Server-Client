import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 8080);
        System.out.println("Connecté au serveur");

        DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = inFromServer.readUTF();
        System.out.println("Serveur : " + message);

        while (true) {
            System.out.print("Message : ");
            String str = br.readLine();
            outToServer.writeUTF(str);
            outToServer.flush();

            String response = inFromServer.readUTF();
            System.out.println("Serveur : " + response);
        }
    }
}

