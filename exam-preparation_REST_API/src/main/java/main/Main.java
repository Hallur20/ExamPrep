/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Event;
import entity.Pet;
import facade.Facade;
import java.text.ParseException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hvn15
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Facade f = new Facade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        f.addEntityManagerFactory(emf);
        //return all Pet's
        System.out.println(f.getAllPets());
        //total Number of pets formatted like: {"petCount":4}
        System.out.println("{\"petCount\":" + f.getAllPets().size() + "}");
        //alive pets
        System.out.println(f.getAlivePets());
        //given day event
        System.out.println(f.getEventByDayPet("2015-07-07"));

        //create event for existing pet
        f.createEvent("something", "something something", "2011-02-02", new Pet(2));
    }
}
