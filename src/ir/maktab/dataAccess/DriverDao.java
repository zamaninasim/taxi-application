package ir.maktab.dataAccess;

import ir.maktab.Exception.ExistUsernameException;
import ir.maktab.enums.Color;
import ir.maktab.enums.Gender;
import ir.maktab.enums.TypeOfVehicle;
import ir.maktab.model.Driver;
import ir.maktab.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static ir.maktab.Main.addDriver;

public class DriverDao extends DataBaseAccess {
    Scanner input = new Scanner(System.in);

    public DriverDao() throws ClassNotFoundException, SQLException {
    }

    public int save(Driver driver) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sqlQuary = String.format("INSERT INTO drivers (full_name,phone_number,email,gender,date_of_birth,national_id,user_name,vehicle_id_fk)" +
                            "VALUES ('%s','%s','%s','%s','%tF','%s','%s','%d')", driver.getFullName(), driver.getPhoneNumber(), driver.getEmail(),
                    driver.getGender(), driver.getDateOfBirth(), driver.getNationalId(), driver.getUserName(), driver.getVehicle().getVehicleID());
            int i = statement.executeUpdate(sqlQuary);
            if (i == 1) {
                System.out.println("driver Information was recorded");
            }
            return 1;
        } else {
            return 0;
        }
    }

    public void showAllDrivers() throws SQLException {
        if (getConnection() != null) {
            String sqlQuery = "SELECT * FROM drivers";
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<Driver> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int vehicleID = resultSet.getInt("vehicle_id_fk");
                Vehicle vehicle = new Vehicle(vehicleID);
                Driver driver = new Driver(resultSet.getInt("id"), resultSet.getString("full_name"),
                        resultSet.getString("phone_number"), resultSet.getString("email"),
                        Gender.getValue(resultSet.getString("gender").toUpperCase()),
                        resultSet.getDate("date_of_birth"), resultSet.getString("national_id"),
                        resultSet.getString("user_name"), vehicle);
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
                System.out.println("**************************************");
            }
        }
    }

    public boolean isDriverExist(String user_name) throws SQLException, ExistUsernameException {
        String sqlQuery = "SELECT id FROM drivers  WHERE user_name = ?";
        PreparedStatement findDriverID = getConnection().prepareStatement(sqlQuery);
        findDriverID.setString(1, user_name);
        ResultSet resultSet = findDriverID.executeQuery();
        if (!resultSet.next()) {
            return false;
        }
        return true;

    }
}
