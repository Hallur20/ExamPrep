/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontrol;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author Hallur
 */
public class Structure {
    public static void main(String[] args) {
        try{
        Persistence.generateSchema("pu", new HashMap());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
