package algo.sort;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Util {

    public static List<Integer> getItemsToSort(@Nullable Integer size) {
        if (size == null) size = 100;
        return new Random().ints(size, 1, 200)
                .boxed().collect(Collectors.toList());
    }
}
