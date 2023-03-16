import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MinMax {
    int min;
    Optional<Integer> max;
    Stream <Integer> stream;

    public MinMax(Stream <Integer> stream) {
        this.stream = stream;
    }
    public Stream<Integer> SortedStream (Stream <Integer> stream) {
        Stream <Integer> sortedStream = stream.sort(new Sorting());
        max = sortedStream.max();
        min = sortedStream.min();
    };
class Sorting implements Comparator <Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return 1;
        } else if (o1 < o2) {
            return -1;
        }
        return 0;
    }
}

    BiConsumer<Integer, Integer> minMax = new BiConsumer<Integer, Integer>() {
        @Override
        public void accept(Integer min, Integer max) {
            System.out.println(min);
            System.out.println(max);
        }
    };
}

