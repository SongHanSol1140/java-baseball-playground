package domain.service;

import domain.model.BaseBallNumbers;
import domain.model.GameResult;

public class Referee {

    public GameResult decides(BaseBallNumbers problemNumbers, BaseBallNumbers inputNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < problemNumbers.size(); i++) {
            int guessNum = inputNumber.get(i);
            if (guessNum == problemNumbers.get(i)) {
                strike++;
            } else if (problemNumbers.contains(guessNum)) {
                ball++;
            }
        }
        return new GameResult(strike, ball);
    }
}
