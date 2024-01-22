import java.io.*;
import java.util.Scanner;

public class CountFile2{
    public static void main(String[] args) {
        FileReader fr;
        BufferedReader br;
        Scanner s = new Scanner(System.in);
        String fname;
        int charcount=0;
        int linecount = 0;
        int wordcount = 0;
        try{
            System.out.println("Enter file name : ");
            fname = s.nextLine();
            s.close();
            fr = new FileReader(new File(fname));
            br = new BufferedReader(fr);
            String data = br.readLine();
            while(data!=null){
                linecount++;
                charcount+= data.length();
                String [] words = data.split("\\s+");
                wordcount = wordcount + words.length;

                data=br.readLine();
            }
            br.close();
            System.out.println("\nNo of characters = " + charcount);
            System.out.println("No of lines = " + linecount);
            System.out.println("No of words = " + wordcount);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
