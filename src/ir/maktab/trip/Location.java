package ir.maktab.Trip;

public class Location {
    private String latitude;
    private String Longitude;

    public Location(String latitude, String longitude) {
        this.latitude = latitude;
        Longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }
}
