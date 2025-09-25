package cl.alonso.pioneerodyssey.utils;

public enum WeaponType {
    Ballistic("Balistico"),
    Laser("Laser"),
    Missile("Misil"),
    Plasma("Plasma"),
    All("Cualquiera");

    private final String value;

    WeaponType(String value) {this.value = value;}

    public String getValue() {return value;}

}
