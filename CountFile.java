import java.io.FileInputStream;
import java.util.Scanner;

public class CountFile{
    public static void main(String[] args) {
        FileInputStream fin;
        Scanner s = new Scanner(System.in);
        String fname;
        int charcount=0;
        int linecount = 1;
        int wordcount = 1;
        try{
            System.out.println("Enter file name : ");
            fname = s.nextLine();
            s.close();
            fin = new FileInputStream(fname);
            int ch = fin.read();
            while(ch!=-1){
                char c = (char)ch;
                if(c =='\n'){
                    linecount++;
                    wordcount++;
                }
                else if(ch == 13){
                    ch=fin.read();
                    continue;
                }
                else{
                    charcount++;
                    if(c == ' ' || c == '\t')
                    {
                        wordcount++;
                    }
                }
                ch=fin.read();
            }
            fin.close();
            System.out.println("\nNo of characters = " + charcount);
            System.out.println("No of lines = " + linecount);
            System.out.println("No of words = " + wordcount);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
