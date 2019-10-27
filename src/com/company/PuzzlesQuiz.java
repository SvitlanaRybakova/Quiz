package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The class includes methods for creating puzzle quiz
 */
public class PuzzlesQuiz extends Game {

    public PuzzlesQuiz( String[] questions ) {
        super(questions);
    }

    /**
     * The override method implementation for Puzzle quiz. Questions are displayed in random order
     */
    @Override
    public void startGame() {

        ArrayList<Integer> askedQuestions = new ArrayList<>(10);

        System.out.println("Start the game! Answer the questions, you should write 1 word");


        for (int i = 0; i < questions.size(); i++) {
            int idx; // generate index
            do {
                idx = (int) (Math.random() * questions.size()); // questions are displayed in random order
            } while (askedQuestions.contains(idx));// add history so that questions are not displayed again
            System.out.println(questions.get(idx).getQuestion()); // print the question on the screen, get the element by idx index from arraylist questions
            askedQuestions.add(idx);
            String userAnswer = scanner.nextLine();
            if (verifyWith(userAnswer, idx)) {// compare user response with correct answer
                pointsCounter.increase(); // add points for the correct answer
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        }
        System.out.println(pointsCounter.userResult()); // display the result of the quiz on the screen
    }

    /**
     * Create instance PuzzlesQuiz
     *
     * @return new PuzzlesQuiz (class object)
     */
    public static PuzzlesQuiz createInstance() {
        String fileName = "./tasksForPuzzlesQuiz";// read questions from file
        return new PuzzlesQuiz(FileUtils.readAllLines(fileName));
    }
}