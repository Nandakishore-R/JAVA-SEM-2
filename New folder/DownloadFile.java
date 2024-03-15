import java.net.*;
import java.io.*;
import java.util.Date;
public class DownloadFile{
    public static void main(String[] args) throws Exception{
        int c;
        URL u = new URL("https://img.freepik.com/free-photo/autumn-leaf-falling-revealing-intricate-leaf-vein-generated-by-ai_188544-9869.jpg?size=626&ext=jpg");
        URLConnection uc = u.openConnection();
        System.out.println("Date : "+new Date(uc.getDate()));
        System.out.println("Content type : "+uc.getContentType());
        int len = uc.getContentLength();
        System.out.println("Content length : "+len);
        String type[] = uc.getContentType().split("/");
        System.out.println(type[1]);
        if(len>0){
            FileOutputStream fout = new FileOutputStream("new1."+type[1]);
            InputStream in = uc.getInputStream();
            int i=0;
            while(((c=in.read()) != -1) && i<len){
                fout.write((char)c);
            }
        }
    }
}
