import java.io.*;
import java.net.*;
import java.sql.*;
public class LoginServer{
    public static void main(String[] args) {
        Connection con;
        Statement st;
        String str;
        ServerSocket ss;
        Socket as;
        DataInputStream sin;
        DataOutputStream sout;
        try {
            ss = new ServerSocket(1234);
            as = ss.accept();
            sin = new DataInputStream(as.getInputStream());
            sout = new DataOutputStream(as.getOutputStream());

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?characterEncoding=utf8", "root", "");
            st = con.createStatement();

            while(true){
                str = sin.readUTF();
                if(str.equals("insert")){
                    str = sin.readUTF();
                    System.out.println(str);
                    st.executeUpdate(str);
                }
                if(str.equals("select")){
                    str = sin.readUTF();
                    System.out.println(str);
                    ResultSet rs = st.executeQuery(str);
                    if(rs.next())
                        sout.writeBoolean(true);
                    else
                        sout.writeBoolean(false);
                }
                if(str.equals("quit")){
                    ss.close();
                    break;
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
