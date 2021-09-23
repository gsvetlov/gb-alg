package hw5;

import java.util.ArrayList;
import java.util.List;

public class Sack {
    List<Item> list;
    int volume;

    public Sack(int volume) {
        list = new ArrayList<>();
        this.volume = volume;
    }

    public void addItem(Item item) {
        list.add(item);
    }

    public int getBestValueForVolumeItems() {
        int volumeStep = list.stream().mapToInt(i -> i.getVolume()).min().orElseThrow();

        int[][] values = new int[list.size()][volume / volumeStep];

        for (int v = 1; v <= volume / volumeStep; v++) {
            values[0][v - 1] =
                    v * volumeStep >= list.get(0).getVolume() ? list.get(0).getValue() : 0;
        }

        for (int j = 1; j < list.size(); j++) {
            for (int v = 1; v <= volume / volumeStep; v++) {
                Item item = list.get(j);
                if (item.getVolume() <= v * volumeStep) {
                    values[j][v - 1] = Integer.max(values[j - 1][v - 1],
                            item.getValue() + (((v - 1 - item.getVolume() / volumeStep) < 0 ? 0
                                    : values[j - 1][v - 1 - item.getVolume()])));
                } else {
                    values[j][v - 1] = values[j - 1][v - 1];
                }
            }
        }

        int max = 0;
        for (int j = 0; j < list.size(); j++) {
            max = values[j][volume / volumeStep - 1] > max ? values[j][volume / volumeStep - 1]
                    : max;
        }
        return max;
    }


}
