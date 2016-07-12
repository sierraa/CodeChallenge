import java.util.Random;

/**
 * Created by Sierra on 7/12/2016.
 */
public class Game {

    private int computerScore = 0;
    private int myScore = 0;

    private static final String[] choices = {"rock", "paper", "scissors", "Spock", "lizard"};

    /**
     * The heart of the game. Matches user choice against computer choice
     * @param userChoice - integer representing the user choice
     * @return String displaying the outcome of the battle.
     */
    public String play(int userChoice) {
        int computerChoice = randomChoice();
        int result = Math.abs(userChoice - computerChoice) % 5;
        System.out.println(result);
        if (result == 2 || result == 4) { // user wins
            myScore++;
            return String.format("You win. %S beats %S!", choices[userChoice], choices[computerChoice]);
        } else if (result == 1 || result == 3) {
            computerScore++;
            return String.format("You lose. %S beats %S!", choices[computerChoice], choices[userChoice]);
        } else {
            return String.format("You both chose %S! It's a tie!", choices[computerChoice]);
        }
    }

    public int getMyScore() {
        return myScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    private int randomChoice() {
        Random rand = new Random();
        int index = rand.nextInt(5);
        return index;
    }


}
