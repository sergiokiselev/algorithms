package algo.sort;

import java.util.Collections;
import java.util.List;

import static algo.sort.Util.getItemsToSort;

public class ShakerSort {
    public static void main(String[] args) {
        List<Integer> items = getItemsToSort(100);

        System.out.println(items);
        long numberOfIterations = 0;

        int l = 0, r = items.size(), k = items.size();
        while (l < r) {
            for (int i = l; i < r - 1; i++) {
                numberOfIterations++;
                if (items.get(i) > items.get(i + 1)) {
                    Collections.swap(items, i, i + 1);
                    k = i;
                }
            }
            r = k - 1;
            for (int i = r; i > l; i--) {
                numberOfIterations++;
                if (items.get(i) < items.get(i - 1)) {
                    Collections.swap(items, i, i - 1);
                    k = i - 1;
                }
            }
            l = k + 1;
        }

        System.out.println(items);
        System.out.println(numberOfIterations);
    }
}
