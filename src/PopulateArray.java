/*
    NFL Draft by Kenia Rioja-Naranjo
    CSC 311 Project 1
    Due October 2, 2018

    This file contains code referenced from https://www.programcreek.com/2012/11/quicksort-array-in-java/
 */

import java.text.DecimalFormat;
import java.util.Random;

public class PopulateArray {

    public static ArrayList<Team> teams() {
        ArrayList<Team> teamsArray = new ArrayList<>(8);

        teamsArray.add(new Team("New England Patriots", randWP()));
        teamsArray.add(new Team("Baltimore Ravens", randWP()));
        teamsArray.add(new Team("Jacksonville Jaguars", randWP()));
        teamsArray.add(new Team("Los Angeles Chargers", randWP()));
        teamsArray.add(new Team("Washington Redskins", randWP()));
        teamsArray.add(new Team("Tampa Bay Buccaneers", randWP()));
        teamsArray.add(new Team("Seattle Seahawks", randWP()));
        teamsArray.add(new Team("San Francisco 49ers", randWP()));

        quickSort(teamsArray, 0, teamsArray.getSize() - 1);

        return teamsArray;
    }


    private static void quickSort(ArrayList<Team> arr, int low, int high) {
        //Referenced from https://www.programcreek.com/2012/11/quicksort-array-in-java/

        if (arr == null || arr.getSize() == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        double pivot = arr.get(middle).getWinPercentage();

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr.get(i).getWinPercentage() < pivot) {
                i++;
            }

            while (arr.get(j).getWinPercentage() > pivot) {
                j--;
            }

            if (i <= j) {
                Team temp = arr.get(i);
                arr.set(arr.get(j), i); //arr[i] = arr[j];
                arr.set(temp, j); //arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }


    public static ArrayList<ArrayList<String>> roundPicksPlayers() {
        ArrayList<ArrayList<String>> roundsArray = new ArrayList<>(4);

        roundsArray.add(new ArrayList<String>(8));
        roundsArray.add(new ArrayList<String>(8));
        roundsArray.add(new ArrayList<String>(8));
        roundsArray.add(new ArrayList<String>(8));


        ArrayList<String> playersToBeDrafted = new ArrayList<>(32);
        playersToBeDrafted.add("Aaron Rodgers");
        playersToBeDrafted.add("Tom Brady");
        playersToBeDrafted.add("Julio Jones");
        playersToBeDrafted.add("Khalil Mack");
        playersToBeDrafted.add("Von Miller");
        playersToBeDrafted.add("Le’Veon Bell");
        playersToBeDrafted.add("Eric Berry");
        playersToBeDrafted.add("Luke Kuechly");

        playersToBeDrafted.add("Aaron Donald");
        playersToBeDrafted.add("J.J. Watt");
        playersToBeDrafted.add("Tyron Smith");
        playersToBeDrafted.add("Ezekiel Elliott");
        playersToBeDrafted.add("A.J. Green");
        playersToBeDrafted.add("Matt Ryan");
        playersToBeDrafted.add("Antonio Brown");
        playersToBeDrafted.add("Ben Roethlisberger");

        playersToBeDrafted.add("Rob Gronkowski");
        playersToBeDrafted.add("Odell Beckham Jr.");
        playersToBeDrafted.add("Sean Lee");
        playersToBeDrafted.add("Russell Wilson");
        playersToBeDrafted.add("Patrick Peterson");
        playersToBeDrafted.add("Drew Brees");
        playersToBeDrafted.add("Richard Sherman");
        playersToBeDrafted.add("Geno Atkins");

        playersToBeDrafted.add("Marcus Peters");
        playersToBeDrafted.add("Zack Martin");
        playersToBeDrafted.add("David Johnson");
        playersToBeDrafted.add("Derek Carr");
        playersToBeDrafted.add("Landon Collins");
        playersToBeDrafted.add("Andrew Luck");
        playersToBeDrafted.add("Joe Thomas");
        playersToBeDrafted.add("Earl Thomas");


        for (int i = 0; i < playersToBeDrafted.getSize(); i++) {
            int round = randIntegerInRange(1, 4);

            while (roundsArray.get(round - 1).getSize() == 8) {
                round  = randIntegerInRange(1, 4);
            }

            roundsArray.get(round - 1).add(playersToBeDrafted.get(i));
        }

        //PRINT ROUND PICKS
        for (int i = 0; i < roundsArray.getSize(); i++) {
            System.out.println("Round " + (i + 1) + " Picks:");

            for (int j = 0; j < roundsArray.get(i).getSize(); j++) {
                System.out.println("     " + roundsArray.get(i).get(j));
            }
            System.out.println();
        }

        return roundsArray;
    }

    public static void draft(ArrayList<Team> draftOrder, ArrayList<ArrayList<String>> roundsOfPlayers) {
        for (int r = 0; r < roundsOfPlayers.getSize(); r++) {

            System.out.println("Round " + (r + 1) + " Picks:");

            for (int t = 0; t < draftOrder.getSize(); t++) {
                int pick = randIntegerInRange(0, roundsOfPlayers.get(r).getSize() - 1);
                String playerName = roundsOfPlayers.get(r).remove(pick);
                draftOrder.get(t).addPlayerPick(playerName);

                System.out.println("   " + draftOrder.get(t).getName() + " select " + playerName);
            }

            System.out.println();
        }
    }

    public static void printOrderOfWinsPercentage(ArrayList<Team> teams) {
        System.out.println("Order of 2018 Draft: ");
        DecimalFormat df = new DecimalFormat("0.00");
        for (int i = 0; i < teams.getSize(); i++) {
            System.out.println("   " + (i + 1) + ". " + teams.get(i).getName() + " won "
                    + df.format(teams.get(i).getWinPercentage() * 100) + "% of their games last season");
        }
        System.out.println();
    }

    private static int randIntegerInRange(int min, int max) {
        //min and max inclusive
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static double randWP() {
        //double min = 0.000, max = 1.000;
        Random r = new Random();
        return Math.floor(r.nextDouble() * 1000) / 1000;
    }
}