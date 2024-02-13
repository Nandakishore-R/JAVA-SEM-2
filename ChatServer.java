import java.io.*;
import java.net.*;
import java.util.*;

class ChatServer {
    public static void main(String[] args) {
        ServerSocket ss;
        Socket as;
        DataInputStream sin;
        DataOutputStream sout;
        Scanner s;
        try {
            ss = new ServerSocket(1234);
            as = ss.accept();
            sin = new DataInputStream(as.getInputStream());
            sout = new DataOutputStream(as.getOutputStream());
            s = new Scanner(System.in);
            System.out.println("Enter text to send : ");
            String str = s.nextLine();
            sout.writeUTF(str);
            while(!str.equals("quit")){
                str = sin.readUTF();
                if(str.equals("quit")){
                    ss.close();
                    System.out.println("Client has closed the connection!");
                    break;
                }
                System.out.println("Client :"+str);
                System.out.println("Enter text to send : ");
                str = s.nextLine();
                sout.writeUTF(str);
            } 
        } catch (Exception e) {}
    }
}
