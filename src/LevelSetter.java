import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelSetter extends JFrame implements ActionListener {
    private int width;
    private int height;
    private JButton easy;
    private JButton medium;
    private JButton hard;

    public LevelSetter(int width, int height) {
        this.width = width;
        this.height = height;

        //Todo: ADD SOME INSTRUCTIONAL TEXT

        easy = new JButton("EASY");
        medium = new JButton("MEDIUM");
        hard = new JButton("HARD");

        easy.addActionListener(this);
        medium.addActionListener(this);
        hard.addActionListener(this);

        add(easy);
        add(medium);
        add(hard);

        setLayout(new GridBagLayout());
        setVisible(true);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * Overriding action listener event handle to show game window after a click
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();

        switch (label) {
            case "EASY":
                // Create Table with easy parameters
                break;
            case "MEDIUM":
                // Create Table with medium parameters
                break;
            case "HARD":
                // Create Table with hard parameters
                break;
        }

        // Remove this window
        dispose();
    }
}
