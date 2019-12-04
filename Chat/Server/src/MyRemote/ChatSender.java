package MyRemote;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class ChatSender extends UnicastRemoteObject implements ChatInterface  {

    public List<Message> messages = new ArrayList<Message>();

    public ChatSender() throws RemoteException {

    }

    public List<String> SendMessage(int id, String message) {
        Message m = new Message(id, message);
        messages.add(m);
        return GetStringChat();
    }

    public List<String> GetStringChat() {
        List<String> chat = new ArrayList<>();
        messages.forEach((message -> {
            chat.add(message.message);
        }));
        return chat;
    }

    public List<Message> GetChat() {
        return messages;
    }
//    public String Person(String a) throws Exception {
//        System.out.println("server used");
//        return a;
//    }
//
//    public void Chat(String b){
//        int id = 0;
//        String message;
//    }
}
