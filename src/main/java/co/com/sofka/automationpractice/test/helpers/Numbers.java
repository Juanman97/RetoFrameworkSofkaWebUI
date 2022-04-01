package co.com.sofka.automationpractice.test.helpers;

public enum Numbers {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    private final int value;

    public int getValue() {
        return value;
    }

    Numbers(int value) {
        this.value = value;
    }
}
