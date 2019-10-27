package com.company.tests;

import com.company.PointsCounter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointsCounterTest {

    PointsCounter counter = null;
    @Before
    public void setUp() throws Exception {
         this.counter = new PointsCounter();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void userResult1Point() {
        // simulate 1 correct answer
        counter.increase();
        String result = counter.userResult();
        Assert.assertEquals( "Du svarade på de flesta frågor felaktigt. Troligtvis blir du inte litteraturkritiker. " +
                "Bli inte avskräckt, du måste älska dig själv som du är", result);
    }

    @Test
    public void userResult6Point() {
        // simulate 6 correct answer
        for(int i = 0; i <6; i++){
            counter.increase();
        }
        String result = counter.userResult();
        Assert.assertEquals("Detta är ett bra resultat. Du har fullständig kunskap inom området", result);
    }

    @Test
    public void userResult9Point() {
        // simulate 9 correct answer
        for(int i = 0; i <9; i++){
            counter.increase();
        }
        String result = counter.userResult();
        Assert.assertEquals("Grattis, du är expert på språkvetenskapen!", result);
    }
    @Test
    public void userResult0Point() {

        Assert.assertEquals("Du svarade på de flesta frågor felaktigt. Troligtvis blir du inte litteraturkritiker. " +
                "Bli inte avskräckt, du måste älska dig själv som du är", counter.userResult());
    }
    @Test
    public void userResult100Point() {
        for(int i = 0; i <100; i++){
            counter.increase();
        }
        Assert.assertEquals("Grattis, du är expert på språkvetenskapen!", counter.userResult());
    }



}