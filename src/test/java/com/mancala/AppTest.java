package com.mancala;

import com.mancala.pojo.Cup;
import com.mancala.pojo.NormalCup;
import com.mancala.pojo.Kalaha;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest 
{
    @Test
    public void fieldExists() throws Exception {
        NormalCup firstCup = new NormalCup();
        assertNotNull(firstCup.getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour());
    }

    @Test
    public void fieldExistsFirstKalaha() throws Exception {
        Cup firstCup = new NormalCup();
        Cup kalaha = firstCup.getNeighbour() //2
                .getNeighbour() //3
                .getNeighbour() //4
                .getNeighbour() //5
                .getNeighbour() //6
                .getNeighbour(); //7
        assertNotNull(kalaha);
        assertTrue(kalaha instanceof Kalaha);
    }
    @Test
    public void fieldExistsSecondKalaha() throws Exception {
        Cup firstCup = new NormalCup();
        Cup kalaha = firstCup.getNeighbour() //2
                .getNeighbour() //3
                .getNeighbour() //4
                .getNeighbour() //5
                .getNeighbour() //6
                .getNeighbour() //7
                .getNeighbour() //8
                .getNeighbour() //9
                .getNeighbour() //10
                .getNeighbour() //11
                .getNeighbour() //12
                .getNeighbour() //13
                .getNeighbour(); //14
        assertNotNull(kalaha);
        assertTrue(kalaha instanceof Kalaha);
    }

    @Test
    public void fieldIsRound() throws Exception {
        Cup firstCup = new NormalCup();
        Cup sameFirstCup = firstCup.getNeighbour() //2
                .getNeighbour() //3
                .getNeighbour() //4
                .getNeighbour() //5
                .getNeighbour() //6
                .getNeighbour() //7
                .getNeighbour() //8
                .getNeighbour() //9
                .getNeighbour() //10
                .getNeighbour() //11
                .getNeighbour() //12
                .getNeighbour() //13
                .getNeighbour() //14
                .getNeighbour(); //1
        assertNotNull(sameFirstCup);
        assertEquals(firstCup, sameFirstCup);
    }
    @Test
    public void testDoTurn() throws Exception {
    Cup firstCup = new NormalCup();
    ((NormalCup) firstCup).doTurn();
    Cup secondCup = firstCup.getNeighbour();
    Cup thirdCup = secondCup.getNeighbour();
    Cup fourthCup = thirdCup.getNeighbour();
    Cup fifthCup = fourthCup.getNeighbour();
    Cup sixthCup = fifthCup.getNeighbour();
    assertEquals(0,firstCup.getNumberOfStones());
    assertEquals(5,secondCup.getNumberOfStones());
    assertEquals(5,thirdCup.getNumberOfStones());
    assertEquals(5,fourthCup.getNumberOfStones());
    assertEquals(5,fifthCup.getNumberOfStones());
    assertEquals(4,sixthCup.getNumberOfStones());
    }

    @Test
    public void firstCupIs5AwayFromKalaha() throws Exception {
        Cup firstCup = new NormalCup();
        int numberOfCupsAwayFromKalaha = firstCup.numberOfCupsAwayFromKalaha();
        assertEquals(6,numberOfCupsAwayFromKalaha);
    }
}
