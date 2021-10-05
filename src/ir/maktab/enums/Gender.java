package ir.maktab.enums;

public enum Gender {
    FEMALE("f"),
    MALE("m");
    private String abrr;

    Gender(String abrr) {
        this.abrr = abrr;
    }

    public String getAbrr() {
        return abrr;
    }
}
