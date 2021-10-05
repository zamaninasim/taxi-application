package ir.maktab.dataAccess;

import ir.maktab.model.Passenger;

import java.sql.SQLException;
import java.sql.Statement;

public class PassengerDao extends DataBaseAccess {
    public PassengerDao() throws ClassNotFoundException, SQLException {
    }

    public int save(Passenger passenger) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sqlQuary = String.format("INSERT INTO passengers (full_name,phone_number,email,gender,date_of_birth,national_id,user_name) " +
                            "VALUES ('%s' , '%s' , '%s' , '%s' , '%tF' , '%s' , '%s')", passenger.getFullName(), passenger.getPhoneNumber(), passenger.getEmail(),passenger.getGender(),
                    passenger.getDateOfBirth(), passenger.getNationalId(), passenger.getUserName());
            int i = statement.executeUpdate(sqlQuary);
            return 1;
        } else {
            return 0;
        }
    }
}
