package domain.generator;

import java.util.Random;

public class RandomNumbersGenerator implements NumberGenerator {
    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(9) + 1;
    }
}
