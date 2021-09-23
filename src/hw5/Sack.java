package hw5;

import java.util.ArrayList;
import java.util.Arrays;
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
        int vSize = volume / volumeStep;

        int[][] values = new int[list.size()][vSize];

        for (int v = 0; v < vSize; v++) {
            int volumeLimit = (v + 1) * volumeStep;
            values[0][v] = volumeLimit >= list.get(0).getVolume() ? list.get(0).getValue() : 0;
        }

        for (int j = 1; j < list.size(); j++) {
            for (int v = 0; v < vSize; v++) {
                int volumeLimit = (v + 1) * volumeStep;
                Item item = list.get(j);
                if (item.getVolume() <= volumeLimit) {
                    values[j][v] = Integer.max(values[j - 1][v],
                            item.getValue() + (((v - item.getVolume() / volumeStep) < 0 ? 0
                                    : values[j - 1][v - item.getVolume() / volumeStep])));
                } else {
                    values[j][v] = values[j - 1][v];
                }
            }
        }

        return values[list.size() - 1][vSize - 1];
    }


}
