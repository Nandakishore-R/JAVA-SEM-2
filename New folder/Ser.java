import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Ser {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        DatagramPacket dp = null, reply = null;
        try {
            ds = new DatagramSocket(1234);
            byte [] buffer = new byte[1000];
            dp = new DatagramPacket(buffer, buffer.length);
            ds.receive(dp);
            System.out.println(new String(dp.getData()).trim());
            reply = new DatagramPacket("Hi".getBytes(), "Hi".length(),dp.getAddress(),dp.getPort());
            ds.send(reply);
           
           

        } catch (Exception e) {
           
        }
        finally{
            if(ds!=null){
                ds.close();
            }
        }
    }
}
