package at.htl.vehicleShop.rest;

import at.htl.vehicleShop.model.Vehicle;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("vehicle")
public class VehicleEndpoint {
    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findAll(){
      return Response.ok(em.createNamedQuery("Vehicle.findAll",Vehicle.class).getResultList()).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findById(@PathParam("id") long id){
        Vehicle v = em.find(Vehicle.class, id);
        if (v != null){
            return Response.ok(v).build();
        }
        else
            return Response.noContent().build();
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteById(@PathParam("id") long id){
        try{
            Vehicle v = em.find(Vehicle.class, id);
            em.remove(v);
        }
        catch (Exception e){
            return Response.status(404).build();
        }
        return Response.ok().build();
    }

}
