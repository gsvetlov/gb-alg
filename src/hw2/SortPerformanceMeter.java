package hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lesson2.MyArrayList;

public class SortPerformanceMeter {
    private final Random random;
    private final int iterationsCount;

    public SortPerformanceMeter(int iterationsCount) {
        random = new Random();
        this.iterationsCount = iterationsCount;
    }

    public PerformanceReport measure(Runnable action, String reportTitle) {

        List<Long> processingTimes = new ArrayList<>();
        for (int i = 0; i < iterationsCount; i++) {
            long processingTime = meterMethodPerformance(action);
            processingTimes.add(processingTime);
        }
        return new PerformanceReport(processingTimes, reportTitle);
    }

    private long meterMethodPerformance(Runnable action) {

        long startTime = System.nanoTime();
        action.run();
        long processingTime = System.nanoTime() - startTime;
        return processingTime;
    }

    public void shuffle(MyArrayList<?> list) {
        for (int i = 1; i < list.size(); i++) {
            int r = random.nextInt(i + 1);
            swap(list, i, r);
        }
    }

    private <T extends Comparable<T>> void swap(MyArrayList<T> list, int indexA, int indexB) {
        T valueA = list.get(indexA);
        list.replace(indexA, list.get(indexB));
        list.replace(indexB, valueA);
    }

    public <T extends Comparable<T>> boolean assertSorted(MyArrayList<T> list) {
        if (list.size() < 2) {
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }
}
