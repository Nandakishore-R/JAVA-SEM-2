import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class Conn{
    Connection con;
    PreparedStatement stmt;
    public Conn(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "password");
            System.out.println(1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public boolean validate(String u,String p){
        try{
            // stmt =con.prepareStatement("select * from usernew where username = ? and password = ?");
            // System.out.println(stmt.toString());
            // stmt.setString(1, u);
            // stmt.setString(2, p);
            Statement st = con.createStatement();
            String str = "select * from usernew where username = '"+u+"' and password = '"+p+"'";
            ResultSet rs = st.executeQuery(str);
            System.out.println(str);
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
             System.out.println(e);
        }
        return true;
    }
}
class LoginScreen extends JFrame implements ActionListener {
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;
    JPanel inputPanel;

    public LoginScreen() {
        setTitle("Login Screen");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for text fields and button
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 1));

        // Username field
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Username: "));
        username = new JTextField(20);
        usernamePanel.add(username);
        inputPanel.add(usernamePanel);

        // Password field
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password: "));
        password = new JPasswordField(20);
        passwordPanel.add(password);
        inputPanel.add(passwordPanel);

        // Login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        inputPanel.add(loginButton);

        add(inputPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            System.out.println(0);
            String uname = username.getText();
            char[] pass = password.getPassword();
            Conn c = new Conn();
            boolean b = c.validate(uname, new String(pass));
            if(b){
                inputPanel.removeAll();
                JLabel n = new JLabel("LOGIN SUCCESS");
                System.out.println("LOGIN SUCCESS");
                inputPanel.repaint();
                inputPanel.add(n);
                inputPanel.revalidate();
                inputPanel.repaint();
                
            }
            else{
                System.out.println("login failed");
            }
            inputPanel.setVisible(true);
            // You can add your login authentication logic here
           
            // For example, you can check the username and password against a database
        }
    }
}

public class Login{
    public static void main(String[] args) {
        new LoginScreen();
    }
}
