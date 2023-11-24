package gui;

import javax.sound.sampled.*;
import java.io.File;
import java.io.InputStream;

public class PlaySound {
    private Clip clip;

    public void playSound(String file, boolean enableSound) {
        String path = "Assets/Sound/" + file + ".wav";
        java.net.URL audioURL = PlaySound.class.getClassLoader().getResource(path);

        if (enableSound) {
            if (audioURL != null) {
                try (InputStream audioStream = audioURL.openStream()) {
                    if (isPlaying()) {
                        stopSound();
                    }
                    AudioInputStream audioInputStream = AudioSystem
                            .getAudioInputStream(audioStream);
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } catch (Exception ex) {
                    System.out.println("Error with playing sound.");
                    ex.printStackTrace();
                }
            }
        }
    }

    public void loopSound(String file, boolean enableSound) {
        String path = "Assets/Sound/" + file + ".wav";

        java.net.URL audioURL = PlaySound.class.getClassLoader().getResource(path);

        if (enableSound) {
            if (audioURL != null) {
                try (InputStream audioStream = audioURL.openStream()) {
                    if (isPlaying()) {
                        stopSound();
                    }
                    AudioInputStream audioInputStream = AudioSystem
                            .getAudioInputStream(audioStream);
                    if (isPlaying()) {
                        stopSound();
                    }
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                } catch (Exception ex) {
                    System.out.println("Error with looping sound.");
                    ex.printStackTrace();
                }
            }
        }
    }

    public void stopSound() {
        if (clip != null) {
            clip.stop();
        }
    }

    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }
}
