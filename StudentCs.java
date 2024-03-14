import java.io.Serializable;

public class StudentCs implements Serializable{
    private transient int id;
    private String name;
    public StudentCs(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void disp(){
        System.out.println(id+" "+name);
    }
}

