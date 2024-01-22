import java.io.*;
import java.util.*;

public class FTwoCopy {
    public static void main(String[] args) {
        FileReader fr;
        BufferedReader br;
        FileWriter fwr;
        BufferedWriter bwr;
        Scanner s = new Scanner(System.in);
        String f1,f2,f3;
        try{
            System.out.println("Enter first file name : ");
            f1 = s.nextLine();
            System.out.println("Enter second file name : ");
            f2 = s.nextLine();
            System.out.println("Enter destination file name : ");
            f3 = s.nextLine();
            fr = new FileReader(new File(f1));
            br = new BufferedReader(fr);
            fwr = new FileWriter(new File(f3));
            bwr = new BufferedWriter(fwr);
            String data = br.readLine();
            while(data!=null){
                bwr.write(data);
                bwr.newLine();
                data=br.readLine();
            }
            fr = new FileReader(new File(f2));
            br = new BufferedReader(fr);
            data = br.readLine();
            while(data!=null){
                bwr.write(data);
                bwr.newLine();
                data=br.readLine();
            }
            br.close();
            bwr.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}