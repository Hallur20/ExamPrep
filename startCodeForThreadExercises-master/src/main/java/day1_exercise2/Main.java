/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1_exercise2;

/**
 *
 * @author Hallur
 */
public class Main {

    public static void main(String[] args) {
        Even even = new Even();
        Runnable r = ()
                -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()
                        + " " + even.next());
            }
        };

        Thread t1 = new Thread(r, "thread 1");
        Thread t2 = new Thread(r, "thread 2");
        t1.start();
        t2.start();
        
        /*
        Are you able to provoke the expected error on your machine?
        -> yes
         How often does the problem occur?
        might happen all the time, might happen only sometimes, it's really random.
        -> It happens when one thread interferes with the other thread while calling the method,
        making the other thread thinking that it has to add n 2 times again after already adding it once.
        Use the synchronization techniques you’ve learned today, to make next() method atomic with respect to itself.
        -> ok done. (atomic = no change can take place in the method once a thread has called it.)
        Argue that your solution is correct (argue, don’t prove)
        -> well it's correct because compared to before we now never see uneven numbers in the output window,
        no matter how often we try, because the method can only be used by one thread at a time.
        */

    }
}
