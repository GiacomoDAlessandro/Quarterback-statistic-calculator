///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Passer Rating Calculator
//
// Author:          Giacomo D'Alessandro
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//No help received
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.Scanner;
import java.util.ArrayList;
/**
 * The H10CustomApp takes in input from the user about a player's passing statistics, and after
 * it takes in these statistics, it makes sure they are all correct and not negative, non
 * integers, etc. After this it calls different methods to calculate different advanced passing
 * statistics that will help calculate the passer rating of the player's performance.
 * <p>Bugs: None
 *
 * @author Giacomo D'Alessandro
 */
public class H10CustomApp {
    /**
     * This method takes all the input for the passing statistics of the player, and validates
     * all the input. It makes sure that the input makes sense in football terms (less
     * completions than passing attempts, etc.), checks that the input is positive, if there is
     * input, and if the input is an integer. After it checks that, it adds the input to the
     * array passingStats.
     * @param args none
     * @return none
     */
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        ArrayList<String> questions = new ArrayList<>();
        int[] passingStats = new int[5];
        double[] passerRatingStats = new double[5];
        ArrayList<String> passingStatsDisplay = new ArrayList<>();
        ArrayList<String> advancedpassingStatsDisplay = new ArrayList<>();


        questions.add("How many completions did the quarterback complete?");
        questions.add("How many attempts did that quarterback throw?");
        questions.add("How many passing yards did your quarterback throw for?");
        questions.add("How many interceptions did your quarterback throw?");
        questions.add("How many passing touchdowns did your quarterback throw?");

        for (int i = 0; i < passingStats.length; i++) {
            System.out.println(questions.get(i));
            if (scnr.hasNextInt()) {
                passingStats[i] = scnr.nextInt();
                if (passingStats[i] < 0) {
                    System.out.println("Invalid input, defaulted to 0");
                    passingStats[i] = 0;
                } else {
                    if (i == 2) {
                        if (passingStats[0] > passingStats[1]) {
                            System.out.println("Invalid input, defaulted to 0");
                            passingStats[i] = 0;
                        }
                    } else if (i == 3) {
                        if (passingStats[3] > passingStats[1] - passingStats[0]) {
                            System.out.println("Invalid input, defaulted to 0");
                            passingStats[i] = 0;
                        }
                    } else if (i == 4) {
                        if (passingStats[4] > passingStats[0]) {
                            System.out.println("Invalid input, defaulted to 0");
                            passingStats[i] = 0;
                        }
                    }
                }

            } else {
                System.out.println("Invalid input, defaulted to 0");
                    passingStats[i] = 0;
                    if (scnr.hasNext()) {
                        scnr.next();
                    }
                }
            }
        passingStatsDisplay.add("Passing Completions: " + passingStats[0]);
        passingStatsDisplay.add("Passing Attempts: " + passingStats[1]);
        passingStatsDisplay.add("Passing Yards: " + passingStats[2]);
        passingStatsDisplay.add("Passing Interceptions: " + passingStats[3]);
        passingStatsDisplay.add("Passing Touchdowns: " + passingStats[4]);

        for (int i = 0; i < passingStatsDisplay.size(); i++) {
            System.out.println(passingStatsDisplay.get(i));
        }

        advancedpassingStatsDisplay.add
                ("Completion percentage: " + calcAdvancedPassingStats(passingStats)[0] + "%");
        advancedpassingStatsDisplay.add
                ("Pass yards per attempt: " + calcAdvancedPassingStats(passingStats)[1]);
        advancedpassingStatsDisplay.add
                ("Interceptions per attempt: " + calcAdvancedPassingStats(passingStats)[2]);
        advancedpassingStatsDisplay.add
                ("Touchdowns per attempt: " + calcAdvancedPassingStats(passingStats)[3]);

        for (int i = 0; i < advancedpassingStatsDisplay.size(); i++) {
            System.out.println(advancedpassingStatsDisplay.get(i));
        }
        if (!(passingStats[1] <= 0)) {
            System.out.println("Passer Rating: " +
                    calcPasserRating(calcAdvancedPassingStats(passingStats)));
        } else {
            System.out.println("Passer Rating: 0");
        }

