import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import javax.swing.event.*;
class CL extends JFrame implements ActionListener{
    JTextField t;
    JButton b[] = new JButton[10];
    JButton bp,bm,be;
    JPanel p;
    int op1,op;
    public CL(){
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        t = new JTextField(10);
        t.setMaximumSize(getMaximumSize());
        add(t, BorderLayout.NORTH);
        for(int i=0;i<10;i++){
            String s = Integer.toString(i);
            b[i] = new JButton(s);
        }
        bp= new JButton("+");
        bm= new JButton("-");
        be= new JButton("=");

        p = new JPanel();
        p.setLayout(new GridLayout(4,4));
        // Container c = this.getContentPane();
        // c.setLayout(new GridLayout(3,1));
        // c.add(t);
        
        for(int i=0;i<10;i++){
            p.add(b[i]);
        }
        p.add(bp);
        p.add(bm);
        p.add(be);
        // c.add(p);
        for(int i=0;i<10;i++){
            b[i].addActionListener(this);
        }
        bp.addActionListener(this);
        bm.addActionListener(this);
        be.addActionListener(this);
        add(p,BorderLayout.CENTER);
        setSize(getPreferredSize());
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String str="";
        str = t.getText();
        if(ae.getSource() == bp){
            op1 = Integer.parseInt(str);
            t.setText("");
            op=1;
        }
        else if(ae.getSource() == bm){
            op1 = Integer.parseInt(str);
            t.setText("");
            op=2;
        }
        else if(ae.getSource() == be){
            int op2 = Integer.parseInt(str);
            int res;
            res  = (op==1) ? op1 + op2 :op1 - op2;
            t.setText(""+res);
        }
        else{
            t.setText(str+ae.getActionCommand());
        }
    }
  

}
public class Calculator {
    public static void main(String[] args) {
        new CL();
    }
}