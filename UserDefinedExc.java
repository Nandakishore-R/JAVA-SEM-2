import java.util.Scanner;
class MyEx extends Exception{
    public void disp()
    {
        System.out.println("Division by 0");
    }
}
public class UserDefinedExc {
    public static void main(String[] args) {
        int a,b,c;
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter 2 nos");
            a = s.nextInt();
            b=s.nextInt();
            if (b==0) {
                throw new MyEx();
            }
            c = a/b;
            System.out.println(c);
        } catch (MyEx m) {
            m.disp();
        }
    }    
}
