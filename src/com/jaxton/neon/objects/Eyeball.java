package com.jaxton.neon.objects;

import com.jaxton.neon.framework.GameObject;
import com.jaxton.neon.framework.ObjectId;

import java.awt.*;
import java.util.LinkedList;

public class Eyeball extends GameObject {

    boolean forward()

    public Eyeball(float x, float y, ObjectId id)
    {
        super(x, y, id);

    }

    @Override
    public void tick(LinkedList<GameObject> object)
    {

    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.orange);
        g.drawImage();
    }

    @Override
    public Rectangle getBounds()
    {
        return null;
    }
}
