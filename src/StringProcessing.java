import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringProcessing {
    public static void main(String[] args) {
        // Lista inițială
        String text = "Acesta este un program scris cu java 8 si expresii lambda";
        List<String> words = Arrays.asList(text.split(" "));

        System.out.println("Lista inițială de cuvinte: " + words);

        // a) Filtrarea cuvintelor cu lungime >= 5 caractere
        List<String> longWords = words.stream()
                .filter(word -> word.length() >= 5)
                .collect(Collectors.toList());

        long count = longWords.size();
        System.out.println("\na) Lista cuvintelor cu lungime >= 5: " + longWords);
        System.out.println("   Numărul de cuvinte cu lungime >= 5: " + count);

        // b) Ordonarea listei noi
        List<String> sortedLongWords = longWords.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\nb) Lista ordonată alfabetic: " + sortedLongWords);

        // c) Afișarea unui element care începe cu litera 'p'
        Optional<String> wordStartingWithP = words.stream()
                .filter(word -> word.toLowerCase().startsWith("p"))
                .findFirst();

        System.out.println("\nc) Element care începe cu litera 'p': " +
                wordStartingWithP.orElse("Nu există cuvinte care încep cu litera 'p'"));
    }
}