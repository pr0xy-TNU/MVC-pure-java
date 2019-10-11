package model;

public enum BeerType {
    BLACK("black"),
    RED("red"),
    WHITE("white"),
    UNKNOWN("unknown");

    private String colorValue;

    BeerType(String colorValue) {
        this.colorValue = colorValue;
    }

    public static BeerType getBeerTypeByColorName(String strValue) throws Exception {
        for (BeerType item : values()
        ) {
            if (item.colorValue.equals(strValue)) {
                return item;
            }
        }
        throw new Exception("Color not found");
    }
}