package at.htl.vehicleShop.model;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Vehicle.findAll",query = "select v from Vehicle v")
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String manufacturer;
    private String modelName;

    //region Constructor
    public Vehicle() {
    }

    public Vehicle(String manufacturer, String modelName) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
    }
    //endregion
    //region Getter and Setter
    public Long getID() {
        return ID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    //endregion

}
