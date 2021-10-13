package ir.maktab.Trip;

import ir.maktab.model.Driver;
import ir.maktab.model.Passenger;

public class Trips {
    private int ID;
    private Driver driver;
    private Passenger passenger;
    private Location origin;
    private Location destination;
    private double price;

    public Trips(Driver driver, Passenger passenger, Location origin, Location destination, double price) {
        this.driver = driver;
        this.passenger = passenger;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
