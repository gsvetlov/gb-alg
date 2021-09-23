package hw5;

public class Item {
    private final String name;
    private final int volume;
    private final int value;

    public static Item of(String name, int volume, int value) {
        return new Item(name, volume, value);
    }

    private Item(String name, int volume, int value) {
        this.name = name;
        this.volume = volume;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getVolume() {
        return volume;
    }
}
