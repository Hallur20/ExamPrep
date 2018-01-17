/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1_exercise1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hallur
 */
public class Thread3 extends Thread {

    private boolean stopThread;

    public Thread3() {
    }

    public boolean isStopThread() {
        return stopThread;
    }

    public void setStopThread(boolean stopThread) {
        this.stopThread = stopThread;
    }

    public Thread3(boolean get) {
        stopThread = get;
    }

    @Override
    public void run() {
        int start = 10;
        int sleepTimes = 0;
        while (stopThread == true) {

            System.out.println(start);
            start++;
            try {
              
                if (sleepTimes < 3) {
                      System.out.println("times slept: " + sleepTimes);
                    Thread.sleep(3000);
                    sleepTimes++;
                } else {
                    break;
                }

                
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
