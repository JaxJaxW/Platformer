package com.jaxton.neon.framework;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage image;
    public int height;
    public int width;

    public SpriteSheet(BufferedImage image) {
        this.image = image;
        this.height = image.getHeight();
        this.width = image.getWidth();
    }

    public BufferedImage grabImage(int col, int row, int width, int height) {

        BufferedImage img = image.getSubimage((col*width)-width, (row*height)-height, width, height);
        return img;
    }

}
