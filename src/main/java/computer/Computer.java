package computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Computer {
    private List<Integer> numbers;
    private final Random random;

    public Computer() {
        this.numbers = new ArrayList<>();
        this.random = new Random();
    }

    public void generateNumbers() {
        numbers.clear(); // 게임 재시작 시 필요
        while (numbers.size() < 3) {
            int num = random.nextInt(9) + 1; // 1-9
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
    }

    public int[] compare(String userInput) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int userNum = Character.getNumericValue(userInput.charAt(i));
            if (userNum == numbers.get(i)) {
                strike++;
            } else if (numbers.contains(userNum)) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }

    // 테스트
    public List<Integer> getNumbers() {
        return numbers;
    }
}
