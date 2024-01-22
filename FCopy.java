import java.util.*;
import java.io.*;
class FCopy {
    public static void main(String[] args) {
        FileInputStream fin;
        FileOutputStream fout;
        Scanner s=new Scanner(System.in);
        String f1,f2;
        try{
            System.out.println("Enter the source file");
            f1=s.nextLine();
            System.out.println("Enter the destination file");
            f2=s.nextLine();
            fin=new FileInputStream(f1);
            fout=new FileOutputStream(f2);
            byte b[];
            b=new byte[5];
            int n=fin.read(b,0,5);
            while(n!=-1){
                fout.write(b,0,n);
                n=fin.read(b,0,5);
            }
            fin.close();
            fout.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
