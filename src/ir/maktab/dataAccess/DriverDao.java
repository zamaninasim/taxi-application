package ir.maktab.dataAccess;

import ir.maktab.enums.Color;
import ir.maktab.enums.Gender;
import ir.maktab.enums.TypeOfVehicle;
import ir.maktab.model.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static ir.maktab.Main.addDriver;

public class DriverDao extends DataBaseAccess {

    public DriverDao() throws ClassNotFoundException, SQLException {
    }

    public int save(Driver driver) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sqlQuary = String.format("INSERT INTO drivers (full_name,phone_number,email,gender,date_of_birth,national_id,user_name," +
                            "type_of_vehicle,color_of_vehicle,plaque_of_vehicle,model_of_vehicle) " +
                            "VALUES ('%s','%s','%s','%s','%tF','%s','%s','%s','%s','%s','%s')", driver.getFullName(), driver.getPhoneNumber(), driver.getEmail(),
                    driver.getGender(), driver.getDateOfBirth(), driver.getNationalId(), driver.getUserName()
                    , driver.getTypeOfVehicle(), driver.getColorOfVehicle(), driver.getPlaqueOfVehicle(), driver.getModelOfVehicle());
            int i = statement.executeUpdate(sqlQuary);
            if (i == 1) {
                System.out.println("Information was recorded");
            }
            return 1;
        } else {
            return 0;
        }
    }

    public int findDriver(String user_name) throws SQLException, ClassNotFoundException {
        int id = 0;
        String sqlQuery = String.format("SELECT id FROM passengers WHERE user_name = ?");
        PreparedStatement findPassengerID = getConnection().prepareStatement(sqlQuery);
        findPassengerID.setString(1, user_name);
        ResultSet resultSet = findPassengerID.executeQuery();
        if (!resultSet.next()) {
            System.out.println("*** You are not registered ***");
            System.out.println("1.Register \n2.Exit");
            Scanner input = new Scanner(System.in);
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
            id = resultSet.getInt(1);
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
        return id;
    }

    public void showAllDrivers() throws SQLException {
        if (getConnection() != null) {
            String sqlQuery = String.format("SELECT * FROM drivers");
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ArrayList<Driver> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Driver driver = new Driver(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), Gender.valueOf(resultSet.getString(5)),
                        resultSet.getDate(6), resultSet.getString(7), resultSet.getString(8), TypeOfVehicle.valueOf(resultSet.getString(9)),
                        Color.valueOf(resultSet.getString(10)), resultSet.getString(11), resultSet.getString(12));
                arrayList.add(driver);
            }
            for (Driver driver : arrayList) {
                System.out.println("ID:" + driver.getId() + ",");
                System.out.println("full_name:" + driver.getFullName() + ",");
                System.out.println("phone_number:" + driver.getPhoneNumber() + ",");
                System.out.println("email:" + driver.getEmail() + ",");
                System.out.println("gender:" + driver.getGender() + ",");
                System.out.println("date_of_birth:" + driver.getDateOfBirth() + ",");
                System.out.println("national_id:" + driver.getNationalId() + ",");
                System.out.println("user_name:" + driver.getUserName() + ",");
                System.out.println("type_of_vehicle:" + driver.getTypeOfVehicle() + ",");
                System.out.println("color_of_vehicle:" + driver.getColorOfVehicle() + ",");
                System.out.println("plaque_of_vehicle:" + driver.getPlaqueOfVehicle() + ",");
                System.out.println("model_of_vehicle:" + driver.getModelOfVehicle() + ",");
                System.out.println("**************************************");
            }
        }
    }
}
