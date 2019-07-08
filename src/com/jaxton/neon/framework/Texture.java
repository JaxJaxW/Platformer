package com.jaxton.neon.framework;

import com.jaxton.neon.window.BufferedImageLoader;

import java.awt.image.BufferedImage;

public class Texture {

    SpriteSheet bs, ps;
    private BufferedImage block_sheet = null;
    private BufferedImage player_sheet = null;

    public BufferedImage[] block = new BufferedImage[2];
    public BufferedImage[] playerRight = new BufferedImage[7];
    public BufferedImage[] playerLeft = new BufferedImage[7];
    public BufferedImage[] playerJumpRight = new BufferedImage[3];
    public BufferedImage[] playerJumpLeft = new BufferedImage[3];




    public Texture() {
        BufferedImageLoader loader = new BufferedImageLoader();

        try {
            block_sheet = loader.loadImage("/block_sheet.png");
            player_sheet = loader.loadImage("/player_sheet.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

        bs = new SpriteSheet(block_sheet);
        ps = new SpriteSheet(player_sheet);

        getTextures();
    }

    private void getTextures() {
        int BLOCK_WIDTH = 32;
        int BLOCK_HEIGHT = 32;
        int AVATAR_WIDTH = 32;
        int AVATAR_HEIGHT = 64;

        // BLOCKS //
        block[0] = bs.grabImage(1, 1, BLOCK_WIDTH, BLOCK_HEIGHT); // Dirt Block
        block[1] = bs.grabImage(2, 1, BLOCK_WIDTH, BLOCK_HEIGHT); // Grass Block

        // PLAYER //
        for (int i = 0; i < 7; i++) {
            playerRight[i] = ps.grabImage(i,1, AVATAR_WIDTH, AVATAR_HEIGHT);
            playerLeft[i] = ps.grabImage(20-i, 1, AVATAR_WIDTH, AVATAR_HEIGHT);
        }
        for (int i = 0; i < 3; i++) {
            playerJumpRight[i] = ps.grabImage(i+7,2, AVATAR_WIDTH, AVATAR_HEIGHT);
            playerJumpLeft[i] = ps.grabImage(12-i, 1, AVATAR_WIDTH, AVATAR_HEIGHT);
        }
    }


}
