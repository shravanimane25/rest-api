
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.OutputStream;

public class HelloAPI {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8081), 0);

        server.createContext("/hello", exchange -> {

            String response = "Hello! REST API is working";

            exchange.sendResponseHeaders(200,
                response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();

        System.out.println("REST API running on port 8081");
    }
}
