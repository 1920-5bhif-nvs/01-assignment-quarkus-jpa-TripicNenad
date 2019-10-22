package at.htl.vehicleShop.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Sedan.findAll",query = "select s from Sedan s")
public class Sedan extends Vehicle {

    private int maxNumOfPassengers;
    private int horsepower;

    //region Constructor
    public Sedan() {
    }

    public Sedan(String manufacturer, String modelName, int maxNumOfPassengers, int horsepower) {
        super(manufacturer, modelName);
        this.maxNumOfPassengers = maxNumOfPassengers;
        this.horsepower = horsepower;
    }
    //endregion

    //region Getter and Setter
    public int getMaxNumOfPassengers() {
        return maxNumOfPassengers;
    }

    public void setMaxNumOfPassengers(int maxNumOfPassengers) {
        this.maxNumOfPassengers = maxNumOfPassengers;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    //endregion


}
