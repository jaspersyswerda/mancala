package com.mancala.pojo;

public class NormalCup extends Cup {

    private static final int NUMBEROFSTONES = 4;

    public NormalCup() throws Exception {
        Player player = new Player("Player1");
        this.cupNumber = 1;
        this.player = player;
        this.numberOfStones = NUMBEROFSTONES;
        this.neighbour = new NormalCup(player, cupNumber + 1, this);
    }

    public NormalCup(Player player, int cupNumber, Cup firstCup) throws Exception {
        this.cupNumber = cupNumber;
        this.player = player;
        this.numberOfStones = NUMBEROFSTONES;

       if (neighbourIsKalaha()){
           this.neighbour = new Kalaha(player, cupNumber + 1, firstCup);
        }
        else {
           this.neighbour = new NormalCup(player,cupNumber + 1, firstCup);
       }
    }

    private boolean neighbourIsKalaha(){
        return NEIGHBOURISKALAHACUPNUMBER.contains(getCupNumber());
    }

    public void doTurn() throws Exception {
        int stonesToBeDistributed = getNumberOfStones();
        Player player = getPlayer();
        setNumberOfStones(0);
        if (stonesToBeDistributed > 0){
            getNeighbour().putStoneIn(stonesToBeDistributed, player);
        }
    }

    protected void steal() throws Exception {
        int numberOfCupsToKalaha = numberOfCupsAwayFromKalaha();
        Cup oppositeCup = getNeighbour(2*numberOfCupsToKalaha);

        oppositeCup.setNumberOfStones(getNumberOfStones() + oppositeCup.getNumberOfStones());
        this.setNumberOfStones(0);
    }

}
