import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SettingsFrame is the initial screen where a user will select game settings and launch the game window
 * with those settings applied
 */
public class SettingsFrame extends JFrame implements ActionListener {
    private ButtonGroup difficulty;
    private ButtonGroup numPlayers;

    private JRadioButton easy;
    private JRadioButton medium;
    private JRadioButton hard;


    private JRadioButton singlePlayer;
    private JRadioButton twoPlayer;

    private int selectedDifficulty;
    private int selectedNumPlayers;

    /**
     * Contructor for SettingsFrame
     */
    public SettingsFrame() {
        super("Pong");

        //TODO: ADD INSTRUCTIONS TEXT AND FIX LAYOUT

        // Defaults settings
        selectedDifficulty = 1; // 1 for easy
        selectedNumPlayers = 1; // 1 for single player



        // Radio buttons for difficulty selection
        difficulty = new ButtonGroup();
        easy = new JRadioButton("EASY", true); // default selections
        medium = new JRadioButton("MEDIUM", false);
        hard = new JRadioButton("HARD", false);
        difficulty.add(easy);
        difficulty.add(medium);
        difficulty.add(hard);

        // Radio buttons for selecting number of players
        numPlayers = new ButtonGroup();
        singlePlayer = new JRadioButton("Single Players", true); // default selection
        twoPlayer = new JRadioButton("Two Players", false);
        numPlayers.add(singlePlayer);
        numPlayers.add(twoPlayer);

        // Start button
        Button startBtn = new Button("Start");

        // Add event listeners
        startBtn.addActionListener(this);

        // Add components to layout
        add(singlePlayer);
        add(twoPlayer);
        add(easy);
        add(medium);
        add(hard);
        add(startBtn);


        // Frame info
        setSize(Pong.WIDTH, Pong.HEIGHT);
        setLayout(new GridLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Overriding action listener event handle to show game window after a click
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (easy.isSelected()) {
            selectedDifficulty = 1;
        } else if (medium.isSelected()) {
            selectedDifficulty = 2;
        } else {
            selectedDifficulty = 3;
        }

        if (singlePlayer.isSelected()) {
           selectedNumPlayers = 1;
        } else {
            selectedNumPlayers = 2;
        }

        new Table(selectedDifficulty, selectedNumPlayers);

        // Remove this window
        dispose();
    }

}
