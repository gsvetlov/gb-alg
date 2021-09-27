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

    // прямой алгоритм
    public int getBestValueForVolume() {

        int[][] values = new int[list.size() + 1][volume + 1];

        for (int j = 1; j <= list.size(); j++) {
            for (int v = 1; v <= volume; v++) {
                // int volumeLimit = v + 1;
                int itemV = list.get(j - 1).getVolume();
                int itemValue = list.get(j - 1).getValue();
                if (itemV <= v) {
                    values[j][v] = Integer.max(values[j - 1][v],
                            itemValue + ((v - itemV < 0 ? 0 : values[j - 1][v - itemV])));
                } else {
                    values[j][v] = values[j - 1][v];
                }
            }
        }

        return values[list.size()][volume];
    }

    // рекурсивный алгоритм

    private int[][] values;

    public int getBestValueRecursive() {
        initValues(list.size(), volume);
        getValues(list.size(), volume);
        return values[list.size()][volume];
    }

    private void getValues(int i, int j) {
        if (i == 0 || j <= 0) {
            values[i][j] = 0;
            return;
        }
        if (values[i - 1][j] == -1) {
            getValues(i - 1, j);
        }
        int w = list.get(i - 1).getVolume();
        int v = list.get(i - 1).getValue();
        if (w > j) {
            values[i][j] = values[i - 1][j];
        } else {
            if (values[i - 1][j - w] == -1) {
                getValues(i - 1, j - w);
            }
            values[i][j] = Integer.max(values[i - 1][j], values[i - 1][j - w] + v);
        }
    }

    private void initValues(int itemsCount, int volume) {
        values = new int[itemsCount + 1][volume + 1];
        for (int i = 0; i <= itemsCount; i++) {
            for (int j = 0; j <= volume; j++) {
                values[i][j] = -1;
            }
        }
    }

}
