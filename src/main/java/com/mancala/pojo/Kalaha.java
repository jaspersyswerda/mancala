package com.mancala.pojo;

public class Kalaha extends Cup {

    private static final int NUMBEROFSTONES = 0;

    public Kalaha (Player player, int cupNumber, Cup firstCup) throws Exception {
        this.player = player;
        this.numberOfStones = NUMBEROFSTONES;
        this.cupNumber = cupNumber;

        if (nextCupNeedsToBeMade()){
            Player otherPlayer = new Player("Player2");
            this.neighbour = new NormalCup(otherPlayer, cupNumber + 1, firstCup);
        }

        else if (nextCupIsFirstCup()){
            this.neighbour = firstCup;
        }

        else {
            throw new Exception("unknown Kalaha!");
        }
    }

    private boolean nextCupIsFirstCup(){
       return getCupNumber() == 14;
    }

    private boolean nextCupNeedsToBeMade(){
        return getCupNumber() == 7;
    }

    @Override
    public void putStoneIn(int stonesToBeDistributed, Player playerDoingTurn) throws Exception {
        if (!getPlayer().equals(playerDoingTurn)){
            getNeighbour().putStoneIn(stonesToBeDistributed, playerDoingTurn);
        } else {
            this.numberOfStones++;
            stonesToBeDistributed--;
            if (stonesToBeDistributed > 0) {
                getNeighbour().putStoneIn(stonesToBeDistributed, playerDoingTurn);
            }
        }
    }

    @Override
    public int numberOfCupsAwayFromKalaha(){
        return 0;
    }

    protected void steal(){
        //stealing from Kalaha is not a thing
        return;
    }
}
