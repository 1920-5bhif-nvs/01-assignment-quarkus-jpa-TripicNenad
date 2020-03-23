package at.htl.vehicleShop.rest;

import at.htl.vehicleShop.model.Shop;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@Path("shop")
public class ShopEndpoint {
    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/fetchType/{id}")
    public Response getShopWithFetchType (@PathParam("id") long id){
        return Response.ok(em.find(Shop.class,id)).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/entityGraph/{id}")
    public Response getShopWithEntityGraph (@PathParam("id") long id){
        EntityGraph entityGraph = em.getEntityGraph("vehicles-entity-graph");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);
        return Response.ok(em.find(Shop.class,id,properties)).build();
    }
}
