import java.io.*;
import java.net.*;

public class serveur {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Serveur démarré");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connecté : " + clientSocket.getInetAddress());

        DataInputStream inFromClient = new DataInputStream(clientSocket.getInputStream());
        
        DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = "Bonjour client !";
        outToClient.writeUTF(message);

        while (true) {
            String str = inFromClient.readUTF();
            System.out.println("Client : " + str);

            System.out.print("Réponse : ");
            String response = br.readLine();
            outToClient.writeUTF(response);
            outToClient.flush();
        }
    }
}

