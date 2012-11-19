package chat;

import org.junit.BeforeClass;
import org.junit.Test;
import server.chat.ChatService;
import server.chat.IChatClient;
import server.chat.IChatService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import static junit.framework.Assert.assertEquals;

public class ChatServiceTest {

    static Registry registry;

    @BeforeClass
    public static void startService(){
        try {
            IChatService chatService = new ChatService();
            registry = LocateRegistry.getRegistry();
            IChatService stub = (IChatService) UnicastRemoteObject.exportObject(chatService, 0);
            registry.rebind("chat", stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_send_message_to_client(){
        try {
            IChatService service = (IChatService) registry.lookup("chat");
            IChatClient client = new ChatClient("test");
            service.broadcastMessage(client, "hi");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
