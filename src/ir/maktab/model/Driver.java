package ir.maktab.model;

import ir.maktab.enums.Color;
import ir.maktab.enums.Gender;
import ir.maktab.enums.TypeOfVehicle;

import java.sql.Date;

public class Driver extends Users {
    private Vehicle vehicle;

    public Driver(int id, String fullName, String phoneNumber, String email, Gender gender,
                  Date dateOfBirth, String nationalId, String userName, Vehicle vehicle) {
        super(id, fullName, phoneNumber, email, gender, dateOfBirth, nationalId, userName);
        this.vehicle = vehicle;
    }

    public Driver(String fullName, String phoneNumber, String email, Gender gender,
                  Date dateOfBirth, String nationalId, String userName, Vehicle vehicle) {
        super(fullName, phoneNumber, email, gender, dateOfBirth, nationalId, userName);
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
