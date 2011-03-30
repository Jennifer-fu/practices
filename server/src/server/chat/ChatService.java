package server.chat;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class ChatService implements IChatService {
    private Vector<IChatClient> clients;

    public ChatService() {
        clients = new Vector<IChatClient>();
    }

    public void addClient(IChatClient client) throws RemoteException {
        if (!clients.contains(client)) {
            clients.addElement(client);
            sendMessage(client.getClientName() + " added");
        }
    }

    public void removeClient(IChatClient client) throws RemoteException {
        if (clients.contains(client)) {
            sendMessage(client.getClientName() + " leave");
            clients.removeElement(client);
        }
    }

    public void broadcastMessage(IChatClient client, String message) throws RemoteException {
        sendMessage(client.getClientName() + ": " + message);
    }

    private void sendMessage(String message) throws RemoteException {
        for (IChatClient everyClient : clients) {
            everyClient.sendMessage(message);
        }
    }

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        IChatService chatService = new ChatService();
        Registry registry = LocateRegistry.getRegistry();
        IChatService stub = (IChatService) UnicastRemoteObject.exportObject(chatService, 0);
        registry.bind("chat", stub);
        System.out.println("Service Started");
    }
}
