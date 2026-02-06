package domain.model;

import java.util.ArrayList;
import java.util.List;

public class BaseBallNumbers {
    public static final int NumberSize = 3;
    private final List<Integer> numbers;



    public static BaseBallNumbers parseIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return new BaseBallNumbers(numbers);
    }

    public BaseBallNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NumberSize) {
            throw new IllegalArgumentException("숫자는 " + NumberSize + "개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != NumberSize) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        for (int num : numbers) {
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("숫자는 1-9 사이여야 합니다.");
            }
        }
    }

    public int get(int index) {
        return numbers.get(index);
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }

    public int size() {
        return numbers.size();
    }
    // 값 확인용
    @Override
    public String toString() {
        return numbers.toString();
    }
}
