class Count extends Thread{
    int st;
    public Count(int a){
        this.st = a;
    }
    public void run(){
        for(int i=st;i<=100;i=i+2){
            System.out.println(i);
        }
    }
}
public class ThreadEx {
    public static void main(String[] args) {
        try {
            Count t1 = new Count(1);
            Count t2 = new Count(2);
            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Main Thread Exiting...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
