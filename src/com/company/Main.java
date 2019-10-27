package com.company;

/**
 * This program is a quiz game.
 * You can choose several options for the game:
 * guess simple puzzles (PuzzlesQuiz),
 * guess the continuation of proverbs(QuizWithProverbs),
 * guess famous people by their statements (this option offers the opportunity to choose) (QuizWithQuotes) or
 * create your own quiz(OwnQuiz).
 */
public class Main {

    public static void main( String[] args ) {
        Program quiz = new Program();
        quiz.showMenu();
    }
}
