package server.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatService extends Remote {

    public void addClient(IChatClient client) throws RemoteException;

    public void removeClient(IChatClient client) throws RemoteException;

    public void broadcastMessage(IChatClient client, String message) throws RemoteException;
}
