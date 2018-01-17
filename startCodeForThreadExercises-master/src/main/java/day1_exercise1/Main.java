/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1_exercise1;

/**
 *
 * @author Hallur
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        boolean stopT3 = true;
        Thread3 t3 = new Thread3(stopT3);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(10000);
        System.out.println("10 seconds have passed");
        t3.setStopThread(false);
    }
}
/* 
a) Do you observe a need for synchronization techniques on any of the threads in practise, or does your program work by accident?
-> no i dont because no threads share the same data, and because of that it does not just work by accident.
b) Regardless of whether you observe the problem on your machine, we need to handle it.
What is the problem I’m hinting at, and how can we solve it? (Since I’m such a nice guy, here’s a hint: think about the VolatileExample class from the demo).
-> ??
c) argue that your solution is correct (argue, don’t prove)
-> i would argue that my solution is correct because the output corresponds with what the assignment asked for
*/
