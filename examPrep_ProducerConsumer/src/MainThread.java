
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hvn15
 */
public class MainThread{

    public static BlockingQueue<Long> s1 = new ArrayBlockingQueue(11);
    public static BlockingQueue<Long> s2 = new ArrayBlockingQueue(11);

    public BlockingQueue getQueue() {
        return s1;
    }

    public static void main(String[] args) throws InterruptedException {

        MainThread m = new MainThread();
        // main
        MainThread.s1.put(4L);
        MainThread.s1.put(5L);
        MainThread.s1.put(8L);
        MainThread.s1.put(12L);
        MainThread.s1.put(21L);
        MainThread.s1.put(22L);
        MainThread.s1.put(34L);
        MainThread.s1.put(35L);
        MainThread.s1.put(36L);
        MainThread.s1.put(37L);
        MainThread.s1.put(42L);
        int siz = MainThread.s1.size();
       
        
        P1 p1 = new P1();
        P2 p2 = new P2();
        P3 p3 = new P3();
        P4 p4 = new P4();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        
        p1.join();
        p2.join();
        p3.join();
        p4.join();
        
        System.out.println("Final result = " + s2.toString());

//main
    }
}
