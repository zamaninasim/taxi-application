package ir.maktab.enums;

public enum Color {
    RED("red"),
    BLUE("blue"),
    WHITE("white"),
    BLACK("black"),
    BEIGE("beige"),
    GREEN("green"),
    YELLOW("yellow");
    private String abrr;

    Color(String abrr) {
        this.abrr = abrr;
    }

    public String getAbrr() {
        return abrr;
    }
}
