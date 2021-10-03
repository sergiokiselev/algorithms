package algo.sort;

import java.util.Collections;
import java.util.List;

import static algo.sort.Util.getItemsToSort;

public class QuickSort {

    private static int numOfOperations = 0;

    public static void main(String[] args) {
        List<Integer> items = getItemsToSort(100);
        System.out.println(items);
        sort(items, 0, items.size() - 1);
        System.out.println(items);
        System.out.println(numOfOperations);
    }

    private static void sort(List<Integer> items, int l, int r) {
        int x = items.get((l +  r) / 2);
        int i = l, j = r;
        do {
            while (items.get(i) < x) {
                i++;
                numOfOperations++;
            }
            while (items.get(j) > x) {
                j--;
                numOfOperations++;
            }
            if (i <=j) {
                Collections.swap(items, i, j);
                i++;
                j--;
                numOfOperations++;
            }
        } while (i <= j);

        if (l < j) sort(items, l, j);
        if (r > i) sort(items, i, r);
    }
}
