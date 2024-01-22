import java.io.*;
class person{
    int age;
    String name;
    public void setPerson(int a,String n)
    {
        age=a;
        name=n;
    }
    public void dispPerson()
    {
        System.out.println("Name:"+name+ " Age:"+age);
    }
}
public class clas{
    public static void main(String args[]){
        person p,q;
        p=new person();
        q=new person();
        p.setPerson(20,"abcd");
        q.setPerson(30,"xyz");
        p.dispPerson();
        q.dispPerson();
    }
}