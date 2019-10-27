package com.company;

/**
 * Class that includes methods for scoring correct answers.
 */
public class PointsCounter {
    private int points = 0;

    /**
     * The method  to evaluate the result of the game
     *
     * @return quiz result (type String)
     */
    public String userResult() {
        if (points >= 0 && points < 6) {
            return "Du svarade på de flesta frågor felaktigt. Troligtvis blir du inte litteraturkritiker. " +
                    "Bli inte avskräckt, du måste älska dig själv som du är";
        } else if (points >= 6 && points < 8) {
            return "Detta är ett bra resultat. Du har fullständig kunskap inom området";
        } else {
            return "Grattis, du är expert på språkvetenskapen!";
        }
    }

    /**
     * Increases points amount for right answers
     */
    public void increase() {
        points++;
    }
}
