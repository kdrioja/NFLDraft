/*
    NFL Draft by Kenia Rioja-Naranjo
    CSC 311 Project 1
    Due October 2, 2018
 */

import java.text.DecimalFormat;

public class Team {
    private String name;
    private double winPercentage;
    private ArrayList<String> playerPicks;

    public Team(String name, double winPercentage) {
        this.name = name;
        this.winPercentage = winPercentage;
        this.playerPicks = new ArrayList<>(4);
    }

    public void addPlayerPick(String playerName) {
        if (this.playerPicks.getSize() != 4) {
            this.playerPicks.add(playerName);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWinPercentage() {
        return (winPercentage * 1000) / 1000;
    }

    public void setWinPercentage(double winPercentage) {
        this.winPercentage = winPercentage;
    }

    public ArrayList<String> getPlayerPicks() {
        return playerPicks;
    }

    public void setPlayerPicks(ArrayList<String> playerPicks) {
        this.playerPicks = playerPicks;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.000");
        return this.name + " (" + df.format(this.winPercentage) + ")";
    }
}