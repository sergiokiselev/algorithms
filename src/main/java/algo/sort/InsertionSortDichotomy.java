package algo.sort;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class InsertionSortDichotomy {

    public static void main(String[] args) {
        List<Integer> items = ThreadLocalRandom.current().ints(100, 0, 200)
                .boxed().collect(Collectors.toList());

        System.out.println(items);

        int numOfIterations = 0;
        int l, r, m;
        for (int i = 0; i < items.size(); i++) {
            r = i;
            l = 0;
            while (r > l) {
                m = (l + r) / 2;
                if (items.get(m) > items.get(i)) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            System.out.println(r);
            int x = items.get(i);
            for (int j = i; j > r; j--) {
                numOfIterations++;
                Collections.swap(items, j, j - 1);
            }
            items.set(r, x);
        }
        System.out.println(items);
        System.out.println(numOfIterations);
    }
}

//
//100 99 98 97 96 95 95
//
//L = 0
//R = 6
//m = L + R / 2= 3
//x = 95
//if (a[m] > x) L = m else R = m
//L = 4
//R = 6
//m = 5
//if (a[5] > 95) L = 6 else R = 5
//R = 5
