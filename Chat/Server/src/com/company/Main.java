package com.company;

import MyRemote.ChatInterface;
import MyRemote.ChatSender;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) {
        String ip="//localhost/Chat";
        try {
            LocateRegistry.createRegistry(1099);
            System.setProperty("java.rmi.server.hostname","192.168.1.110");
            ChatSender chatSender = new ChatSender();
            Naming.rebind("Chat",chatSender);
            System.out.println("server is ...");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
