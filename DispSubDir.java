import java.io.*;
class DispSubDir {
    public static void main(String[] args) {
        File f;
        String s[];
        int i;
        try{
            f=new File("d:\\java\\");
            s=f.list();
            for(i=0;i<s.length;i++){
                File ff=new File("d:\\java\\"+s[i]);
                if(ff.isDirectory()){
                    System.out.println(s[i]);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
