package algo.sort;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class InsertionSort {

    public static void main(String[] args) {
        List<Integer> items = new Random().ints(100, 1, 200)
                .boxed().collect(Collectors.toList());
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
