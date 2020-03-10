package edu.cscc;
import java.util.Random;

//Test line to test commit.

/**
 * This class provides the methods and static fields for the RPSLSpock game.
 * The methods include one to see if the human player's pick is valid,
 * what the computer's pick will be, and if the computer has won the game.
 * @author Bret Etling
 * @version 0.1
 * 
 */
public class RPSLSpock {

    static Random rand = new Random(System.currentTimeMillis());

    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "scissors";
    public static final String LIZARD = "lizard";
    public static final String SPOCK = "spock";

    /**
     * This method take's a given String and determines if it's valid to the context of the game,
     * and returns a boolean value in response.
     * @param pick (h_pick in Main) is a String that is tested in the method to see if it's a valid answer.
     * @return Returns a boolean value representing if the human pick is valid or not.
     */
    public static boolean isValidPick(String pick) {
        if (pick == null) {
            return false;
        }
        pick = pick.trim();
        return (ROCK.equalsIgnoreCase(pick) ||
                PAPER.equalsIgnoreCase(pick) ||
                SCISSORS.equalsIgnoreCase(pick) ||
                LIZARD.equalsIgnoreCase(pick) ||
                SPOCK.equalsIgnoreCase(pick));
    }

    /**
     * This method uses a random number generator and a switch statement to select a String pick for the computer.
     * @return The computer's randomly generated pick(c_pick in Main) as a String.
     */
    public static String generatePick() {
        String pick = null;
        switch (rand.nextInt(5)) {
            case 0:
                pick = ROCK;
                break;
            case 1:
                pick = PAPER;
                break;
            case 2:
                pick = SCISSORS;
                break;
            case 3:
                pick = LIZARD;
                break;
            case 4:
                pick = SPOCK;
                break;
        }
        return pick;
    }

    /**
     * This method determines if the computer's pick beats the human player's pick.
     * @param c_pick (The computer's pick) to be compared to h_pick to see who won.
     * @param h_pick (The human player's pick) to be compared to c_pick to see who won.
     * @return A boolean value representing if the computer has won.
     */
    public static boolean isComputerWin(String c_pick,String h_pick) {
        h_pick = h_pick.toLowerCase();
        return ((ROCK.equals(c_pick) && (SCISSORS.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (PAPER.equals(c_pick) && (ROCK.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SCISSORS.equals(c_pick) && (PAPER.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (LIZARD.equals(c_pick) && (PAPER.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SPOCK.equals(c_pick) && (ROCK.equals(h_pick) || SCISSORS.equals(h_pick))));
    }
}