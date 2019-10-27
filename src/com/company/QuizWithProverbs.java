package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that includes methods for creating quiz with proverbs
 */
public class QuizWithProverbs extends Game {
    public QuizWithProverbs( String[] questions ) {
        super(questions);
    }

    /**
     * The own implementation of the method for the proverbial quiz. Quiz questions will be displayed in order
     */
    @Override
    public void startGame() {
        ArrayList<String> questionsAboutProverbs = new ArrayList<>(10);
        System.out.println("Start the game! You should guess the continuation of the proverb. Enter 1 word");


        for (int i = 0; i < questions.size(); i++) {// quiz questions will be displayed in order
            System.out.println(questions.get(i).getQuestion());
            String userAnswer = scanner.nextLine();
            if (verifyWith(userAnswer, i)) {
                pointsCounter.increase();
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        }
        System.out.println(pointsCounter.userResult());


    }

    /**
     * Create instance QuizWithProverbs
     *
     * @return new QuizWithProverbs (class object)
     */
    public static QuizWithProverbs createInstance() {
        String fileName = "tasksForQuizWithProverbs";
        return new QuizWithProverbs(FileUtils.readAllLines(fileName));

    }

}
