package tw.zeng.bowlinggame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BowlingGame bowlingGame = new BowlingGame();
        System.out.println("輸入start開始遊戲");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("start") || scanner.nextLine().equals("START")) {
            bowlingGame.start();
            System.out.println("保齡球遊戲開始了...");
            System.out.println("---------------------------");
            while (!bowlingGame.isGameOver()) {
                System.out.printf("第 %d 局，第 %s 次投球 ^_^\n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
                System.out.println("---------------------------");
                System.out.println("輸入 r 來投球~");
                Frame frame = bowlingGame.getFrames()[bowlingGame.getWhichFrame() - 1];
                int score = frame.getRoll(bowlingGame.getWhichRoll()).randomThrow(frame.getPins());
                System.out.printf("你擊倒了 %d 個球瓶 \n", score);
                System.out.println("---------------------------");
                frame.updateFrameScore();
                frame.updateScoreType();
                frame.updatePins(score);
                bowlingGame.updateBonus();
                bowlingGame.updateGame();
            }
        }

    }
}
