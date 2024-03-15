import java.io.*;

public class DirectoryDisp {
    public static void main(String[] args) {
        try {
            File f = new File("D:\\Series");
            String p = "D:\\Series";
            String s="";
            dispDirectory(f,p,s);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void dispDirectory(File f,String p,String s){
        String l[];
        l = f.list();
        for(int i=0;i<l.length;i++){
            File x = new File(p+"//"+l[i]);
            System.out.println(s+l[i]);
            if(x.isDirectory()){
                dispDirectory(x, p+"\\"+l[i],s+"\t");
            }
        }
    }
}