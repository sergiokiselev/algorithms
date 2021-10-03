package algo.sort;

import java.util.List;

import static algo.sort.Util.getItemsToSort;

public class SelectionSort {

    private static int numOfIterations = 0;

    public static void main(String[] args) {
        List<Integer> items = getItemsToSort(100);
        for (int i = 0; i < items.size(); i++) {
            int max = findMax(items, i);
            System.out.println(items.get(max));
//            Collections.swap(items, i, max);
            swap(items, i, max);
        }

        System.out.println(items);
        System.out.println(numOfIterations);
    }

    private static int findMax(List<Integer> items, int i) {
        int max = i;
        for (int j = i; j < items.size(); j++) {
            numOfIterations++;
            if (items.get(j) > items.get(max)) {
                max = j;
            }
        }
        return max;
    }

    private static void swap(List<Integer> items, int i, int max) {
        int buf = items.get(max);
        items.set(max, items.get(i));
        items.set(i, buf);
    }
}
