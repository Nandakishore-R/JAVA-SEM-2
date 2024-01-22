import java.io.*;
public class MinNum
{
    public static void main(String args[])
    {
        try
        {
            System.out.println("Enter a: ");
            DataInputStream in = new DataInputStream(System.in);
            int a = Integer.parseInt(in.readLine());
            System.out.println("Enter b: ");
            int b=Integer.parseInt(in.readLine());
            System.out.println("Enter c: ");
            int c=Integer.parseInt(in.readLine());
            int min = a < b ? (a < c ? a : c ) : (b < c ? b : c); 
            System.out.println("Min number is: "+min);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}