package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PlaySprite {
    private BufferedImage spriteSheet;
    private BufferedImage[] sprites;
    private int frame = 0;

    public PlaySprite(String spriteSheetPath, double spriteWidth, double spriteHeight, int spriteCount) { // 40 45 21
        try {
            spriteSheet = ImageIO.read(new File(spriteSheetPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        sprites = new BufferedImage[spriteCount];

        for (int i = 0; i < spriteCount; i++) {
            sprites[i] = spriteSheet.getSubimage((int) (i * spriteWidth), 0, (int) spriteWidth, (int) spriteHeight);
        }
    }

    public BufferedImage getNextSprite() {
        frame = (frame + 1) % sprites.length;
        return sprites[frame];
    }
}