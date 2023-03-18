import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Main {
    public static <T> void main(String[] args) {

        // задача 1
        List<Integer> numbers = Arrays.asList(1, 3, 14, 18, 45, 98, 11, 16, 23, 45);
        List<Integer> sortedNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);


        //задача 2
        Stream<Integer> numbers1 = Stream.of(1, 3, 14, 18, 45, 98, 11, 16, 23, 45);
        Comparator<Integer> comparator = Comparator.naturalOrder();
        BiConsumer<Integer, Integer> minMax = (s, p) -> System.out.println("Минимальное значение " + s + " максимальное значение " + p);


        findMinMax(numbers1, comparator, minMax);

    }

    public static <Integer> void findMinMax(Stream<Integer> stream,
                                            Comparator<Integer> order,
                                            BiConsumer<Integer, Integer> minMaxConsumer) {
        List<Integer> sStream = stream.sorted()
                .collect(Collectors.toList());
        if (sStream.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(sStream.get(0), sStream.get(sStream.size() - 1));
        }
    }
}
