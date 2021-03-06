package com.jaxton.neon.framework;

import com.jaxton.neon.window.Handler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getId() == ObjectId.Player) {
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5);
                    handler.objects. = true;
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(-5);

                }
                if (key == KeyEvent.VK_RIGHT) {tempObject.setVelX(5);}
                if (key == KeyEvent.VK_LEFT) {tempObject.setVelX(-5);}
                if (key == KeyEvent.VK_SPACE && !tempObject.isJumping()) {
                    tempObject.setJumping(true);
                    tempObject.setVelY(-15);
                }
            }
        }

        if(key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getId() == ObjectId.Player) {
                if (key == KeyEvent.VK_SPACE) tempObject.setVelY(0);
                if (key == KeyEvent.VK_D) tempObject.setVelX(0);
                if (key == KeyEvent.VK_A) tempObject.setVelX(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
            }
        }
    }

}
