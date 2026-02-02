package view;

public class OutputView {

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작");
    }

    public void printResult(int strike, int ball, int failCount) {
        StringBuilder text = new StringBuilder();

        if (strike > 0) {
            text.append(strike).append("스트라이크 ");
        }
        if (ball > 0) {
            text.append(ball).append("볼 ");
        }
        if (strike == 0 && ball == 0) {
            text.append("실패 ");
        }

        text.append("(").append(failCount).append("번 실패)");
        System.out.println(text.toString());
    }

    public void printWin() {
        System.out.println("정답!");
    }
}
