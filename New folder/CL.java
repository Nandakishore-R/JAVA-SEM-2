import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class CL {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        DatagramPacket dp = null, reply = null;
        try {
            ds = new DatagramSocket();
            InetAddress ip = InetAddress.getByName("localhost");
            dp = new DatagramPacket("Bye".getBytes(), "Bye".length(),ip,1234);
            ds.send(dp);
            byte [] buffer = new byte[1000];
            reply = new DatagramPacket(buffer, buffer.length);
            ds.receive(reply);
            System.out.println(new String(reply.getData()).trim());

        } catch (Exception e) {
           
        }
        finally{
            if(ds!=null){
                ds.close();
            }
        }
    }
    
}