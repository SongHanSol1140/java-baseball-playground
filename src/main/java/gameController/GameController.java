package gameController;

import computer.Computer;
import handler.InputHandler;
import view.OutputView;

public class GameController {
    private final Computer computer;
    private final InputHandler inputHandler;
    private final OutputView outputView;
    private int failCount;

    public GameController() {
        this.computer = new Computer();
        this.inputHandler = new InputHandler();
        this.outputView = new OutputView();
        this.failCount = 0;
    }

    public void start() {
        computer.generateNumbers();
        outputView.printGameStart();
        try {
            while (true) {
                String userInput = inputHandler.getUserInput();
                int[] result = computer.compare(userInput);

                int strike = result[0];
                int ball = result[1];

                if (strike == 3) {
                    outputView.printWin();
                    break;
                }

                failCount++;
                outputView.printResult(strike, ball, failCount);
            }
            inputHandler.close();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            System.exit(0);
        }
    }
}
