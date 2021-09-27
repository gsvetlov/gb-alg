package hw5;

public class Item {
    private final int volume;
    private final int value;

    public static Item of(int volume, int value) {
        return new Item(volume, value);
    }

    private Item(int volume, int value) {
        this.volume = volume;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getVolume() {
        return volume;
    }
}
