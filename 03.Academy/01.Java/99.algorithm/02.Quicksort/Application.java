import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {
        final List<Integer> randomInts = new Random()
                .ints(10, 1, 30)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(randomInts);
        final List<Integer> sorted = Quicksort.sort(randomInts);
        System.out.println(sorted);
    }

}