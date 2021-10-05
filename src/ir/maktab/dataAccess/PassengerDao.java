package ir.maktab.dataAccess;

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
                System.out.println("Information was recorded");
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
                Passenger passenger1 = new Passenger(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), Gender.valueOf(resultSet.getString(5)),
                        resultSet.getDate(6), resultSet.getString(7), resultSet.getString(8));
                arrayList.add(passenger1);
            }
            for (Passenger passenger1 : arrayList) {
                System.out.println("ID:" + passenger1.getId() + ",");
                System.out.println("full_name:" + passenger1.getFullName() + ",");
                System.out.println("phone_number:" + passenger1.getPhoneNumber() + ",");
                System.out.println("email:" + passenger1.getEmail() + ",");
                System.out.println("gender:" + passenger1.getGender() + ",");
                System.out.println("date_of_birth:" + passenger1.getDateOfBirth() + ",");
                System.out.println("national_id:" + passenger1.getNationalId() + ",");
                System.out.println("user_name:" + passenger1.getUserName() + ",");
                System.out.println("**************************************");
            }
        }
    }

    public int findPassengers(String user_name) throws SQLException, ClassNotFoundException {
        int id = 0;
        String sqlQuery = String.format("SELECT id FROM drivers WHERE user_name = ?");
        PreparedStatement findDriverID = getConnection().prepareStatement(sqlQuery);
        findDriverID.setString(1, user_name);
        ResultSet resultSet = findDriverID.executeQuery();
        if (!resultSet.next()) {
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
}
