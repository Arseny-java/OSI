import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String message;
        Socket socket = new Socket("netology.homework", Main.port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner scanner = new Scanner(System.in);

        System.out.println(in.readLine());
        message = scanner.nextLine();
        out.println(message);
        System.out.println(in.readLine());
        message = scanner.nextLine();
        out.println(message);

        while (socket.isConnected()) {
            System.out.println(in.readLine());
            message = scanner.nextLine();
            out.println(message);
        }
    }
}


