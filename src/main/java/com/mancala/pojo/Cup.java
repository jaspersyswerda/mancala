package com.mancala.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Cup {
    protected static final int NUMBEROFCUPSFOREACHPLAYER = 6;
    protected static final List<Integer> NEIGHBOURCUPNUMBERISKALAHA = new ArrayList<>(Arrays.asList(NUMBEROFCUPSFOREACHPLAYER,2* NUMBEROFCUPSFOREACHPLAYER +1));
    protected Player player;
    protected int cupNumber;
    protected int numberOfStones;
    protected Cup neighbour;
    protected Cup firstCup;

    public int getCupNumber() {
        return cupNumber;
    }

    public int getNumberOfStones() {
        return numberOfStones;
    }

    public void setNumberOfStones(int numberOfStones) {
        this.numberOfStones = numberOfStones;
    }

    public Player getPlayer() {
        return player;
    }

    public Cup getNeighbour() {
        return neighbour;
    }

    public Cup getNeighbour(int number) throws Exception {
        if (number < 1){
            throw new Exception("Number must be 1 or more");
        }
        else if (number == 1){
            return getNeighbour();
        }
        else {
            return getNeighbour(number - 1);
        }
    }

    public Cup getFirstCup() {
        return firstCup;
    }

    public void putStoneIn(int stonesToBeDistributed, Player playerDoingTurn) throws Exception {
        this.numberOfStones++;
        stonesToBeDistributed--;
        if (stonesToBeDistributed > 0){
            getNeighbour().putStoneIn(stonesToBeDistributed, playerDoingTurn);
        }
        if (!playerDoingTurn.equals(this.getPlayer()) && this.getNumberOfStones() == 1){
            steal();
        }
    }

    public int numberOfCupsAwayFromKalaha(){
        int numberOfCups = 0;
        return numberOfCupsAwayFromKalaha(numberOfCups);
    }

    private int numberOfCupsAwayFromKalaha(int numberOfCups){
        if (getNeighbour() instanceof Kalaha){
            return numberOfCups+1;
        }
        else {
            return getNeighbour().numberOfCupsAwayFromKalaha(numberOfCups+1);
        }
    }

    protected abstract void steal() throws Exception;

}
