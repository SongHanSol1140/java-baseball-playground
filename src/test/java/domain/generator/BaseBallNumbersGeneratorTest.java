package domain.generator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallNumbersGeneratorTest {

    @Test
    void Numbers123Test() {
        NumberGenerator fixedGenerator = new TestNumberGenerator(1, 2, 3);
        BaseBallNumbersGenerator generator = new BaseBallNumbersGenerator(fixedGenerator);
        List<Integer> result = generator.generate();
        assertThat(result).containsExactly(1, 2, 3);
        // assertThat(result) => 검사할 값
        // containsExactly > 배열이 일치하는지 확인(가변 배열을 인자로 받음)
        System.out.println("Number123Test Check Complete");
    }

    @Test
    void Numbers459() {
        NumberGenerator fixedGenerator = new TestNumberGenerator(4, 5, 9);
        BaseBallNumbersGenerator generator = new BaseBallNumbersGenerator(fixedGenerator);
        List<Integer> result = generator.generate();
        assertThat(result).containsExactly(4, 5, 9);
        System.out.println("Numbers459 Check Complete");
    }

    @Test
    void duplicateNumbersCheck() {
        NumberGenerator fixedGenerator = new TestNumberGenerator(1, 1, 2, 3);
        BaseBallNumbersGenerator generator = new BaseBallNumbersGenerator(fixedGenerator);
        List<Integer> result = generator.generate();
        assertThat(result).containsExactly(1, 2, 3);
        assertThat(result).hasSize(3);
    }
}
