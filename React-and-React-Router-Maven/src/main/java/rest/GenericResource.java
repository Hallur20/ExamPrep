/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.GitRepo;
import facade.Facade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Hallur
 */
@Path("data")
public class GenericResource {
    
    @Context
    private UriInfo context;
    Facade f = new Facade();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private Gson gson;

    public GenericResource() {
        gson = new Gson();
        f.addEntityManagerFactory(emf);
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<GitRepo> list = f.getAll();
        return Response.status(Response.Status.CREATED).header("Access-Control-Allow-Origin", "*").entity(gson.toJson(list)).build();
    }
    
}
