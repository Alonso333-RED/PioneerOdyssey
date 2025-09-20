package cl.alonso.pioneerodyssey.utils;

public enum Tier {
    Tier1(1),
    Tier2(2),
    Tier3(3),
    Tier4(4),
    Tier5(5),
    Tier6(6),
    Tier7(7),
    Tier8(8),
    Tier9(9),
    Tier10(10);

    private final int value;

    Tier(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
