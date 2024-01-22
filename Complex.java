import java.io.*;
class Com{
    float r;
    float i;
    public void read()
    {
        DataInputStream din=new DataInputStream(System.in);
        try{
            System.out.println("Enter the value of r:");
            r=Float.parseFloat(din.readLine());
            System.out.println("Enter the value of i:");
            i=Float.parseFloat(din.readLine());
        }
        catch(Exception e)
        {
            System.out.println("Error :"+e);
        }
    }
    public void disp()
    {
        System.out.println("r= "+r+" i= "+i);
    }
    public Com add(Com q)
    {
        Com t=new Com();
        t.r=r+q.r;
        t.i=i+q.i;
        return t;
    }
    public Com mult(Com q)
    {
        Com t=new Com();
        t.r=r*q.r-i*q.i;
        t.i=r*q.i-i*q.r;
        return t;
    }
}
class Complex
{
    public static void main(String args[]){
        Com p,q,r;
        p=new Com();
        q=new Com();
        p.read();
        q.read();
        System.out.println("Displaying");
        p.disp();
        q.disp();
        System.out.println("Adding");
        r=p.add(q);
        r.disp();
        System.out.println("Multipling");
        r=p.mult(q);
        r.disp();
    }
}