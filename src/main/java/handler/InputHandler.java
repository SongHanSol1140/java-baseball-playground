package handler;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;
    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        System.out.print("숫자를 입력하세요: ");
        String input = scanner.nextLine();
        validate(input);
        return input;
    }

    private void validate(String input) {
        // 자릿수 체크
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }
        // 1-9 숫자 확인
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("1-9 사이 숫자만 입력하세요.");
            }
        }
        // 중복 체크
        if (input.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }

    }

    // 재시작 로직이
    public void close() {
        scanner.close();
    }
}
