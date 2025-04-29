//9.3.2
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DistinctSquares {
    public static void main(String[] args) {

        List<Integer> initialList = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        System.out.println("Lista inițială: " + initialList);

        Function<Integer, Integer> square = x -> x * x;

        List<Integer> distinctSquares = initialList.stream()
                .distinct()
                .map(square)
                .toList();

        System.out.println("Lista cu pătratele valorilor distincte: " + distinctSquares);

        List<Integer> alternativeSolution = initialList.stream()
                .distinct()
                .map(n -> n * n)
                .toList();

        System.out.println("Aceeași soluție, implementată diferit: " + alternativeSolution);
    }
}