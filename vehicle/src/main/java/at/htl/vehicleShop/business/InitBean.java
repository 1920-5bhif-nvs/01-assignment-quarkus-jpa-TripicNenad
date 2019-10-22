package at.htl.vehicleShop.business;

import at.htl.vehicleShop.model.Roadster;
import at.htl.vehicleShop.model.Sedan;
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
    void init(@Observes StartupEvent ev) {
        System.err.println("------init------");


        System.err.println("------ROADSTERS------");
        for (int i = 1; i <6 ; i++) {
            em.persist(new Roadster("BMW","Z"+i,i*120,250,2000));
        }

        System.err.println("------SEDANS------");
        for (int i = 120; i < 830; i += 100) {
            em.persist(new Sedan("BMW", i + "D",5,i));
        }

    }

}
