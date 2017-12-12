import ua.nure.zabara.server.RoomService;

import javax.xml.ws.Endpoint;
import java.util.Scanner;

public class MainDemo {
    public static final RoomService implementor = new RoomService();
    public static final String address = "http://localhost:9000/RoomService";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Server");
        System.out.println(implementor);
        Endpoint endpoint = Endpoint.publish(address, implementor);

        System.out.println("Server ready... at " + address);

        System.err.println("Press <enter> to stop service... ");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        sc.close();
        System.out.println("Server exit");
        endpoint.stop();
    }
}
