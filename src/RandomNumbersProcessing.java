//9.3.1
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersProcessing {
    public static void main(String[] args) {
        List<Integer> numbers = generateRandomNumbers(10, 5, 25);
        System.out.println("Lista originală: " + numbers);

        Function<List<Integer>, Integer> sumCalculator = list ->
                list.stream().mapToInt(Integer::intValue).sum();

        int sum = sumCalculator.apply(numbers);
        System.out.println("\na) Suma elementelor: " + sum);


        Function<List<Integer>, OptionalInt> maxFinder = list ->
                list.stream().mapToInt(n -> n).max();


        Function<List<Integer>, OptionalInt> minFinder = list ->
                list.stream().mapToInt(n -> n).min();

        OptionalInt max = maxFinder.apply(numbers);
        OptionalInt min = minFinder.apply(numbers);

        System.out.println("\nb) Valoarea maximă: " + max.getAsInt());
        System.out.println("   Valoarea minimă: " + min.getAsInt());


        Predicate<Integer> inRange = n -> n >= 10 && n <= 20;

        List<Integer> filteredList = numbers.stream()
                .filter(inRange)
                .collect(Collectors.toList());
        System.out.println("\nc) Lista filtrată [10..20]: " + filteredList);


        Function<Integer, Double> toDouble = Integer::doubleValue;

        List<Double> doubleList = numbers.stream()
                .map(toDouble)
                .collect(Collectors.toList());
        System.out.println("\nd) Lista transformată în Double: " + doubleList);


        Predicate<Integer> isEqual12 = n -> n == 12;

        boolean contains12 = numbers.stream().anyMatch(isEqual12);
        System.out.println("\ne) Lista conține valoarea 12: " + contains12);
    }

    private static List<Integer> generateRandomNumbers(int count, int min, int max) {
        Random random = new Random();


        IntSupplier randomNumberSupplier = () -> random.nextInt(max - min + 1) + min;


        return IntStream.range(0, count)
                .map(i -> randomNumberSupplier.getAsInt())
                .boxed()
                .collect(Collectors.toList());
    }
}