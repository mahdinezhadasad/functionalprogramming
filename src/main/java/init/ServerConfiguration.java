package init;

import java.net.InetSocketAddress;

public class ServerConfiguration {

    private static init.ServerConfiguration serverConfigurationInstance;

    private final InetSocketAddress serverAddress;
    private final String greetingMessage;

    public ServerConfiguration(int port, String greetingMessage) {

        this.greetingMessage = greetingMessage;
        this.serverAddress = new InetSocketAddress("localhost", port);

        if(serverConfigurationInstance==null){

            serverConfigurationInstance = this;

        }

    }

    public static init.ServerConfiguration getInstance(){return serverConfigurationInstance;}

    public InetSocketAddress getServerAddress() {
        return this.serverAddress;
    }

    public String getGreetingMessage() {
        return this.greetingMessage;
    }

}