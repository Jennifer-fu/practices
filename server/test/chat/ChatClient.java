package chat;

import server.chat.IChatClient;

import java.rmi.RemoteException;

public class ChatClient implements IChatClient {
    private String name;
    private String message;

    public ChatClient(String name) {
        this.name = name;
    }

    public String getClientName() throws RemoteException {
        return name;
    }

    public void sendMessage(String message) throws RemoteException {
        this.message = message;
    }

    public String getMessage() throws RemoteException {
        return message;
    }
}
