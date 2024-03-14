import java.io.*;

class Serial {
    public static void main(String[] args) throws Exception{
        StudentCs s1 = new StudentCs(100, "abcd");
        FileOutputStream fout = new FileOutputStream("f.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(s1);
        out.flush();
        System.out.println("Success");
    }
}
