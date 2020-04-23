import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffect {

    public static void blip() {
        play("./sounds/blip.wav");

    }

    public static void ding() {
        play("./sounds/ding.wav");
    }

    private static void play(String filePath) {
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

            try {
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
}