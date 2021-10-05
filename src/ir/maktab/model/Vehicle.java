package ir.maktab.model;

import ir.maktab.enums.Color;
import ir.maktab.enums.TypeOfVehicle;

public class Vehicle {
    private TypeOfVehicle typeOfVehicle;
    private Color color;
    private String plaque;
    private String model;

    public Vehicle() {
    }

    public Vehicle(TypeOfVehicle typeOfVehicle, Color color, String plaque, String model) {
        this.typeOfVehicle = typeOfVehicle;
        this.color = color;
        this.plaque = plaque;
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TypeOfVehicle getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }
}
