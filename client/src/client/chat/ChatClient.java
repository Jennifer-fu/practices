package client.chat;

import server.chat.IChatClient;
import server.chat.IChatService;

import java.awt.*;
import java.rmi.RemoteException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ChatClient extends JFrame implements ActionListener, IChatClient {
    TextField servername, serverport, username;
    Button connect, disconnect;
    TextField message;
    Button send;
    TextArea fromserver;
    boolean connected = false;
    String title = "";
    String name = "";
    IChatService service;

    public ChatClient(String name) {
        super(name);
        setBounds(50, 20, 400, 450);
        setLayout(new FlowLayout(FlowLayout.CENTER, 25, 10));
        title = name;
        setStatus();
        add(new Label("Chat Server Name : "));
        servername = new TextField(20);
        servername.setEnabled(false);
        add(servername);
        servername.setText("localhost");
        add(new Label("Chat Server Port   :  "));
        serverport = new TextField(20);
        serverport.setEnabled(false);
        add(serverport);
        serverport.setText("1099");
        add(new Label("Your User Name : "));
        username = new TextField(20);
        add(username);
        username.setText("");
        connect = new Button("Connect");
        connect.addActionListener(this);
        add(connect);
        disconnect = new Button("Disconnect");
        disconnect.addActionListener(this);
        add(disconnect);
        message = new TextField(30);
        add(message);
        send = new Button("Send");
        send.addActionListener(this);
        add(send);
        fromserver = new TextArea(10, 35);
        add(fromserver);
        fromserver.setEditable(false);
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        new ChatClient("test");
    }

    private void connect() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            service = (IChatService) registry.lookup("chat");
            connected = true;
            setStatus();
            name = username.getText().trim();
            service.addClient(this);
        } catch (Exception e) {
            fromserver.append("Error Connecting ...\n");
            connected = false;
            setStatus();
            service = null;
            System.out.println(e);
        }
    }

    private void disconnect() {
        try {
            if (service == null)
                return;
            service.removeClient(this);
            service = null;
        } catch (Exception e) {
            fromserver.append("Error Connecting ...\n");
        } finally {
            connected = false;
            setStatus();
        }
    }

    private void setStatus() {
        if (connected)
            setTitle(title + " : Connected");
        else
            setTitle(title + " : Not Connected");
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == connect) {
            connect();
            if (connected) {
                username.setEnabled(false);
                connect.setEnabled(false);
            }
        } else if (actionEvent.getSource() == disconnect) {
            disconnect();
            servername.setEnabled(true);
            serverport.setEnabled(true);
            username.setEnabled(true);
            connect.setEnabled(true);
        } else if (actionEvent.getSource() == send) {
            if (service == null)
                return;
            try {
                service.broadcastMessage(this, message.getText());
                message.setText("");
            } catch (RemoteException exp) {
                System.out.println(exp);
                fromserver.append("Error Sending Message ...\n");
            }
        }
    }

    public String getClientName() throws RemoteException {
        return name;
    }

    public void sendMessage(String message) throws RemoteException {
        fromserver.append(message + "\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatClient that = (ChatClient) o;

        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
