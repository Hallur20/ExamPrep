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
public class Thread2 extends Thread{

    @Override
    public void run() {
       int i = 0;
       while(i < 5){
           i++;
           if(i == 5){
               System.out.println(i);
               break;
           }
           System.out.println(i);
           try {
               Thread.sleep(2000);
           } catch (InterruptedException ex) {
               Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
    }
    
}
