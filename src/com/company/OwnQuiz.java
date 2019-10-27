package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that includes methods for creating your own game
 */
public class OwnQuiz extends Game {
    /**
     * For att trick the constructor of the abstract class Game by passing an empty array as a parameter
     */
    public OwnQuiz() {
        super(new String[]{});
    }

    Scanner scanner = new Scanner(System.in);

    /**
     * The override method implementation for own game
     */
    @Override
    public void startGame() {
        System.out.println("Now you can create own quiz! First you must add questions and answers for your quiz.");
        String userChoice;

        do {// display an additional menu to create your own quiz
            System.out.println("Choose a menu item:\n" +
                    "1. Add a new questions:\n" +
                    "2. Take the quiz.\n" +
                    "3. Show all questions:\n" +
                    "4. Exit to the main menu\n");
            userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    addQuestions();
                    break;
                case "2":
                    takeTheQuiz();
                    break;
                case "3":
                    showQuestions();
                    break;
                case "4":
                    Program mainMenu = new Program();
                    mainMenu.showMenu();
                    break;
                default:
                    System.out.println("Wrong input! Try again.");
            }
        } while (!userChoice.equals("5"));
    }

    /**
     * The method for creating questions and answers of  own quiz
     */
    public void addQuestions() {
        System.out.println("Write a question for quiz");
        String userQuestion = scanner.nextLine();

        System.out.println("Write the right answer for your question ");
        String userAnswer = scanner.nextLine();

        QuestionAnswer userGame = new QuestionAnswer(userQuestion, userAnswer);
        questions.add(userGame);
    }

    /**
     * The  method that allows you to play the quiz, user responses are compared with the correct answers,
     * the screen prints correctly or not. Questions are displayed in order
     */
    public void takeTheQuiz() {
        for (int i = 0; i < questions.size(); i++) {
            QuestionAnswer currentQuestion = questions.get(i);
            System.out.println(currentQuestion.getQuestion());
            String answer = scanner.nextLine();

            if (this.verifyWith(answer, i)) {
                System.out.println("Correct");
            } else {
                System.out.println("Wrong answer, the correct is [%s] " + currentQuestion.getAnswer());
            }
        }
    }

    /**
     * Displays all the correct answers
     */
    public void showQuestions() {
        for (QuestionAnswer question : questions) {
            System.out.println(question);
        }
    }
}
