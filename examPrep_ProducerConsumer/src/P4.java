
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
public class P4 extends Thread{
Fibonacci f = new Fibonacci();

    @Override
    public void run() {
        while(!MainThread.s1.isEmpty()){
       
            
            Long fromFib =  f.fib(MainThread.s1.poll());
            System.out.println("generated fib num: " + fromFib);
            try {
                MainThread.s2.put(fromFib);
            } catch (InterruptedException ex) {
                Logger.getLogger(P1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
