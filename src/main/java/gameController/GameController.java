package gameController;

import domain.model.BaseBallNumbers;
import domain.model.GameResult;
import domain.service.Referee;
import domain.generator.BaseBallNumbersGenerator;
import domain.generator.RandomNumbersGenerator;
import handler.InputHandler;
import view.OutputView;


public class GameController {
    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final Referee referee;
    private int failCount;

    public GameController() {
        this.inputHandler = new InputHandler();
        this.outputView = new OutputView();
        this.referee = new Referee();
        this.failCount = 0;
    }

    public void start() {
        BaseBallNumbersGenerator numberGenerator = new BaseBallNumbersGenerator(new RandomNumbersGenerator());
        BaseBallNumbers problemNumbers = new BaseBallNumbers(numberGenerator.generate());
        outputView.printGameStart();
        try {
            while (true) {
                String userInput = inputHandler.getUserInput();
                BaseBallNumbers userNumbers = BaseBallNumbers.parseIntegerList(userInput);
                GameResult gameResult = referee.decides(problemNumbers, userNumbers);
                if (gameResult.isWin()) {
                    outputView.printWin();
                    break;
                }
                failCount++;
                outputView.printResult(gameResult.getStrike(), gameResult.getBall(), failCount);
            }
            inputHandler.close();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            System.exit(0);
        }
    }
}