        scnr.close();
    }

    /**
     * This method takes the passing stats that the user input and calculates the advanced
     * passing statistics of the player based off those numbers. It checks if the array
     * PassingStats is null, and if it is, advanced passing Stats is returned with all elements
     * as 0. Also checks if the passing Attempts is 0, so if the passing attempts are 0, all
     * advanced passing stats are 0, so nothing is divided by 0.
     * @param passingStats Passing Statistics that the user inputted
     * @return advancedPassingStats which is the advanced passing stats accoridng to the
     * statistics that the user input
     */
    public static double[] calcAdvancedPassingStats(int[] passingStats) {
        double[] advancedPassingStats = new double[4];
        if (passingStats == null) {
            for (int i = 0; i < advancedPassingStats.length; i++) {
                advancedPassingStats[i] = 0;
            }
            return advancedPassingStats;
        } else if (passingStats[1] <= 0) {
            for (int i = 0; i < advancedPassingStats.length; i++) {
                advancedPassingStats[i] = 0;
            }
            return advancedPassingStats;
        }

            if (passingStats[1] != 0) {
                advancedPassingStats[0] =
                        Math.round(((double) passingStats[0] / passingStats[1] * 100) * 10.0) / 10.0;
                advancedPassingStats[1] =
                        Math.round(((double) passingStats[2] / passingStats[1] )* 10.0) / 10.0;
                advancedPassingStats[2] =
                        Math.round(((double) passingStats[3] / passingStats[1]) * 10.0) / 10.0;
                advancedPassingStats[3] =
                        Math.round(((double) passingStats[4] / passingStats[1]) * 10.0) / 10.0;
            }
        return advancedPassingStats;
    }



    /**
     * This method takes the advancedPassingStats from calcAdvancedPassingStats and uses those
     * statistics to calculate the passer rating of the player with the stats that the user input
     * . This method also makes sure that if all the advanced stats are 0, the passer rating will
     * be 0.
     * @param advancedPassingStats the advanced passing statistics that are needed to calculate
     * the passer Rating that come from the user's input
     * @return passerRating, the passer rating calculated based off of the User's input
     */
    public static double calcPasserRating(double[] advancedPassingStats) {
        double[] passerRatingnumbers = new double[4];
        passerRatingnumbers[0] = ((advancedPassingStats[0] / 100) - 0.3) * 5;
        passerRatingnumbers[1] = ((advancedPassingStats[1] - 3) * 0.25);
        passerRatingnumbers[2] = 2.375 - (advancedPassingStats[2]) * 25;
        passerRatingnumbers[3] = advancedPassingStats[3] * 20;

        if (passerRatingnumbers[0] > 2.375) {
            passerRatingnumbers[0] = 2.375;
        } else if (passerRatingnumbers[0] < 0) {
            passerRatingnumbers[0] = 0;
        }
        if (passerRatingnumbers[1] > 2.375) {
            passerRatingnumbers[1] = 2.375;
        } else if (passerRatingnumbers[1] < 0) {
            passerRatingnumbers[1] = 0;
        }
        if (passerRatingnumbers[2] > 2.375) {
            passerRatingnumbers[2] = 2.375;
        } else if (passerRatingnumbers[2] < 0) {
            passerRatingnumbers[2] = 0;
        }
        if (passerRatingnumbers[3] > 2.375) {
            passerRatingnumbers[3] = 2.375;
        } else if (passerRatingnumbers[3] < 0) {
            passerRatingnumbers[3] = 0;
        }
        double sum = 0.0;
        for (int i = 0; i < passerRatingnumbers.length; i++) {
            sum = sum + passerRatingnumbers[i];
        }

        sum = (sum / 6.0) * 100;
        if (sum > 158.3) {
            sum = 158.3;
        }
        boolean index = true;
        if (index) {
            for (int i = 0; i <advancedPassingStats.length; i++) {
                if (advancedPassingStats[i] != 0) {
                    index = false;
                    break;
                }
            }
            if (index) {
                sum = 0;
                index = false;
            }
        }
        sum = (Math.round(sum * 100.0) / 100.0);
        return sum;
    }
}
