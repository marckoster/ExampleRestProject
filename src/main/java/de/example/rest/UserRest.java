package de.example.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import de.example.dao.GenericDao;

@Path("/user")
public class UserRest
{
    @Inject
    GenericDao genericDao;

    //or use this MEDIATYPES.APPLICATION_JSON
   
    @GET
    @Path("/findAll")
    @Produces("application/json; charset=UTF-8")
    public Response findAll()
    {
       return Response.accepted("OK").build();
    }
    

}
