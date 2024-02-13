import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;
public class LoginClient{
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
               new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
               System.out.print("\033\143");
            }
        } catch (Exception ex) {}
    }

    public static int menu(){
        int ch = 3;
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("\n\n1 -> Login\n2 -> Register\n3 -> Quit\n");
            System.out.print("Enter your choice : ");
            ch = s.nextInt();
            s.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ch;
    }

    public static int loginMenu(){
        int ch = 3;
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("\n\n1 -> Change Password\n2 -> Logout");
            System.out.print("Enter your choice : ");
            ch = s.nextInt();
            s.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ch;
    }
    public static void main(String[] args) {
        String uname;
        String pass;
        String str;
        int ch,mch;
        Socket cs;
        DataInputStream sin;
        DataOutputStream sout;
        try {
            cs = new Socket("localhost",1234);
            sin = new DataInputStream(cs.getInputStream());
            sout = new DataOutputStream(cs.getOutputStream());
            Scanner s = new Scanner(System.in);
            for(ch = menu();ch!=3;ch=menu()){
                switch (ch) {
                    case 1:
                        System.out.print("Enter username : ");
                        uname = s.nextLine();
                        System.out.print("Enter password : ");
                        pass = s.nextLine();
                        str = "select * from login where username='"+uname+"' and password = '"+pass+"'";
                        sout.writeUTF("select");
                        sout.writeUTF(str);
                        if(sin.readBoolean()){
                            clearConsole();
                            System.out.println("Welcome "+uname);
                            for(mch = loginMenu();mch!=2;mch=loginMenu()){
                                switch (mch) {
                                    case 1:
                                    String pass2, passnew;
                                        System.out.print("Enter old password : ");
                                        pass = s.nextLine();
                                        System.out.print("Enter new password : ");
                                        passnew = s.nextLine();
                                        System.out.print("ReEnter new password : ");
                                        pass2 = s.nextLine();
                                        str = "select * from login where username='"+uname+"' and password = '"+pass+"'";
                                        sout.writeUTF("select");
                                        sout.writeUTF(str);
                                        if(sin.readBoolean()){
                                            if(passnew.equals(pass2))
                                            {
                                                str = "update login set password = '"+passnew+"' where username = '"+uname+"'";
                                                sout.writeUTF("insert");
                                                sout.writeUTF(str);
                                                System.out.println("Password successfully changed");
                                            }
                                            else{
                                                System.out.println("Password mismatch!");
                                            }
                                        }
                                        else{
                                            System.out.println("Wrong password!");
                                        }
                                    }

                            }
                        }
                        else
                        System.out.println("Wrong Details!!");
                        break;
                    case 2:
                        clearConsole();
                        System.out.print("Enter username : ");
                        uname = s.nextLine();
                        System.out.print("Enter password : ");
                        pass = s.nextLine();
                        str = "insert into login values('"+uname+"', '"+pass+"')";
                        sout.writeUTF("insert");
                        sout.writeUTF(str);
                        System.out.println("User Succesfully registered");
                        break;
                    default:
                        break;
                }
            }
            sout.writeUTF("quit");
            cs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
