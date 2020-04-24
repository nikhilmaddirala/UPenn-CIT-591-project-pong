import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * StartFrame is the initial screen where a user will select game settings and launch the game window
 * with those settings applied
 */
public class StartFrame extends JFrame implements ActionListener {

    private JRadioButton easy;
    private JRadioButton medium;
    private JRadioButton hard;

    private JRadioButton singlePlayer;
    private JRadioButton twoPlayer;

    /**
     * Constructor for StartFrame
     */
    public StartFrame() {
        super("Pong");
        //Fonts
        Font defaultFont = new Font("Courier", Font.PLAIN, 14);
        Font heading = new Font("Courier", Font.BOLD, 30);

        // Frame setup
        setSize(Pong.WIDTH, Pong.HEIGHT);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout constraints
        GridBagConstraints constraints = new GridBagConstraints();

        // Welcome panel
        JPanel welcomePnl = new JPanel(new BorderLayout());
        JLabel welcome = new JLabel("Welcome to Pong!", SwingConstants.CENTER);
        welcome.setFont(heading);
        JLabel instructions = new JLabel("Make your game selections and press Start to play.", SwingConstants.CENTER);
        instructions.setFont(defaultFont);
        welcomePnl.add(welcome, BorderLayout.PAGE_START);
        welcomePnl.add(instructions, BorderLayout.PAGE_END);
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(welcomePnl, constraints);

        // Radio buttons for game mode
        JPanel modePnl = new JPanel();
        ButtonGroup mode = new ButtonGroup();
        singlePlayer = new JRadioButton("Single Player", true); // default selection
        twoPlayer = new JRadioButton("Two Player", false);
        mode.add(singlePlayer);
        mode.add(twoPlayer);
        mode.getElements().asIterator().forEachRemaining(btn -> btn.setFont(defaultFont));
        modePnl.add(singlePlayer);
        modePnl.add(twoPlayer);
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(modePnl, constraints);

        // Radio buttons for difficulty selection
        JPanel difficultyPnl = new JPanel();
        ButtonGroup difficulty = new ButtonGroup();
        easy = new JRadioButton("Easy", true); // default selections
        medium = new JRadioButton("Medium", false);
        hard = new JRadioButton("Hard", false);
        difficulty.add(easy);
        difficulty.add(medium);
        difficulty.add(hard);
        difficulty.getElements().asIterator().forEachRemaining(btn -> btn.setFont(defaultFont));
        difficultyPnl.add(easy);
        difficultyPnl.add(medium);
        difficultyPnl.add(hard);
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(difficultyPnl, constraints);


        // Start button
        JPanel startPnl = new JPanel();
        Button startBtn = new Button("Start");
        startBtn.setFont(defaultFont);
        startBtn.addActionListener(this); // Add event listeners
        startPnl.add(startBtn);
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(startBtn, constraints);
    }

    /**
     * Display the window
     */
    public void init() {
        setVisible(true);
    }

    /**
     * Overriding action listener event handle to dismiss current window and show game window after a click
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (easy.isSelected()) {
            Level.setDifficulty(Level.EASY);
        } else if (medium.isSelected()) {
           Level.setDifficulty(Level.MEDIUM);
        } else if (hard.isSelected()){
            Level.setDifficulty(Level.HARD);
        }

        if (singlePlayer.isSelected()) {
            Level.setMode(Level.SINGLE_PLAYER);
        } else if (twoPlayer.isSelected()) {
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
