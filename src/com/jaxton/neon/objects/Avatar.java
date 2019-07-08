package com.jaxton.neon.objects;

import com.jaxton.neon.framework.GameObject;
import com.jaxton.neon.framework.ObjectId;
import com.jaxton.neon.framework.Texture;
import com.jaxton.neon.window.Game;
import com.jaxton.neon.window.Handler;

import java.awt.*;
import java.util.LinkedList;

public abstract class Avatar extends GameObject {

    private float width = 32, height = 64;
    private final float GRAVITY = 0.5f;
    private final float MAX_SPEED = 10;

    public float velX = 0, velY = 0;
    public boolean direction = true, walking = true, running = false, jumping = false, falling = true;

    public float getVelX() {
        return velX;
    }
    public float getVelY() {
        return velY;
    }
    public void setVelX(float velX) {
        this.velX = velX;
    }
    public void setVelY(float velY) {
        this.velY = velY;
    }

    public boolean isWalking() {
        return walking;
    }
    public boolean isRunning() {
        return running;
    }
    public boolean isJumping() {
        return jumping;
    }
    public boolean isFalling() {
        return falling;
    }

    public void setWalking(boolean walking) {
        this.walking = walking;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }
    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    private Handler handler;
    private Texture tex = Game.getInstance();
    private AvatarObject avatarObjects[];

    Avatar(float x, float y, Handler handler, ObjectId id) {
        super(x, y, id);
        this.handler = handler;

    public void tick(LinkedList<GameObject> object) {
        Gravity();
        Collision(object);
    }

    private void Gravity() {
        this.x += velX;
        this.y += velY;

        if (falling || jumping) {
            this.velY += GRAVITY;

            if (velY > MAX_SPEED) this.velY = MAX_SPEED;

        }
    }

    private void Collision(LinkedList<GameObject> object) {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getId() == ObjectId.Block) {

                //TOP COLLISION
                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    y = tempObject.getY() + height/2;
                    velY = 0;
                }

                //BOTTOM COLLISION
                if (getBounds().intersects(tempObject.getBounds())) {
                    y = tempObject.getY() - height;
                    velY = 0;
                    falling = false;
                    jumping = false;
                } else {
                    falling = true;
                }

                //RIGHT COLLISION
                if (getBoundsRight().intersects(tempObject.getBounds())) {
                    x = tempObject.getX() - width;
                }

                //LEFT COLLISION
                if (getBoundsLeft().intersects(tempObject.getBounds())) {
                    x = tempObject.getX() + width;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        if (direction) {
            if (walking) {
                g.drawImage(tex.playerRight[0], (int)x, (int)y,null);
            } else if (running) {
                g.drawImage(tex.playerRight[0], (int)x, (int)y,null);
            } else if (jumping) {
                g.drawImage(tex.playerJumpRight[0], (int)x, (int)y,null);
            } else {
                g.drawImage(tex.playerRight[0], (int)x, (int)y,null);
            }
        } else {
            if (walking) {
                g.drawImage(tex.playerLeft[0], (int)x, (int)y,null);
            } else if (running) {
                g.drawImage(tex.playerLeft[0], (int)x, (int)y,null);
            } else if (jumping) {
                g.drawImage(tex.playerJumpLeft[0], (int)x, (int)y,null);
            } else {
                g.drawImage(tex.playerRight[0], (int)x, (int)y,null);
            }
        }

          //COLLISION GRAPHICS//
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.pink);
        g2d.draw(eyeball());
        g.setColor(Color.red);
        g2d.draw(getBounds());
        g2d.draw(getBoundsLeft());
        g2d.draw(getBoundsRight());
        g2d.draw(getBoundsTop());
    }

    public Rectangle getBounds() {
        return new Rectangle((int) ((int)x+(width/2)-(width/2)/2), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
    }
    public Rectangle getBoundsTop() {
        return new Rectangle((int) ((int)x+(width/2)-(width/2)/2), (int)y, (int)width/2, (int)height/2);
    }
    public Rectangle getBoundsRight() {
        return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
    }
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
    }
    public Rectangle front() {
        return new Rectangle();
    }
    public Rectangle eyeball() {
        return new Rectangle();
    }

}
