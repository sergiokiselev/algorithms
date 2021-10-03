package algo.sort;

import java.util.ArrayList;
import java.util.List;

import static algo.sort.Util.getItemsToSort;

public class MergeSort {

    private static int numOfIterations = 0;

    public static void main(String[] args) {
        List<Integer> items = getItemsToSort(100);
        System.out.println(items);
        sort(0, items.size() - 1, items, 0);
        System.out.println(items);
        System.out.println(numOfIterations);
    }

    private static void sort(int l, int r, List<Integer> items, int level) {
        level++;
        System.out.println(level);
        if (l != r) {
            int k = (l + r) / 2;
            sort(l, k, items, level);
            sort(k + 1, r, items, level);
            merge(items, l, k, r);
        }
    }

    private static void merge(List<Integer> items, int l, int z, int r) {
        List<Integer> result = new ArrayList<>(items.size());
        int i = l, j = z +1;

        while (i <= z && j <= r) {
            if (items.get(i) < items.get(j)) {
                result.add(items.get(i));
                i++;
            } else {
                result.add(items.get(j));
                j++;
            }
            numOfIterations++;
        }
        while (i <= z) {
            result.add(items.get(i));
            i++;
            numOfIterations++;
        }
        while (j <= r) {
            result.add(items.get(j));
            j++;
            numOfIterations++;
        }
        for (i = l; i <= r; i++) {
            items.set(i, result.get(i - l));
        }
    }
}
