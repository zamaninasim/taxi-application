package ir.maktab.dataAccess;

import ir.maktab.enums.Color;
import ir.maktab.enums.TypeOfVehicle;
import ir.maktab.model.Vehicle;

import java.sql.*;

public class VehicleDao extends DataBaseAccess {

    public VehicleDao() throws ClassNotFoundException, SQLException {
    }

    public int save(Vehicle vehicle) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sqlQuary = String.format("INSERT INTO vehicles (type_of_vehicle,color_of_vehicle,plaque_of_vehicle,model_of_vehicle) " +
                            "VALUES ('%s' , '%s' , '%s' , '%s')", vehicle.getTypeOfVehicle(), vehicle.getColorOfVehicle(),
                    vehicle.getPlaqueOfVehicle(), vehicle.getModelOfVehicle());
            int i = statement.executeUpdate(sqlQuary);
            if (i == 1) {
                System.out.println("vehicle Information was recorded");
            }
            return 1;
        } else {
            return 0;
        }
    }

    public Vehicle getVehicle(String plaque_of_vehicle) throws SQLException {
        if (getConnection() != null) {
            String sqlQuery = "SELECT * FROM vehicles WHERE plaque_of_vehicle = ?";
            PreparedStatement findVehicle = getConnection().prepareStatement(sqlQuery);
            findVehicle.setString(1, plaque_of_vehicle);
            ResultSet resultSet = findVehicle.executeQuery();
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle(resultSet.getInt(1));
                return vehicle;
            }
        }
        return null;
    }
}
