package at.htl.vehicleShop.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(
        name = "vehicles-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("vehicles")
        }
)

@Entity
@NamedQuery(name = "Shop.findAll",query = "select s from Shop s")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private String location;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Vehicle> vehicles = new ArrayList<>();

    //region Constructors
    public Shop() {
    }

    public Shop(String name, String location, List<Vehicle> vehicles) {
        this.name = name;
        this.location = location;
        this.vehicles = vehicles;
    }
    //endregion

    //region Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    //endregion
}
