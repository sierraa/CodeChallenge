import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sierra on 7/12/2016.
 */
public class GameDisplay {
    Game game;
    int userChoice = -1;
    String displayMessage = "Choose your weapon and prepare for battle!";
    String scoreMessage = "You: %d Computer: %d";
    String helpMessage = "Scissors cuts paper and decapitates lizard.\n" +
            "Paper covers rock and disproves Spock.\n" +
            "Rock crushes scissors and lizard.\n" +
            "Lizard eats paper and poisons Spock.\n" +
            "Spock smashes scissors and vaporizes rock.\n";

    JTextArea textDisplay;
    JTextArea scoreDisplay;
    JFrame window;

    /**
     * Set up the display for the game
     */
    public GameDisplay() {
        game = new Game();
        window = new JFrame("Rock-paper-scissors-lizard-Spock");
        window.setSize(500, 500);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel playPanel = new JPanel();
        JPanel topPanel = new JPanel();

        JButton rockButton = new JButton("Rock");
        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUserChoice(0);
                play();
            }
        });

        JButton paperButton = new JButton("Paper");
        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUserChoice(1);
                play();
            }
        });

        JButton scissorsButton = new JButton("Scissors");
        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUserChoice(2);
                play();
            }
        });

        JButton lizardButton = new JButton("Lizard");
        lizardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUserChoice(4);
                play();
            }
        });

        JButton spockButton = new JButton("Spock");
        spockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUserChoice(3);
                play();
            }
        });

        playPanel.add(rockButton);
        playPanel.add(paperButton);
        playPanel.add(scissorsButton);
        playPanel.add(lizardButton);
        playPanel.add(spockButton);

        textDisplay = new JTextArea(displayMessage);
        scoreDisplay = new JTextArea(String.format(scoreMessage, game.getMyScore(), game.getComputerScore()));

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.resetScore();
                updateScore();
                textDisplay.setText(displayMessage);
            }
        });

        JButton helpButton = new JButton("Help");
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textDisplay.setText(helpMessage + "\n\n" + displayMessage);
            }
        });

        topPanel.add(helpButton);
        topPanel.add(resetButton);
        topPanel.add(scoreDisplay);

        mainPanel.add(topPanel, BorderLayout.PAGE_START);
        mainPanel.add(textDisplay, BorderLayout.CENTER);
        mainPanel.add(playPanel, BorderLayout.PAGE_END);

        window.add(mainPanel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    private void play() {
        // activated each time a button is pressed
        if (userChoice != -1) {
            String result = game.play(userChoice);
            textDisplay.setText(result);
            updateScore();
        }
    }

    private void updateScore() {
        scoreDisplay.setText(String.format(scoreMessage, game.getMyScore(), game.getComputerScore()));
    }

    private void setUserChoice(int i) {
        userChoice = i;
    }
}
