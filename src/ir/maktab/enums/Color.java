package ir.maktab.enums;

public enum Color {
    RED,
    BLUE,
    WHITE,
    BLACK,
    BEIGE,
    GREEN,
    YELLOW,
    NONE;

    public static Color getValue(String name) {
        switch (name.toLowerCase()) {
            case "red":
                return RED;
            case "blue":
                return BLUE;
            case "white":
                return WHITE;
            case "black":
                return BLACK;
            case "beige":
                return BEIGE;
            case "green":
                return GREEN;
            case "yellow":
                return YELLOW;
            default:
                return NONE;
        }
    }

}
