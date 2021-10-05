package ir.maktab;

import ir.maktab.dataAccess.DriverDao;
import ir.maktab.dataAccess.PassengerDao;
import ir.maktab.enums.Color;
import ir.maktab.enums.Gender;
import ir.maktab.enums.TypeOfVehicle;
import ir.maktab.model.Driver;
import ir.maktab.model.Passenger;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        PassengerDao passengerDao = new PassengerDao();
        DriverDao driverDao = new DriverDao();
        Scanner input = new Scanner(System.in);

        System.out.println("********* Choose an option *********");
        System.out.println("1)add driver \n2)add passenger)");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter drivers information:" +
                        " (full_name,phone_number,email,gender,date_of_birth,national_id,user_name,type_of_vehicle," +
                        "color_of_vehicle,plaque_of_vehicle,model_of_vehicle):");
                String information = input.next();
                String[] arrOfInfo = information.split(",", 11);
                String full_Name = arrOfInfo[0];
                String phone_number = arrOfInfo[1];
                String email = arrOfInfo[2];
                Gender gender = Gender.valueOf(arrOfInfo[3]);
                Date date_of_birth = Date.valueOf(arrOfInfo[4]);
                String national_id = arrOfInfo[5];
                String user_name = arrOfInfo[6];
                TypeOfVehicle type_of_vehicle = TypeOfVehicle.valueOf(arrOfInfo[7]);
                Color color_of_vehicle = Color.valueOf(arrOfInfo[8]);
                String plaque_of_vehicle = arrOfInfo[9];
                String model_of_vehicle = arrOfInfo[10];
                Driver driver = new Driver(full_Name, phone_number, email, gender, date_of_birth,
                        national_id, user_name, type_of_vehicle, color_of_vehicle, plaque_of_vehicle, model_of_vehicle);
                System.out.println(driverDao.save(driver));
                break;

            case 2:
                System.out.println("Enter passenger information:(full_name,phone_number,email,gender,date_of_birth,national_id,user_name");
                String pInformation = input.next();
                String[] pArrOfInfo = pInformation.split(",", 7);
                String full_NameP = pArrOfInfo[0];
                String phone_number_P = pArrOfInfo[1];
                String email_P = pArrOfInfo[2];
                Gender gender_P = Gender.valueOf(pArrOfInfo[3]);
                Date date_of_birth_P = Date.valueOf(pArrOfInfo[4]);
                String national_id_P = pArrOfInfo[5];
                String user_name_P = pArrOfInfo[6];
                Passenger passenger = new Passenger(full_NameP, phone_number_P, email_P, gender_P, date_of_birth_P, national_id_P, user_name_P);
                System.out.println(passengerDao.save(passenger));
                break;
        }


    }
}
