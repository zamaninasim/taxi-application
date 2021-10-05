package ir.maktab.dataAccess;

import ir.maktab.model.Driver;
import ir.maktab.model.Passenger;

import java.sql.SQLException;
import java.sql.Statement;

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
            return 1;
        } else {
            return 0;
        }
    }
}
