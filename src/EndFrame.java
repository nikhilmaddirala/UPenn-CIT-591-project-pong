import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * EndFrame is trigger when the win condition of the Pong game is met.
 * It displays the winner and allows user to navigate back to the starting frame.
 */
public class EndFrame extends JFrame implements ActionListener {

    /**
     * Constructor
     * @param winner
     */
    public EndFrame(String winner){
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

        // Game winner panel
        JPanel msgPnl = new JPanel(new BorderLayout());
        JLabel gameOver = new JLabel("Game over", SwingConstants.CENTER);
        gameOver.setFont(heading);
        JLabel instructions = new JLabel("The winner is " + winner + ".", SwingConstants.CENTER);
        instructions.setFont(defaultFont);
        msgPnl.add(gameOver, BorderLayout.PAGE_START);
        msgPnl.add(instructions, BorderLayout.PAGE_END);
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(msgPnl, constraints);

        // Button panel
        JPanel btnPnl = new JPanel();
        Button newGameBtn = new Button("New Game");
        newGameBtn.setFont(defaultFont);
        newGameBtn.addActionListener(this); // Add event listeners
        btnPnl.add(newGameBtn);
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(newGameBtn, constraints);

        setVisible(true);
    }

    /**
     * Closes current frame and opens the starting frame
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        new StartFrame().init();
        dispose();
    }
}
