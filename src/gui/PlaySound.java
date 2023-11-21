package gui;

import javax.sound.sampled.*;
import java.io.File;

public class PlaySound {
    private static Clip clip;

    public static void playSound(String file, boolean enableSound) {
        if (enableSound) {
            try {
                while (isPlaying()) {
                    Thread.sleep(100);
                }
                AudioInputStream audioInputStream = AudioSystem
                        .getAudioInputStream(new File("../Assets/Sound/" + file + ".wav"));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
        }
    }

    public static void loopSound(String file, boolean enableSound) {
        if (enableSound) {
            try {
                while (isPlaying()) {
                    Thread.sleep(100);
                }
                Clip clip = AudioSystem.getClip();
                AudioInputStream audioInputStream = AudioSystem
                        .getAudioInputStream(new File("../Assets/Sound/" + file + ".wav"));
                clip.open(audioInputStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception ex) {
                System.out.println("Error with looping sound.");
                ex.printStackTrace();
            }
        }
    }

    public static boolean isPlaying() {
        return clip != null && clip.isRunning();
    }
}
