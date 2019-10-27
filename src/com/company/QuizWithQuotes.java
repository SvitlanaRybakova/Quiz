package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * The class that includes methods for creating quiz with quotes
 */
public class QuizWithQuotes extends Game {
    ArrayList<String[]> options = new ArrayList<>();

    public QuizWithQuotes( String[] questions ) {//create an array of alternatives, [i+2]- [i+4] alternative answers.
        super(init(questions));
        for (int i = 0; i < questions.length; i += 5) {
            options.add(new String[]{questions[i + 2], questions[i + 3], questions[i + 4]});
        }
    }

    /**
     * Split array for storing question and answer [i] question, [i+1] answer and pass to the constructor
     *
     * @param questions
     * @return tasksForGame (question-answer to a new array)
     */
    private static String[] init( String[] questions ) {
        ArrayList<String> filtered = new ArrayList<>();
        for (int i = 0; i < questions.length; i += 5) {
            filtered.add(questions[i]);
            filtered.add(questions[i + 1]);
        }
        String[] tasksForGame = new String[filtered.size()];
        filtered.toArray(tasksForGame);
        return tasksForGame;
    }

    /**
     * Overridden function, displays questions in a random order,
     * calls a function to compare the user's answer with the correct answer,
     * adds points for the correct answer, displays the number of points scored
     */
    @Override
    public void startGame() {
        System.out.println("Start the game! Choose the correct answer. You should enter a full name");
        for (int i = 0; i < questions.size(); i++) {
            QuestionAnswer question = questions.get(i);
            System.out.println(question.getQuestion());
            ArrayList<String> options = new ArrayList(Arrays.asList(this.options.get(i)));
            options.add(question.getAnswer());
            Collections.shuffle(options);
            System.out.println(options);
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
     * The static function, the QuizWithQuotes constructor is called
     *
     * @return new QuizWithQuotes (class object)
     */
    public static QuizWithQuotes createInstance() {
        String fileName = "./tasksForQuizWithQuotes";
        return new QuizWithQuotes(FileUtils.readAllLines(fileName));
    }

}


