package main;

import entity.GitRepo;
import facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args){
        Facade f = new Facade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        f.addEntityManagerFactory(emf);
        //return all Pet's
        f.add(new GitRepo("Hallur","við Neyst"));
        f.add(new GitRepo("Hans","Hans Peter"));
        f.add(new GitRepo("Røv","Røv og nøgler"));
    }
}