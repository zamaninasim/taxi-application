package ir.maktab.model;

import ir.maktab.enums.Color;
import ir.maktab.enums.TypeOfVehicle;

public class Vehicle {
    private int vehicleID;
    private TypeOfVehicle typeOfVehicle;
    private Color colorOfVehicle;
    private String plaqueOfVehicle;
    private String modelOfVehicle;

    public Vehicle(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public Vehicle(TypeOfVehicle typeOfVehicle, Color colorOfVehicle, String plaqueOfVehicle, String modelOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
        this.colorOfVehicle = colorOfVehicle;
        this.plaqueOfVehicle = plaqueOfVehicle;
        this.modelOfVehicle = modelOfVehicle;
    }

    public TypeOfVehicle getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public Color getColorOfVehicle() {
        return colorOfVehicle;
    }

    public void setColorOfVehicle(Color colorOfVehicle) {
        this.colorOfVehicle = colorOfVehicle;
    }

    public String getPlaqueOfVehicle() {
        return plaqueOfVehicle;
    }

    public void setPlaqueOfVehicle(String plaqueOfVehicle) {
        this.plaqueOfVehicle = plaqueOfVehicle;
    }

    public String getModelOfVehicle() {
        return modelOfVehicle;
    }

    public void setModelOfVehicle(String modelOfVehicle) {
        this.modelOfVehicle = modelOfVehicle;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }
}
