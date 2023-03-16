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
        List <Integer> numbers = Arrays.asList(1,3,14,18,45,98,11,16,23,45);
             List <Integer> sortedNumbers = numbers.stream()
                .filter(n->n%2==0)
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);


        //задача 2
        Stream <? extends T> numbers1 = (Stream<? extends T>) Stream.of(1,3,14,18,45,98,11,16,23,45);
        Comparator <? super T> comparator = new Comparator<? super T>() { //почему он не принимает те же параметры, что и слева?
            @Override // почему это не переопределение метода?
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                }
                return 0;
            }
        };
        BiConsumer <T,T> MinMax = new BiConsumer<T, T>() {
            @Override
            public void accept(T t, T t2) {
                System.out.println(t);
                System.out.println(t2);

            }
        };


        findMinMax(numbers1, comparator, MinMax);

    }
    public static <T> void findMinMax(Stream <? extends T> stream,
Comparator <? super T> order,
        BiConsumer <? super T, ? super T> minMaxConsumer){
       T max;
       T min;
               List<T> sStream = stream.sorted()
                .collect(Collectors.toList());
        max = sStream.get(0);
        min= sStream.get(sStream.size());
        minMaxConsumer.accept(min,max);


    };
    class Sorting<T> implements Comparator <Integer> {
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
    }