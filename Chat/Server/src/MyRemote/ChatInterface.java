package MyRemote;

import javax.swing.event.ListDataEvent;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

public interface ChatInterface extends Remote {
    List <Message> messages = new ArrayList<Message>();
    List <String> SendMessage(int id, String message) throws Exception;
    List <String> GetStringChat() throws Exception;
    List <Message> GetChat() throws Exception;
//    String Person (String a ) throws Exception;
//     void Chat(String b) throws Exception;
}

