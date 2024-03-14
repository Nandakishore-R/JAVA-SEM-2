import java.io.FileInputStream;
import java.io.ObjectInputStream;

class DSerial {
 public static void main(String[] args) throws Exception {
    FileInputStream fin = new FileInputStream("f.txt");
    ObjectInputStream in = new ObjectInputStream(fin);
    StudentCs s1 = (StudentCs)in.readObject();
    s1.disp();
 }   
}
