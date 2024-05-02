package Singleton;

class Server {
    private static Server instance;

    private Server() {
        System.out.println("new server instance!");
    }

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();

        }

        return instance;
    }
}

public class Singleton {
    public static void main(String[] args) {

        Server instance = Server.getInstance();
        System.out.println(instance);

        instance = Server.getInstance();
        System.out.println(instance);

        instance = Server.getInstance();

        System.out.println(instance);
    }
}
