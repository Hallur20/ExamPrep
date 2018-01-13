/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.Event;
import entity.Pet;
import entityhelper.EventHelper;
import entityhelper.PetHelper;
import facade.Facade;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hvn15
 */
@Path("data")
public class GenericResource {

    @Context
    private UriInfo context;
    Facade f = new Facade();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private Gson gson;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        f.addEntityManagerFactory(emf);
        gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("allPets")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPets() {
        //TODO return proper representation object
        List<Pet> pets = f.getAllPets();
        List<PetHelper> fixedPets = new ArrayList();
        for (int i = 0; i < pets.size(); i++) {
            fixedPets.add(new PetHelper(
                    pets.get(i).getId(),
                    pets.get(i).getName(),
                    pets.get(i).getBirth(),
                    pets.get(i).getSpecies(),
                    pets.get(i).getOwnerId().getFirstName(),
                    pets.get(i).getOwnerId().getLastName()
            ));
        }
        return gson.toJson(fixedPets);
    }

    @GET
    @Path("alivePets")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAlivePets() {
        List<Pet> pets = f.getAlivePets();
        List<PetHelper> fixedPets = new ArrayList();
        for (int i = 0; i < pets.size(); i++) {
            fixedPets.add(new PetHelper(
                    pets.get(i).getId()
            ));
        }
        return gson.toJson(fixedPets);
    }

    @GET
    @Path("event/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEventPets(@PathParam("day") String day) throws ParseException {

        List<Pet> pets = f.getEventByDayPet(day);
        List<PetHelper> fixedPets = new ArrayList();
        for (int i = 0; i < pets.size(); i++) {
            fixedPets.add(new PetHelper(
                    pets.get(i).getId()
            ));
        }
        return gson.toJson(fixedPets);
    }
}
