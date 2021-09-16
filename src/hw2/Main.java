package hw2;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;
import lesson2.MyArrayList;

public class Main {
    private static final int LIST_SIZE = 10000;
    private static final int AVG_ITERATIONS = 5;
    private static SortPerformanceMeter sortMeter;
    private static MyArrayList<Integer> myTestList;

    public static void main(String[] args) {

        sortMeter = new SortPerformanceMeter(AVG_ITERATIONS);
        initList();

        measureResult(myTestList, myTestList::bubbleSort, "bubbleSort");
        measureResult(myTestList, myTestList::bubbleSortOptimized, "bubbleSortOpt");
        measureResult(myTestList, myTestList::selectionSort, "selectionSort");
        measureResult(myTestList, myTestList::insertionSort, "insertionSort");
    }

    private static void initList() {
        myTestList = new MyArrayList<>(LIST_SIZE);
        for (int i = 0; i < LIST_SIZE; i++) {
            myTestList.add(i + 1);
        }
    }

    private static void measureResult(MyArrayList<Integer> myList, Runnable action, String reportTitle) {
        sortMeter.shuffle(myList);
        System.out.println(sortMeter.measure(action, reportTitle));
        System.out.println("result is sorted: " + sortMeter.assertSorted(myList));
        System.out.println();
    }

}
