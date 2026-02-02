package domain.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    public List<Integer> problemNumbersGenerate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int num = random.nextInt(9) + 1;
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }
}
