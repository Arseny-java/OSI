import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static void connection(int port) {
        String name;
        String answer;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection accepted");
            out.println("Привет, как тебя зовут?");
            name = in.readLine();
            out.println("Ты поддерживаешь идею интернациональной революции(Да/Нет)?");
            answer = in.readLine();
            while (true) {
                if (answer.equalsIgnoreCase("Да")) {
                    out.println("'Пролетарии всех стран, соединяйтесь!', " + name);
                    out.println(java.util.Optional.empty());
                    break;
                } else if (answer.equalsIgnoreCase("Нет")) {
                    out.println("'За Веру, Царя и Отечество!', " + name);
                    out.println(java.util.Optional.empty());
                    break;
                } else while (clientSocket.isConnected()) {
                    out.println("Русским по белому спросили 'Да или нет', " + name);
                    answer = in.readLine();
                    if (answer.equalsIgnoreCase("Да")) {
                        out.println("'Пролетарии всех стран, соединяйтесь!', " + name);
                        out.println(java.util.Optional.empty());
                        break;
                    } else if (answer.equalsIgnoreCase("Нет")) {
                        out.println("'За Веру, Царя и Отечество!', " + name);
                        out.println(java.util.Optional.empty());
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
