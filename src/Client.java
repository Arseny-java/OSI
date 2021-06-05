import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", Main.port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner scanner = new Scanner(System.in);
        String message;

        while (true) {
            System.out.println("Как вас зовут?: " + "(для выхода введите 'end')");
            message = scanner.nextLine();
            if (message.equalsIgnoreCase("End")) break;
            out.println(message);
            System.out.println("Server echo: " + in.readLine());
        }
    }
}

