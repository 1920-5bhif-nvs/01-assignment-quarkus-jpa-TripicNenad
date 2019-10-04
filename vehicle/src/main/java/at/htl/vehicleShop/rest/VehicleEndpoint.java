package at.htl.vehicleShop.rest;

import at.htl.vehicleShop.model.Vehicle;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

@Path("vehicle")
public class VehicleEndpoint {
    @Inject
    EntityManager em;

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Transactional
    public Response findAll(){
      //  return Response.ok(em.createNamedQuery("Vehicle.findAll"), Vehicle.class).getResultList()).build();
        return null;
    }
}
