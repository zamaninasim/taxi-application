package ir.maktab.model;

import ir.maktab.enums.Color;
import ir.maktab.enums.Gender;
import ir.maktab.enums.TypeOfVehicle;

import java.sql.Date;

public class Driver extends Users {
    private TypeOfVehicle typeOfVehicle;
    private Color colorOfVehicle;
    private String plaqueOfVehicle;
    private String modelOfVehicle;

    public Driver(String fullName, String phoneNumber, String email, Gender gender, Date dateOfBirth,
                  String nationalId, String userName, TypeOfVehicle typeOfVehicle,
                  Color colorOfVehicle, String plaqueOfVehicle, String modelOfVehicle) {
        super(fullName, phoneNumber, email, gender, dateOfBirth, nationalId, userName);
        this.typeOfVehicle = typeOfVehicle;
        this.colorOfVehicle = colorOfVehicle;
        this.plaqueOfVehicle = plaqueOfVehicle;
        this.modelOfVehicle = modelOfVehicle;
    }

    public Driver(int id, String fullName, String userName) {
        super(id, fullName, userName);
    }

    public Driver(int id, String fullName, String phoneNumber, String email, Gender gender,
                  Date dateOfBirth, String nationalId, String userName, TypeOfVehicle typeOfVehicle,
                  Color colorOfVehicle, String plaqueOfVehicle, String modelOfVehicle) {
        super(id, fullName, phoneNumber, email, gender, dateOfBirth, nationalId, userName);
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
}
