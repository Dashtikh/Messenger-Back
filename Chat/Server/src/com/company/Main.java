package com.company;

import MyRemote.ChatInterface;
import MyRemote.ChatSender;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            System.setProperty("java.rmi.server.hostname","192.168.1.103");
            ChatSender chatSender = new ChatSender();
            Naming.rebind("usc",chatSender);
            System.out.println("server is ...");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
