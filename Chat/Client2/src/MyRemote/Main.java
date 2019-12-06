package MyRemote;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    String a;
    String mastername;
    JFrame mainframe = new JFrame("Messenger");
    JPanel mainpanel = new JPanel(new BorderLayout());
    JPanel northpanel = new JPanel();
    JPanel centerpanel = new JPanel(new BorderLayout(8,8));
    JPanel southpanel = new JPanel(new BorderLayout(8,8));
    JPanel buttonlayout = new JPanel(new FlowLayout());
    JPanel centereast = new JPanel(new BorderLayout(8,8));
    JPanel setting = new JPanel(new GridLayout(5,2));
    JButton Send = new JButton("Send");
    JButton Reload = new JButton("Reload");
    JTextField Message = new JTextField();
    JTextArea Showmessage = new JTextArea("empty");
    JLabel Settings = new JLabel("Settings",JLabel.CENTER);
    JTextField yourname = new JTextField();
    JButton Submitname = new JButton("Submit");



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String a;
//        String b;
        String ip="//localhost/Chat";
        SwingUtilities.invokeLater(()-> new Main().Visiblity());


        while (true) {
            // get request from Client
            // /send/:name/:message
            // req.params : { name: '', message}
//            a="1";
//            b=scanner.nextLine();
//            a=a+b;

            String message = scanner.nextLine();


            try {
                ChatInterface chatInterface = (ChatInterface) Naming.lookup(ip);
                if (message != null && message.equals("reload")) {

                    System.out.println(chatInterface.GetStringChat());
                    //System.out.println("reloaded");

                } else System.out.println(chatInterface.SendMessage(1, message));
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


    JLabel name = new JLabel("Messenger",JLabel.CENTER);
    public void Visiblity(){
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);
        mainframe.setSize(800,600);
        mainframe.add(mainpanel);
        mainpanel.add(northpanel,BorderLayout.NORTH);
        mainpanel.add(centerpanel,BorderLayout.CENTER);
        mainpanel.add(southpanel,BorderLayout.SOUTH);
        northpanel.add(name);
        buttonlayout.add(Send);
        buttonlayout.add(Reload);
        southpanel.add(buttonlayout,BorderLayout.EAST);
        Message.setBorder( BorderFactory.createTitledBorder("Message here!"));
        southpanel.add(Message,BorderLayout.CENTER);
        centerpanel.add(centereast, BorderLayout.EAST);
        centereast.add(Settings,BorderLayout.NORTH);
        centerpanel.add(Showmessage,BorderLayout.CENTER);
        centereast.add(setting);
        yourname.setBorder(BorderFactory.createTitledBorder("yourname"));
        setting.add(yourname);
        setting.add(Submitname);

        Send.addActionListener(e-> getmessage());
        Reload.addActionListener(e->reloader());
        Submitname.addActionListener(e->namesetter());






    }
    public void getmessage(){
         this.a=Message.getText();
        try {
            ChatInterface chatInterface = (ChatInterface) Naming.lookup("//localhost/Chat");
            chatInterface.SendMessage(1,mastername+" : "+this.a+"\n");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Message.setText("");
        reloader();


    }
    public void reloader(){
        try {
            ChatInterface chatInterface = (ChatInterface) Naming.lookup("//localhost/Chat");
            Showmessage.setText(chatInterface.GetStringChat().toString());

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void namesetter(){
        this.mastername=yourname.getText();
        JOptionPane.showMessageDialog(mainframe, "Done!\n your name is : "+this.mastername);

    }
}
