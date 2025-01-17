///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Passer Rating Calculator test methods
// Course:          CS 200, Fall, 2024
//
// Author:          Giacomo D'Alessandro
// Email:           gdalessandro@wisc.edu
// Lecturer's Name: Andrew Kuemmel
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//No help received
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

/**
 * This contains testing methods for the H10CustomApp class.
 *
 * @author Giacomo D'Alessandro
 */
public class TestH10CustomApp {

    /**
     * This calls the testH10CustomApp method and prints out the result.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args)
    {
        System.out.println("Success: " + testH10CustomApp());
    }

    /**
     * This has various test cases that call the app methods to verify they work according to the
     * descriptions in the app method header comments.  If all the test cases pass, then true is
     * returned, otherwise false. This method is called by a zyBooks test. Note the latest, highest
     * scoring submission will be the one that is human graded.
     *
     * @return true when all test cases pass, false otherwise.
     */
    public static boolean testH10CustomApp() {

        //Checks if my method rounds the passer rating correctly
        {
            int[] passingStats = {15, 23, 228, 1, 3};
            double expected = 119.2;
            double actual = H10CustomApp.calcPasserRating
                    (H10CustomApp.calcAdvancedPassingStats(passingStats));
            if (!(Math.abs(actual - expected) < .00001)) {
                System.out.println("exampleSum1) Expected: " + expected + " actual: " + actual);
                return false;
            }
        }
        // Checks how my method handles negative attempt input.
        {
            int[] passingStats = {20, -12, 4, 2, 3};
            double expected = 0;
            double actual = H10CustomApp.calcPasserRating
                    (H10CustomApp.calcAdvancedPassingStats(passingStats));
            if (!(Math.abs(actual - expected) < .00001)) {
                System.out.println("exampleSum1) Expected: " + expected + " actual: " + actual);
                return false;
            }
        }
        //Checks how my method handles null input
        {
            int[] passingStats = null;
            double expected = 0;
            double actual = H10CustomApp.calcPasserRating
                    (H10CustomApp.calcAdvancedPassingStats(passingStats));
            if (!(Math.abs(actual - expected) < .00001)) {
                System.out.println("exampleSum1) Expected: " + expected + " actual: " + actual);
                return false;
            }
        }
        //Checks how my method handles a perfect passer rating, if it rounds to 158.3
        {
            int[] passingStats = {20, 22, 320, 0, 4};
            double expected = 158.3;
            double actual =
                    H10CustomApp.calcPasserRating
                            (H10CustomApp.calcAdvancedPassingStats(passingStats));
            if (!(Math.abs(actual - expected) < .00001)) {
                System.out.println("exampleSum1) Expected: " + expected + " actual: " + actual);
                return false;
            }
        }
        return true;
    }
}
