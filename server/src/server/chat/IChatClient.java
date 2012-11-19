package server.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatClient extends Remote {
    public String getClientName() throws RemoteException;

    public void sendMessage(String message) throws RemoteException;

}
