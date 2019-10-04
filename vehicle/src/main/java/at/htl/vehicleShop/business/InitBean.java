package at.htl.vehicleShop.business;

import at.htl.vehicleShop.model.Vehicle;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    EntityManager em;

    @Transactional
    void init(@Observes StartupEvent ev){
        System.err.println("------init------");

        for(int i = 120; i < 830;i+=100 )
        {
            em.persist(new Vehicle("BMW",i+"D"));
        }

    }

}
