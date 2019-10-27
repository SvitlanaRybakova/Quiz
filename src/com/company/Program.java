package com.company;

import java.util.Scanner;

/**
 * The class contains the main menu and methods for realizing the game
 */
public class Program {
    /**
     * Displayed the Main menu and implements bases methods
     */
    public void showMenu(){
    Scanner scanner = new Scanner(System.in);
    Game currentGame = null;
    String userChoice;
    do {
        System.out.println("Choose a menu item:\n" +
                "1. Puzzles quiz\n" +
                "2. Quiz with proverbs\n" +
                "3. Quiz with quotes\n" +
                "4. Create your own quiz\n" +
                "5. Exit");

        userChoice = scanner.nextLine();

        switch (userChoice){
            case "1":
                currentGame = PuzzlesQuiz.createInstance();
                currentGame.startGame();
                break;
            case "2":
                currentGame = QuizWithProverbs.createInstance();
                currentGame.startGame();
                break;
            case "3":
                currentGame = QuizWithQuotes.createInstance();
                currentGame.startGame();
                break;
            case "4":
                OwnQuiz game = new OwnQuiz();
                game.startGame();
                break;
            case "5":
                System.out.println("Program is finished");
                break;
            default:
                System.out.println(" Incorrect choice");
        }
    }  while (!userChoice.equals("5"));
}
}
