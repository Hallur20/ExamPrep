package rest;

import com.google.gson.Gson;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import randomdata.Generator;

@Path("data")
public class ApiResource {

    @Context
    UriInfo context;
    Gson gson = new Gson();

    public ApiResource() {
    }

    @GET
    @Path("{amount}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("amount") int amount, @PathParam("id") int id) {
        Generator g = new Generator();
        return g.generate(amount, id);
    }

}
