package tw.zeng.bowlinggame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BowlingGame bowlingGame = new BowlingGame();
        System.out.println("ENTER Start TO START THE GAME!");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("start") || scanner.nextLine().equals("START")) {
            bowlingGame.start();
            System.out.println("Bowling game has started...");
            System.out.println("---------------------------");
            System.out.printf("Frame %d %s Roll ^_^\n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            System.out.println("---------------------------");
            System.out.println("Enter R to roll the ball~");
            if(scanner.nextLine().equals('r')){
                //bowlingGame.getFrames()[bowlingGame.getWhichFrame()].getRoll(bowlingGame.getWhichRoll())
            }
        }

    }
}
