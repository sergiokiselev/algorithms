package algo.sort;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BubbleSort {

    public static void main(String[] args) {
        List<Integer> items = new Random().ints(100, 0, 200).boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < items.size(); i++) {
            for (int j = items.size() - 1; j > i; j--) {
                if (items.get(j) < items.get(j - 1)) {
                    Collections.swap(items, j, j - 1);
                }
            }
        }

        System.out.println(items);
    }
}
