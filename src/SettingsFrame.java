import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SettingsFrame is the initial screen where a user will select game settings and launch the game window
 * with those settings applied
 */
public class SettingsFrame extends JFrame implements ActionListener {

    private JRadioButton easy;
    private JRadioButton medium;
    private JRadioButton hard;


    private JRadioButton singlePlayer;
    private JRadioButton twoPlayer;


    /**
     * Constructor for SettingsFrame
     */
    public SettingsFrame() {
        super("Pong");

        //TODO: ADD INSTRUCTIONS TEXT AND FIX LAYOUT
        //TODO: Initial Load is pretty slow, see if that's fixable

        // Radio buttons for difficulty selection
        ButtonGroup difficulty = new ButtonGroup();
        easy = new JRadioButton("EASY", true); // default selections
        medium = new JRadioButton("MEDIUM", false);
        hard = new JRadioButton("HARD", false);
        difficulty.add(easy);
        difficulty.add(medium);
        difficulty.add(hard);

        // Radio buttons for selecting number of players
        ButtonGroup mode = new ButtonGroup();
        singlePlayer = new JRadioButton("Single Players", true); // default selection
        twoPlayer = new JRadioButton("Two Players", false);
        mode.add(singlePlayer);
        mode.add(twoPlayer);

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Display the frame window
     */
    public void init() {
        setVisible(true);
    }

    /**
     * Overriding action listener event handle to show game window after a click
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //easy is the default level so it does not need to be checked
        if (medium.isSelected()) {
           Level.setDifficulty(Level.MEDIUM);
        } else if (hard.isSelected()){
            Level.setDifficulty(Level.HARD);
        }

        //single player is the default mode so it does not need to be checked
        if (twoPlayer.isSelected()) {
            Level.setMode(Level.TWO_PLAYER);
        }

        //create a table instance
        Pong pong = new Pong();

        try {
            pong.execute();
        } catch (Exception ev) {
            ev.printStackTrace();
        }

        // Remove this window
        dispose();
    }

}
