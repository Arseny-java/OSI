import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static void connection(int port) {

        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection accepted");

            final String result = String.format("Hi %s, your port is %d", in.readLine(), clientSocket.getPort());

            out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
