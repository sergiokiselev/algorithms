package algo.sort;

import java.util.Collections;
import java.util.List;

import static algo.sort.Util.getItemsToSort;

public class BubbleSort {

    public static void main(String[] args) {
        List<Integer> items = getItemsToSort(100);

        long numberOfIterations = 0;

        for (int i = 0; i < items.size(); i++) {
            for (int j = items.size() - 1; j > i; j--) {
                numberOfIterations++;
                if (items.get(j) < items.get(j - 1)) {
                    Collections.swap(items, j, j - 1);
                }
            }
        }

        System.out.println(items);
        System.out.println(numberOfIterations);
    }
}
