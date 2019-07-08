package com.jaxton.neon.window;

import java.awt.Graphics;
import java.util.LinkedList;
import com.jaxton.neon.framework.*;
import com.jaxton.neon.objects.Avatar;
import com.jaxton.neon.objects.Block;

public class Handler {

    public LinkedList<LinkedList<GameObject>> objects = new LinkedList<>();
    public LinkedList<Block> blocks = new LinkedList<>();
    public LinkedList<Avatar> avatars = new LinkedList<>();
    private GameObject tempObject;

    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            tempObject = objects.get(i);
            tempObject.tick(objects);
        }

    }

    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            tempObject = objects.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        if (object.getId() == ObjectId.Block) {
            this.blocks.add((Block)object);
        } else if (object.getId() == ObjectId.Player) {
            this.avatars.add((Avatar)object);
        } else if (object.getId() == ObjectId.Enemy) {
            this.avatars.add((Avatar)object);
        }
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);e
    }

    /*public void createLevel() {

        for (int yy = 0; yy < Game.HEIGHT+32; yy += 32) {
            addObject(new Block(0, yy, ObjectId.Block));
        }
        for (int xx = 0; xx < Game.WIDTH*2; xx += 32) {
            addObject(new Block(xx,Game.HEIGHT-32, ObjectId.Block));
        }
        for (int xx = 200; xx < 600; xx += 32) {
            addObject(new Block(xx,400, ObjectId.Block));
        }
    }*/

}
