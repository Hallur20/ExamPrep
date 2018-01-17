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
public class Thread1 extends Thread {

    @Override
    public void run() {
        int i = 0;
        while(i < 1000000L){
            i++;
        }
        System.out.println(i);
    }
}
