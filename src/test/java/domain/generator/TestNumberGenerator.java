package domain.generator;

public class TestNumberGenerator implements NumberGenerator {
    private final int[] numbers;
    private int index = 0;

    public TestNumberGenerator(int... numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers[index++];
    }
}
