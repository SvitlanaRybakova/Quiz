package com.company;

/**
 * The class for creating questions and answers
 */
public class QuestionAnswer {

    private String question;
    private String answer;

    QuestionAnswer( String question, String answer ) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    /**
     * The overridden function to display array elements
     *
     * @return question, answer
     */
    @Override
    public String toString() {
        return String.format("%s : %s\n", question, answer);
    }
}
