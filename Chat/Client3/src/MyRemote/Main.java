package MyRemote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String a;
//        String b;


        while (true) {
            // get request from Client
            // /send/:name/:message
            // req.params : { name: '', message}
//            a="1";
//            b=scanner.nextLine();
//            a=a+b;
            String message = scanner.nextLine();


            try {
                ChatInterface chatInterface = (ChatInterface) Naming.lookup("//192.168.1.103/usc");
                if (message != null && message.equals("")) {

                    System.out.println(chatInterface.GetStringChat());
                    //System.out.println("reloaded");

                } else System.out.println(chatInterface.SendMessage(2, message));
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }
}
