package com.company;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * The abstract class, extends of following classes OwnQuiz, PuzzlesQuiz, QuizWithProverbs, QuizWithQuotes
 */
public abstract class Game {

    protected ArrayList<QuestionAnswer> questions = new ArrayList<QuestionAnswer>();
    PointsCounter pointsCounter = new PointsCounter();
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor to assign a question - the answer
     *
     * @param questions
     */
    public Game( String[] questions ) {
        for (int i = 0; i < questions.length - 1; i += 2) {
            this.questions.add(new QuestionAnswer(questions[i], questions[i + 1]));
        }
    }

    /**
     * The abstract function, visible to all successor classes, but the implementation is different, depending on the selected game
     */
    public abstract void startGame();

    /**
     * The function to compare user input with the correct answer
     *
     * @param userAnswer
     * @param questionIndex
     * @return true or false
     */
    public boolean verifyWith( String userAnswer, int questionIndex ) {
        return questions.get(questionIndex).getAnswer().equalsIgnoreCase(userAnswer);
    }


}
