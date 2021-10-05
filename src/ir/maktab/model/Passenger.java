package ir.maktab.model;

import ir.maktab.enums.Gender;

import java.sql.Date;

public class Passenger extends Users {
    public Passenger(String fullName, String phoneNumber, String email, Gender gender,
                     Date dateOfBirth, String nationalId, String userName) {
        super(fullName, phoneNumber, email, gender, dateOfBirth, nationalId, userName);
    }


}
