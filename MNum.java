import java.io.*;

class Num {
    int num;

    public void read() {
        DataInputStream in = new DataInputStream(System.in);
        try {
            System.out.println("Enter your number : ");
            num = Integer.parseInt(in.readLine());
        } catch (Exception e) {
        }
    }

    public Num add(Num b) {
        Num t = new Num();
        t.num = num + b.num;
        return t;
    }

    public void disp() {
        System.out.println(num);
    }
}

public class MNum {
    public static void main(String args[]) {
        Num p, q, r;
        p = new Num();
        q = new Num();
        p.read();
        q.read();
        r = p.add(q);
        p.disp();
        q.disp();
        r.disp();
    }
}