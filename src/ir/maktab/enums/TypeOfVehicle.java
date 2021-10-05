package ir.maktab.enums;

public enum TypeOfVehicle {
    CAR("car"),
    MOTORCYCLE("motor"),
    VAN("van"),
    VANET("vanet");
    private String abrr;

    TypeOfVehicle(String abrr) {
        this.abrr = abrr;
    }

    public String getAbrr() {
        return abrr;
    }
}
