package ir.maktab.dataAccess;

import ir.maktab.Exception.ExistUsernameException;
import ir.maktab.enums.Gender;
import ir.maktab.model.Passenger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static ir.maktab.Main.addPassenger;

public class PassengerDao extends DataBaseAccess {
    public PassengerDao() throws ClassNotFoundException, SQLException {
    }

    public int save(Passenger passenger) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sqlQuary = String.format("INSERT INTO passengers (full_name,phone_number,email,gender,date_of_birth,national_id,user_name) " +
                            "VALUES ('%s' , '%s' , '%s' , '%s' , '%tF' , '%s' , '%s')", passenger.getFullName(), passenger.getPhoneNumber(), passenger.getEmail(), passenger.getGender(),
                    passenger.getDateOfBirth(), passenger.getNationalId(), passenger.getUserName());
            int i = statement.executeUpdate(sqlQuary);
            if (i == 1) {
                System.out.println("passenger Information was recorded");
            }
            return 1;
        } else {
            return 0;
        }
    }

    public void showAllPassengers() throws SQLException {
        if (getConnection() != null) {
            String sqlQuery = String.format("SELECT * FROM passengers");
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ArrayList<Passenger> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                Passenger passenger = new Passenger(resultSet.getInt("id"), resultSet.getString("full_name"),
                        resultSet.getString("phone_number"), resultSet.getString("email"), Gender.getValue(resultSet.getString("gender").toUpperCase()),
                        resultSet.getDate("date_of_birth"), resultSet.getString("national_id"), resultSet.getString("user_name"));
                arrayList.add(passenger);
            }
            for (Passenger passenger : arrayList) {
                System.out.println("ID:" + passenger.getId() + ",");
                System.out.println("full_name:" + passenger.getFullName() + ",");
                System.out.println("phone_number:" + passenger.getPhoneNumber() + ",");
                System.out.println("email:" + passenger.getEmail() + ",");
                System.out.println("gender:" + passenger.getGender() + ",");
                System.out.println("date_of_birth:" + passenger.getDateOfBirth() + ",");
                System.out.println("national_id:" + passenger.getNationalId() + ",");
                System.out.println("user_name:" + passenger.getUserName() + ",");
                System.out.println("**************************************");
            }
        }
    }

    public boolean isPassengerExist(String user_name) throws SQLException, ExistUsernameException {
        String sqlQuery = String.format("SELECT id FROM drivers WHERE user_name = ?");
        PreparedStatement findDriverID = getConnection().prepareStatement(sqlQuery);
        findDriverID.setString(1, user_name);
        ResultSet resultSet = findDriverID.executeQuery();
        if (!resultSet.next()) {
            return false;
        }
        return true;

    }
}
