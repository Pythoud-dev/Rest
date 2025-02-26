package Serveur;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class Serveur {
	public static void main(String[] args) throws IOException {
		  int serverPort = 8000;
		  HttpServer server = HttpServer.create(
		    new InetSocketAddress(serverPort), 0
		  );
		  server.createContext("/api/hello", (exchange -> {
		    String respText = "Hello!";
		    exchange.sendResponseHeaders(200, respText.getBytes().length);
		    OutputStream output = exchange.getResponseBody();
		    output.write(respText.getBytes());
		    output.flush();
		    exchange.close();
		  }));
		  server.setExecutor(null);
		  server.start();
		}

}
