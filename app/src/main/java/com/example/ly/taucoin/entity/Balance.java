package com.example.ly.taucoin.entity;

public class Balance {
    /**
     * "code": "0",
       "message": "success",
       "ret":

           {
            "coins": "1000",
            "utxo": "900",
            "reward": "100"
           }
     */
    private int coins;
    private int utxo;
    private int reward;

    public Balance(int coins, int utxo, int reward) {
        this.coins = coins;
        this.utxo = utxo;
        this.reward = reward;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getUtxo() {
        return utxo;
    }

    public void setUtxo(int utxo) {
        this.utxo = utxo;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }




    @Override
    public String toString() {
        return "Balance{" +
                "coins=" + coins +
                ", utxo=" + utxo +
                ", reward=" + reward +
                '}';
    }

}
