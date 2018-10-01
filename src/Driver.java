/*
    NFL Draft by Kenia Rioja-Naranjo
    CSC 311 Project 1
    Due October 2, 2018
 */

public class Driver {

    public static void main(String[] args) {

        System.out.println("WELCOME TO THE 2018 NFL DRAFT\n");

        ArrayList<Team> teamArrayList = PopulateArray.teams();

        ArrayList<ArrayList<String>> roundsArrayList = PopulateArray.roundPicksPlayers();

        PopulateArray.printOrderOfWinsPercentage(teamArrayList);

        PopulateArray.draft(teamArrayList, roundsArrayList);

    }
}
