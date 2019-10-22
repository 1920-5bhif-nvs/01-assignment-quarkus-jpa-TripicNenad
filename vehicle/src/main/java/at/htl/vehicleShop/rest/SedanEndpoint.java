package at.htl.vehicleShop.rest;

import at.htl.vehicleShop.model.Sedan;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("sedan")
public class SedanEndpoint {
    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findAll() {
        return Response.ok(em.createNamedQuery("Sedan.findAll", Sedan.class).getResultList()).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findById(@PathParam("id") long id) {
        Sedan r = em.find(Sedan.class, id);
        if (r != null) {
            return Response.ok(r).build();
        } else
            return Response.noContent().build();
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteById(@PathParam("id") long id) {
        try {
            Sedan r = em.find(Sedan.class, id);
            em.remove(r);
        } catch (Exception e) {
            return Response.status(404).build();
        }
        return Response.ok().build();
    }
}
