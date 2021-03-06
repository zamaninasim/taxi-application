package ir.maktab;

import ir.maktab.Exception.*;
import ir.maktab.dataAccess.DriverDao;
import ir.maktab.dataAccess.PassengerDao;
import ir.maktab.dataAccess.VehicleDao;
import ir.maktab.enums.Color;
import ir.maktab.enums.Gender;
import ir.maktab.enums.TypeOfVehicle;
import ir.maktab.model.Driver;
import ir.maktab.model.Passenger;
import ir.maktab.model.Vehicle;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static final Scanner input = new Scanner(System.in);
    static PassengerDao passengerDao;
    static DriverDao driverDao;
    static VehicleDao vehicleDao;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        passengerDao = new PassengerDao();
        driverDao = new DriverDao();
        vehicleDao = new VehicleDao();
        boolean exit = false;
        try {
            do {
                System.out.println("********* Choose an option *********");
                System.out.println("1.Add a group of drivers \n2.Add a group of passengers \n3.Driver signup or login " +
                        "\n4.Passenger signup or login \n5.Show a list of drivers \n6.Show a list of passengers \n7.exit");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter number of drivers:");
                        int count = input.nextInt();
                        for (int i = 0; i < count; i++) {
                            addDriver();
                        }
                        break;
                    case 2:
                        System.out.println("Enter number of passengers:");
                        int countP = input.nextInt();
                        for (int i = 0; i < countP; i++) {
                            addPassenger();
                        }
                        break;
                    case 3:
                        System.out.println("Username:");
                        String user_name_d = input.next();
                        signUpDriver(user_name_d);

                        break;
                    case 4:
                        System.out.println("Username:");
                        String user_name_p = input.next();
                        signUpPassengers(user_name_p);
                        break;
                    case 5:
                        System.out.println("**** all drivers info ****");
                        driverDao.showAllDrivers();
                        break;
                    case 6:
                        System.out.println("**** all passengers info ****");
                        passengerDao.showAllPassengers();
                        break;
                    case 7:
                        exit = true;
                    default:
                        System.out.println(" ");
                }
            } while (!exit);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            input.nextLine();
        }
    }


    public static void addDriver() throws SQLException {
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
        Vehicle vehicle = new Vehicle(type_of_vehicle, color_of_vehicle, plaque_of_vehicle, model_of_vehicle);
        System.out.println(vehicleDao.save(vehicle));
        Vehicle vehicleID = vehicleDao.getVehicle(plaque_of_vehicle);
        try {
            Validation validation = new Validation();
            if (validation.validateUserInfo(full_Name, phone_number, email, national_id, user_name)) {
                Driver driver = new Driver(full_Name, phone_number, email, gender, date_of_birth, national_id, user_name, vehicleID);
                System.out.println(driverDao.save(driver));
            }
        } catch (InvalidPhoneNumberException | InvalidEmailException | InvalidNationalIDException | InvalidNameException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addPassenger() throws SQLException {
        System.out.println("Enter passenger information:(full_name,phone_number,email,gender,date_of_birth,national_id,user_name");
        String information_P = input.next();
        String[] ArrOfInfo_P = information_P.split(",", 7);
        String full_Name_P = ArrOfInfo_P[0];
        String phone_number_P = ArrOfInfo_P[1];
        String email_P = ArrOfInfo_P[2];
        Gender gender_P = Gender.valueOf(ArrOfInfo_P[3]);
        Date date_of_birth_P = Date.valueOf(ArrOfInfo_P[4]);
        String national_id_P = ArrOfInfo_P[5];
        String user_name_P = ArrOfInfo_P[6];
        try {
            Validation validation = new Validation();
            if (validation.validateUserInfo(full_Name_P, phone_number_P, email_P, national_id_P, user_name_P)) {
                Passenger passenger = new Passenger(full_Name_P, phone_number_P, email_P, gender_P, date_of_birth_P, national_id_P, user_name_P);
                System.out.println(passengerDao.save(passenger));
            }
        } catch (InvalidPhoneNumberException | InvalidEmailException | InvalidNationalIDException | InvalidNameException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void signUpDriver(String user_name) {
        try {
            if (!driverDao.isDriverExist(user_name)) {
                System.out.println("*** You are not registered ***");
                System.out.println("1.Register \n2.Exit");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        addDriver();
                        break;
                    case 2:
                        System.out.println("*** You are back to the main menu ***");
                        break;
                }
            } else {
                System.out.println("*** welcome ****");
                System.out.println("1.continue \n2.Exit");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("********** coming soon *************");
                        break;
                    case 2:
                        System.out.println("*** You are back to the main menu ***");
                        break;
                }
            }
        } catch (SQLException | ExistUsernameException e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    public static void signUpPassengers(String user_name) {
        try {
            if (!passengerDao.isPassengerExist(user_name)) {
                System.out.println("*** You are not registered ***");
                System.out.println("1.Register \n2.Exit");
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        addPassenger();
                        break;
                    case 2:
                        System.out.println("*** You are back to the main menu ***");
                        break;
                }
            } else {
                System.out.println("*** welcome ****");
                System.out.println("1.continue \n2.Exit");
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("********** coming soon *************");
                        break;
                    case 2:
                        System.out.println("*** You are back to the main menu ***");
                        break;
                }
            }
        } catch (SQLException | ExistUsernameException e) {
            System.out.println(e.getMessage());
        }
    }
}

