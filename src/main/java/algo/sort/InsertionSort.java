package algo.sort;

import java.util.Collections;
import java.util.List;

import static algo.sort.Util.getItemsToSort;

public class InsertionSort {

    public static void main(String[] args) {
        List<Integer> items = getItemsToSort(100);
        System.out.println(items);
        int numOfIterations = 0;

        for (int i = 1; i < items.size(); i++) {
            for (int j = i; j > 0; j--) {
                numOfIterations++;
                if (items.get(j) > items.get(j - 1)) {
                    Collections.swap(items, j, j - 1);
                }
            }
        }

        System.out.println(items);
        System.out.println(numOfIterations);
    }
}
