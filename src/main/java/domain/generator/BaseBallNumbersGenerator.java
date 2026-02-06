package domain.generator;

import domain.model.BaseBallNumbers;

import java.util.ArrayList;
import java.util.List;

public class BaseBallNumbersGenerator {
    private final NumberGenerator numberGenerator;

    public BaseBallNumbersGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BaseBallNumbers.NumberSize) {
            int num = numberGenerator.generate();
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }
}
